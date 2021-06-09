import Vue from 'vue';
import Vuex from 'vuex';
import http from '@/util/http-common';

Vue.use(Vuex);

export default new Vuex.Store({
  state: {
    apts: [], // 검색한 법정동의 아파트들
    apt: Object, // 하나의 아파트 정보
    histories: [], // 아파트 거래내역들
    boards: [], // 게시판들
    board: Object, // 하나의 게시판 정보,
    dongInforms: [], //시,구,동 정보
    selectedGugun: String,
    selectedDong: String,
    interestingApts: [],
    login: false,
    user: [],
    comments: [], // 댓글
    historyApt: Object, // 거래내역의 아파트
    pm10Data: '',
    pm25Data: '',
    academies: [], // 학원
    games: [], // 오락
    fastfoods: [], // 패스트푸드
    markets: [], // 마켓
    cafes: [], // 커피
    fitnesses: [], // 운동
    theaters: [], // 극장
    selectedItem: Object, //상점 행 클릭 시 선택되는 아이템,
    chartData: [],
    chartLabel: [],
  },
  mutations: {
    RESET_APTS(state) {
      state.apts = [];
      state.pm10Data = '';
      state.pm25Data = '';
    },
    GET_DONG_LIST(state, payload) {
      state.dongInforms = payload;
    },
    GET_APT_LIST(state, payload) {
      state.apts = payload;
      if (state.apts.length == 0) alert('해당 지역 주택 목록이 없습니다.');
    },
    GET_DEAL_HISTORIES(state, payload) {
      state.histories = JSON.parse(JSON.stringify(payload));
      state.histories = state.histories.map((e) => {
        e.dealAmount = e.dealAmount.replace(',', '');
        // e.dealAmount = Number(e.dealAmount);
        var tmp = Math.floor(e.dealAmount / 10000);
        var tmp2 = e.dealAmount % 10000;
        if (tmp2 == 0) {
          e.dealAmount = tmp + '억원';
        } else {
          e.dealAmount = tmp + '억' + tmp2 + '만원';
        }
        e.area = Math.round(e.area * 0.3025) + '평';
        return e;
      });
      // console.log('히스토리 결과 : ' + state.histories);
    },
    GET_BOARD_LIST(state, boards) {
      state.boards = boards;
    },
    SELECT_BOARD(state, board) {
      state.board = board;
    },
    SELECT_GU(state, payload) {
      state.selectedGugun = payload;

      http
        .get(
          'http://openAPI.seoul.go.kr:8088/616e674f4c6e6b6938326250517867/json/RealtimeCityAir/1/25'
        )
        .then((response) => {
          for (var i = 0; i < 25; i++) {
            if (response.data.RealtimeCityAir.row[i].MSRSTE_NM == payload) {
              state.pm10Data = response.data.RealtimeCityAir.row[i].PM10;
              state.pm25Data = response.data.RealtimeCityAir.row[i].PM25;
            }
          }
        });
    },
    SELECT_DONG(state, dong) {
      state.selectedDong = dong;
      state.academies = [];
      state.games = [];
      state.fastfoods = [];
      state.markets = [];
      state.cafes = [];
      state.fitnesses = [];
      state.theaters = [];
      http
        .get('/store', {
          params: {
            dong: dong,
          },
        })
        .then((response) => {
          //학원, 오락, 패스트푸드, 종합소매점, 커피, 운동, 극장
          for (let i = 0; i < response.data.length; i++) {
            if (response.data[i].storecategory.includes('학원'))
              state.academies.push(response.data[i]);
            else if (response.data[i].storecategory.includes('오락'))
              state.games.push(response.data[i]);
            else if (response.data[i].storecategory.includes('패스트'))
              state.fastfoods.push(response.data[i]);
            else if (response.data[i].storecategory.includes('종합소매점'))
              state.markets.push(response.data[i]);
            else if (response.data[i].storecategory.includes('커피'))
              state.cafes.push(response.data[i]);
            else if (response.data[i].storecategory.includes('운동'))
              state.fitnesses.push(response.data[i]);
            else if (response.data[i].storecategory.includes('극장'))
              state.theaters.push(response.data[i]);
          }
        })
        .catch((error) => {
          console.log(error);
        });
    },
    SELECT_ITEM(state, payload) {
      state.selectedItem = payload;
    },

    SET_USER_DATA(state, payload) {
      state.login = true;
      state.user = payload;
      localStorage.setItem('user', payload.id);
      localStorage.setItem('pw', payload.pw);
      localStorage.setItem('name', payload.name);
      localStorage.setItem('addr', payload.addr);
      localStorage.setItem('tel', payload.tel);
    },
    DELETE_USER(state) {
      state.login = false;
      state.user = [];
      localStorage.removeItem('user');
      localStorage.removeItem('pw');
      localStorage.removeItem('name');
      localStorage.removeItem('addr');
      localStorage.removeItem('tel');
    },
    GET_INTERESTING_APTS(state, payload) {
      state.interestingApts = payload;
    },
    UPDATE_USER_INFORM(state, updateUser) {
      console.log(updateUser);
      state.user = updateUser;
      localStorage.setItem('user', JSON.parse(updateUser).id);
      localStorage.setItem('pw', JSON.parse(updateUser).pw);
      localStorage.setItem('name', JSON.parse(updateUser).name);
      localStorage.setItem('addr', JSON.parse(updateUser).addr);
      localStorage.setItem('tel', JSON.parse(updateUser).tel);
      console.log(state.user);
    },
    GET_COMMENTS(state, comments) {
      state.comments = comments;
    },
    SET_HISTORY_APT(state, apt) {
      state.historyApt = apt;
    },
    SET_CHART_DATA(state, payload) {
      let tmp = JSON.parse(JSON.stringify(payload));
      state.chartData = [];
      state.chartLabel = [];
      for (let i = payload.length - 1; i >= 0; i--) {
        state.chartData.push(Number(tmp[i].dealAmount.replace(',', '')));
        state.chartLabel.push(tmp[i].dealYear + '-' + tmp[i].dealMonth + '-' + tmp[i].dealDay);
      }
    }
  },
  actions: {
    resetApts({ commit }) {
      commit('RESET_APTS');
    },
    getDongList({ commit }, gugun) {
      // select option 시에 따른 동 가져오기
      http
        .get('/dong', {
          params: {
            gugun: gugun,
          },
        })
        .then((response) => {
          commit('GET_DONG_LIST', response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },

    getAptList({ commit }, dong) {
      // 선택한 동으로 주택 목록 받아오기
      http
        .get('/house', {
          params: {
            dong: dong,
          },
        })
        .then((response) => {
          // console.log(response.data);
          commit('GET_APT_LIST', response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },

    getDealHistories(context, apt) {
      // 선택한 아파트의 거래내역 불러오기
      http
        .get('/house/detail', {
          params: {
            dong: apt.dong,
            AptName: apt.aptName,
          },
        })
        .then((response) => {
          context.commit('GET_DEAL_HISTORIES', response.data);
          context.dispatch('setChartData', response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },

    getBoardList({ commit }) {
      http
        .get('/board/list')
        .then((response) => {
          // console.log(response.data[0]);
          commit('GET_BOARD_LIST', response.data);
        })
        .catch((error) => {
          console.log('통신 실패');
          console.dir(error);
        });
    },
    selectBoard({ commit }, board) {
      commit('SELECT_BOARD', board);
    },
    selectGu({ commit }, gu) {
      commit('SELECT_GU', gu);
    },
    login({ commit }, userdata) {
      http.post('/user/login', userdata).then(({ data }) => {
        if (data.id != null) {
          commit('SET_USER_DATA', data);
          console.log(data);
        } else {
          alert('로그인에 실패하였습니다');
        }
      });
    },
    logout({ commit }) {
      commit('DELETE_USER');
      alert('로그아웃 되었습니다.');
    },

    addInteresting(context, data) {
      http.post('/interesting', data).then(({ data }) => {
        if (data === 'SUCCESS') {
          console.log(context.dispatch.length); // context 사용하기 용
          alert('등록에 성공하였습니다');
        } else {
          alert('등록에 실패하였습니다.');
        }
      });
    },

    getInterestingApts({ commit }) {
      http
        .get('/interesting', {
          params: {
            id: localStorage.getItem('user'),
          },
        })
        .then((response) => {
          // console.log(response.data);
          commit('GET_INTERESTING_APTS', response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },

    deleteInteresting(context, data) {
      http
        .delete('/interesting', {
          params: {
            id: data.id,
            dong: data.dong,
            aptName: data.aptName,
          },
        })
        .then(() => {
          alert('관심주택 목록에서 삭제하였습니다.');
          context.dispatch('getInterestingApts');
        })
        .catch((error) => {
          console.log(error);
        });
    },

    updateUserInform({ commit }, updateUser) {
      http.put('/user', updateUser).then(({ data }) => {
        let msg = '수정 시 문제가 발생하였습니다.';
        if (data === 'SUCCESS') {
          msg = '수정이 완료되었습니다.';
          commit('UPDATE_USER_INFORM', updateUser);
        }
        alert(msg);
      });
    },

    getComments({ commit }, boardno) {
      http
        .get('/comment', {
          params: {
            boardno: boardno,
          },
        })
        .then((response) => {
          commit('GET_COMMENTS', response.data);
        })
        .catch((error) => {
          console.log(error);
        });
    },

    updateComment(context, comment) {
      console.log(comment);
      http
        .put('/comment', {
          userid: localStorage.getItem('user'),
          content: comment.content,
          boardno: comment.boardno,
          regtime: comment.regtime,
        })
        .then(({ data }) => {
          let msg = '댓글 수정 시 문제가 발생하였습니다.';
          if (data === 'SUCCESS') {
            msg = '댓글 수정이 완료되었습니다.';
            context.dispatch('getComments', comment.boardno);
          }
          alert(msg);
        })
        .catch((error) => {
          console.log(error);
        });
    },

    deleteComment(context, comment) {
      http
        .delete('/comment', {
          params: {
            userid: localStorage.getItem('user'),
            boardno: comment.boardno,
            regtime: comment.regtime,
          },
        })
        .then(({ data }) => {
          let msg = '댓글 삭제 시 문제가 발생하였습니다.';
          if (data === 'SUCCESS') {
            msg = '댓글 삭제가 완료되었습니다.';
            context.dispatch('getComments', comment.boardno);
          }
          alert(msg);
        })
        .catch((error) => {
          console.log(error);
        });
    },

    setHistoryApt({ commit }, apt) {
      commit('SET_HISTORY_APT', apt);
    },

    selectDong({ commit }, dong) {
      commit('SELECT_DONG', dong);
    },
    selectItem({ commit }, item) {
      commit('SELECT_ITEM', item);
    },
    setChartData({ commit }, data) {
      commit('SET_CHART_DATA', data);
    },
    deleteUser({ commit }) {
      http
        .delete('/user', {
          params: {
            id: localStorage.getItem('user')
          },
        })
        .then(({ data }) => {
          let msg = '회원 탈퇴 시 문제가 발생하였습니다.';
          if (data === 'SUCCESS') {
            msg = '회원 탈퇴가 완료되었습니다.';
            commit('DELETE_USER');
          }
          alert(msg);
        })
        .catch((error) => {
          console.log(error);
        });
    }
  },
  getters: {
    getDong(state) {
      return state.dongInforms;
    },
  },
  modules: {},
});

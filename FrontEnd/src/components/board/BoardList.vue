<template>
  <div class="board-list-page">
      <br><h3>📢자유게시판📢</h3><br>
    <div>
    <b-container class="bv-example-row mt-3">
    <b-table 
        hover 
        :items="boards" 
        :fields="fields"
        :per-page="perPage"
        :current-page="currentPage" 
        id="boardTable" 
        @row-clicked="rowClick">
    </b-table>
    </b-container>
    <b-pagination align="center"
        v-model="currentPage"
        :total-rows="rows"
        :per-page="perPage"
        aria-controls="boardTable"></b-pagination>
    <b-button v-if="login" @click="goWrite">글쓰기</b-button>
    </div>
  </div>
</template>

<script>
import {mapActions, mapState} from 'vuex';

export default {
    name: 'BoardListPage',
    data(){
        return{
            perPage: 5,
            currentPage:1,
            fields: [
                {key: 'no', label: '글번호'},
                {key: 'title', label: '제목'},
                {key: 'writer', label: '작성자'},
                {key: 'regtime', label: '작성일'}],
        }
    },
    components:{

    },
    computed:{
        ...mapState(['boards', 'login']),
        rows(){
            return this.boards.length
        }
    },
    methods:{
        ...mapActions(['getBoardList', 'selectBoard', 'getComments']),
        rowClick(item){
            this.selectBoard(item);
            this.getComments(item.no);
            this.$router.push({
                path: `/board/detail/${item.no}`
            })
        },
        goWrite(){
          this.$router.push({
            path: '/board/write'
          })
        }
    },
    created(){
        this.getBoardList();
    }
}
</script>

<style>
table{
    text-align: center;
}
</style>
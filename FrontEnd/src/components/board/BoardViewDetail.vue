<template>
  <div align="center">
    <br><h3>❗게시글 상세보기❗</h3><br>
    <b-table striped hover :items="items" :fields="fields" style="width:700px;"></b-table>
     <b-form-textarea :value="this.board.content" style="width: 700px; height: 350px;" readonly></b-form-textarea><br>
    <span v-if="this.board.writer == this.writer">
      <b-button variant="secondary" @click="updateData" style="margin-right:5px">수정</b-button>
      <b-button variant="secondary" @click="deleteData" style="margin-right:5px">삭제</b-button>
    </span>
    <b-button variant="secondary" @click="toMain">목록</b-button>
    <comment-write v-if="writer" style="margin-top:30px;"/>
    <div v-for="(comment,idx) in comments" :key="idx" style="margin-top:30px">

        <b-container class="bv-example-row" style="width:700px;" align="left">
          <b-row>
            <b-col>작성자 : {{comment.userid}}</b-col>
            <b-col>작성시간 : {{comment.regtime}} </b-col>
          </b-row>
        </b-container>
      <b-form-textarea :id="'text'+idx" :value="comment.content" style="width: 700px; height: 50px;" readOnly=true></b-form-textarea>
      <b-container class="bv-example-row" style="width:700px;" align="left">
          <b-row>
            <b-col v-if="comment.userid==writer" align="right" style="margin:5px">
              <b-button v-if="status" @click="readonlyFalse(idx)" style="margin-right:5px">수정</b-button>
              <b-button v-if="!status" @click="updateCmt(comment, idx)" style="margin-right:5px">등록</b-button>
              <b-button @click="deleteCmt(comment)">삭제</b-button>
            </b-col>
          </b-row>
        </b-container>

    </div>
  </div>
</template>

<script>
import { mapState, mapActions} from 'vuex';
import http from '@/util/http-common.js';
import CommentWrite from './CommentWrite.vue';

export default {
  name: "ContentDetail",
  components:{
    CommentWrite
  },
  data() {
    return {
      writer : localStorage.getItem('user'),
      items:[],
      fields: [
        {key: 'no', label: '글번호'},
        {key: 'title', label: '글제목'},
        {key: 'writer', label: '글쓴이'},
        {key: 'regtime', label: '작성시간'}
      ],
      fields2: [
        {key: 'userid', label: '작성자'},
        {key: 'content', label: '내용'},
        {key: 'regtime', label: '작성시간'}
      ],
      status: true
    };
  },
  created(){
    this.items.push(this.board);
    console.log(this.board.no);
    console.log(this.board.title);
    console.log(this.board.writer);
  },
  computed:{
    ...mapState(['board', 'login','comments'])
  },
  methods: {
    ...mapActions(['updateComment', 'deleteComment', 'getComments']),
    deleteData() {
      http.delete('/board/'+this.board.no)
      .then(({data}) => {
        console.log(data);
        let msg = "삭제 시 문제가 발생하였습니다.";
        if(data === "SUCCESS"){
          msg = "삭제되었습니다.";
        }
        alert(msg);
      })
      this.$router.push({
        path: '/board'
      })
    },
    updateData() {
      this.$router.push({
        path: `/board/write/${this.board.no}`
      })
    },
    toMain() {
      this.$router.push('/board');
    },
    updateCmt(comment, idx){
      const commentContent = document.querySelector('#text'+idx).value;
      console.log(this.board.no);
      this.updateComment({content: commentContent, boardno: this.board.no, regtime: comment.regtime});
      document.querySelector('#text'+idx).readOnly=true;
      this.status = true;
    },
    deleteCmt(comment){
      this.deleteComment({boardno: this.board.no, regtime: comment.regtime});
    },
    readonlyFalse(idx){
      document.querySelector('#text'+idx).readOnly=false;
      this.status = false;
      console.log(idx);
    }
  }
};
</script>

<style scoped>
table.b-table thead th.w20{ width: 20%; }

</style>
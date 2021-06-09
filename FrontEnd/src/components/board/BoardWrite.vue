<template>
  <div align="center">
      <br><h3>글쓰기</h3><br>
      <b-form-input v-model="title" placeholder="제목을 입력해 주세요"></b-form-input>
      <b-form-textarea id="content" v-model="content" placeholder="내용을 입력해 주세요" rows="10" max-rows="15"></b-form-textarea>
      <br>
      <b-button variant="primary" @click="updateMode ? update() : upload()">저장</b-button>
      <b-button variant="danger" @click="reset">취소</b-button>
  </div>
</template>

<script>
import http from '@/util/http-common'
import {mapState} from 'vuex';

export default {
    name: 'Write',
    data(){
        return{
            title:'',
            content:'',
            updateMode: this.$route.params.no > 0 ? true : false
        }
    },
    computed:{
        ...mapState(['board'])
    },
    methods:{
        reset(){
            this.$router.push({
                path: '/board'
            })
        },
        upload(){
            http.post("/board",{
                writer: localStorage.getItem('user'),
                title: this.title,
                content: this.content
            }).then(({data}) => {
                let msg = "업로드 시 문제가 발생하였습니다.";
                if(data === "SUCCESS"){
                    msg = "업로드가 완료되었습니다.";
                }
                alert(msg);
                this.$router.push({
                path: '/board'
            })
            })
        },
        update(){
            http.put('/board',{
                no: this.board.no,
                title: this.title,
                content: this.content
            })
            .then(({data}) => {
                // console.log(data);
                let msg = "수정 시 문제가 발생하였습니다.";
                if(data === "SUCCESS"){
                    msg = "수정이 완료되었습니다.";
                }
                alert(msg);
            })
            this.$router.push({
                path: '/board'
            })
        }
    },
    created(){
        if(this.$route.params.no > 0){
            // console.log(this.$route.params.no)
            this.title = this.board.title;
            this.content = this.board.content;
        }
    }
}
</script>

<style scoped>
input{
    width:70%
}
textarea{
    width:70%
}
button{
    width:15%
}
</style>
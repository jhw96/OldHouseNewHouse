<template>
    <div class="comment" align="center">
        <table width="700px">
            <tr>
                <td><b-form-textarea 
                v-model="content"
                placeholder="댓글을 작성해주세요"
                rows="3"
                max-rows="6"
                style="width:600px"></b-form-textarea></td>
                <td><b-button variant="secondary" @click="upload">댓글 등록</b-button></td>
            </tr>
        </table>
    </div>
</template>
<script>
import { mapState, mapActions } from 'vuex';
import http from '@/util/http-common'

export default{
    data(){
        return{
            content: ''
        }
    },
    computed:{
        ...mapState(['board'])
    },
    methods:{
        ...mapActions(['getComments']),
        upload(){
            console.log("클릭");
            console.log(this.board);
            http
                .post('/comment', {
                    userid: localStorage.getItem('user'),
                    content: this.content,
                    boardno: String(this.board.no),
                })
                .then((response) => {
                    let msg = '댓글쓰기 실패하였습니다.';
                    if (response.data == 'SUCCESS') {
                        msg = '댓글쓰기 성공하였습니다.';
                        this.content = '';
                    }
                    alert(msg);
                    this.getComments(this.board.no);
                })
                .catch((error) => {
                console.log(error);
                });
        }
    }
}
</script>
<style>
</style>
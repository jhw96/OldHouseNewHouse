<template>
    <div>
    <b-card style="width:500px">
    <b-form>
      <table>
          <tr>
            <td>이름</td>
            <td><b-form-input id="inputName" v-model="form.name" required></b-form-input></td>
          </tr>
          <tr>
              <td>아이디</td>
              <td><b-form-input id="inputId" v-model="form.id" required readonly></b-form-input></td>
          </tr>
          <tr>
              <td>비밀번호</td>
              <td><b-form-input id="inputPassword" v-model="form.pw" type="password" required></b-form-input></td>
          </tr>
          <tr>
              <td>비밀번호 확인</td>
              <td><b-form-input id="inputPasswordVerify" v-model="pwVerify" type="password" required></b-form-input></td>
          </tr>
          <tr>
              <td>주소</td>
              <td><b-form-input id="inputAddr" v-model="form.addr" type="text" required></b-form-input></td>
          </tr>
          <tr>
              <td>전화번호</td>
              <td><b-form-input id="inputTel" v-model="form.tel" type="tel" required></b-form-input></td>
          </tr> 
      </table>
      <br>
      <b-button type="submit" @click="update" variant="primary">수정완료</b-button>
      <b-button type="button" @click="goMain" variant="danger">취소</b-button>
    </b-form>
    <b-button type="button" @click="deleteAccount" style="background-color:rgb(233,236,239); border-color:rgb(233,236,239); color:rgb(108, 117, 125); width:340px">회원탈퇴</b-button>
    </b-card>
  </div>
</template>
<script>
import {mapActions} from 'vuex';

export default{
    name: 'ModifyForm',
    data(){
        return{
            form:{
            id: localStorage.getItem('user'),
            pw: localStorage.getItem('pw'),
            name: localStorage.getItem('name'),
            addr: localStorage.getItem('addr'),
            tel: localStorage.getItem('tel')},
            pwVerify: localStorage.getItem('pw')
        }
    },
    mounted(){
        console.log(this.user);
    },
    methods:{
        ...mapActions(['updateUserInform', 'deleteUser']),
        update(){
            this.updateUserInform(JSON.stringify(this.form));
            this.$router.push({
                path: '/'
            })
        },
        goMain(){
            this.$router.push({
                path: '/'
            })
        },
        deleteAccount(){
            this.deleteUser();
            this.goMain();
        }
    }
}
</script>
<style scoped>
button{
    width: 35%;
    margin: 5px
}
td{
  text-align:right;
  padding: 5px;
  padding-right: 10px;
  padding-left: 10px;
}
</style>
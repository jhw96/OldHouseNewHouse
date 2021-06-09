<template>
  <div>
    <b-card style="width:500px">
    <b-form v-if="show">
      <table>
        <tr>
          <td>이름</td>
          <td><b-form-input id="inputName" v-model="form.name" placeholder="이름을 입력해주세요" required></b-form-input></td>
        </tr>
        <tr>
          <td>아이디</td>
          <td><b-form-input id="inputId" v-model="form.id" placeholder="아이디를 입력해주세요" required></b-form-input></td>
        </tr>
        <tr>
          <td>비밀번호</td>
          <td><b-form-input id="inputPassword" v-model="form.pw" placeholder="비밀번호를 입력해주세요" type="password" required></b-form-input></td>
        </tr>
        <tr>
          <td>비밀번호 확인</td>
          <td><b-form-input id="inputPasswordVerify" v-model="pwVerify" placeholder="비밀번호를 재입력해주세요" type="password" required></b-form-input></td>
        </tr>
        <tr>
          <td>주소</td>
          <td><b-form-input id="inputAddr" v-model="form.addr" type="text" placeholder="주소를 입력해주세요" required></b-form-input></td>
        </tr>
        <tr>
          <td>전화번호</td>
          <td><b-form-input id="inputTel" v-model="form.tel" type="tel" placeholder="전화번호를 입력해주세요" required></b-form-input></td>
        </tr>
      </table>
      <br>
      <b-button type="button" variant="primary" @click="onSubmit">회원가입</b-button>
      <b-button type="button" variant="danger" @click="onReset">초기화</b-button>
    </b-form>
    </b-card>
  </div>
</template>

<script>

import http from "@/util/http-common.js";

  export default {
    data() {
      return {
        form: {
          id: '',
          pw: '',
          name: '',
          addr: '',
          tel: ''
        },
        pwVerify: '',
        show: true
      }
    },
    methods: {
      onSubmit() {
        if(this.form.pw != this.pwVerify){
          alert("비밀번호를 확인하세요!");
        }else{
          http
        .post("/user/join",{
          id: this.form.id,
          pw: this.form.pw,
          name: this.form.name,
          addr: this.form.addr,
          tel: this.form.tel
        }).then(({data}) => {
          let msg = '회원가입 시 문제가 발생하였습니다.';
          if(data == 'SUCCESS') {
            msg = '회원가입이 완료되었습니다!';
            alert(msg);
            this.$router.push('/login');
          }else if(data == 'DUPLICATE'){
            msg = '중복된 아이디입니다.';
            alert(msg);
          }
        }).catch((error) => {
          alert('회원가입이 실패하였습니다!');
          this.onReset();
          console.log(error);
        })
        }
      },
      onReset() {
        this.form.addr = ''
        this.form.id=''
        this.form.name = ''
        this.form.pw = ''
        this.pwVerify = ''
        this.form.tel = ''
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
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
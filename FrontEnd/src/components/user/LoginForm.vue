<template>
    <div>
      <b-card style="width: 500px">
        <b-form @submit="onSubmit" @reset="onReset" v-if="show">
          <table>
            <tr>
              <td>아이디</td>
              <td><b-form-input id="inputId" v-model="form.id" placeholder="아이디를 입력해주세요" required></b-form-input></td>
            </tr>
            <tr>
              <td>비밀번호</td>
              <td><b-form-input id="inputPassword" v-model="form.pw" placeholder="비밀번호를 입력해주세요" type="password" required></b-form-input></td>
            </tr>
          </table>
            <br>
            <b-button type="submit" variant="primary" @click="tryLogin">로그인</b-button>
        </b-form>
        </b-card>
    </div>
</template>
<script>
import {mapActions} from 'vuex';


export default{
    data() {
      return {
        form: {
          id: '',
          pw: ''
        },
        show: true
      }
    },
    methods: {
      ...mapActions(['login']),
      onSubmit(event) {
        event.preventDefault()
      },
      onReset(event) {
        event.preventDefault()
        this.form.id=''
        this.form.pw = ''
        this.show = false
        this.$nextTick(() => {
          this.show = true
        })
      },
      tryLogin(){
        this.login(JSON.stringify(this.form));   
        this.$router.push({name: 'Home'})
      }
    }
}
</script>
<style scoped>
button{
    width: 70%
}
td{
  text-align: right;
  padding: 5px;
  padding-right: 10px;
  padding-left: 10px;
}
</style>

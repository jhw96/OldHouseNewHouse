<template>
  <div class="login" align="center">
    <br><h3>🔔로그인🔔</h3><br>
    <login-form/><br>
    <p><router-link :to="{name: 'SignUp'}">회원가입 하기</router-link></p>
  </div>
</template>
<script>
import LoginForm from '@/components/user/LoginForm.vue';
export default{
  name: 'Login',
  components:{
    LoginForm
  }
}
</script>

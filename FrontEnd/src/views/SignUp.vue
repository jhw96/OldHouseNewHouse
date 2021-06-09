<template>
  <div class="signup" align="center">
    <br><h3>🔔회원가입🔔</h3><br>
    <signup-form/>
  </div>
</template>
<script>
import SignupForm from '@/components/user/SignupForm.vue';
export default{
  name: 'Signup',
  components:{
    SignupForm
  }
}
</script>
<style scoped>
</style>
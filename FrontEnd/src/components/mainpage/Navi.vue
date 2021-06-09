<template>
  <div>
    <div v-if="!login">
      <b-nav align="right">
        <b-nav-item to="/login">로그인</b-nav-item>
        <b-nav-item to="/signup">회원가입</b-nav-item>
      </b-nav>
    </div>
    <b-nav v-else align="right">
      <b-nav-item @click="tryLogout">로그아웃</b-nav-item>
      <b-nav-item to="/modifyInform">회원정보수정</b-nav-item>
    </b-nav>
    <div>
      <b-card-header header-tag="nav">
      <b-nav card-header tabs fill >
          <b-nav-item  to="/" style="font-weight:bold" @click="aptReset">메인페이지</b-nav-item>
          <b-nav-item  to="/wish" style="font-weight:bold" @click="getWishList">관심주택</b-nav-item>
          <b-nav-item  to="/board" style="font-weight:bold">자유게시판</b-nav-item>
          <b-nav-item  to="/about" style="font-weight:bold">어바웃</b-nav-item>
      </b-nav>
      </b-card-header>
    </div>
  </div>
</template>

<script>
import {mapState, mapActions} from 'vuex';

export default {
    name: 'Navi',
    computed:{
      ...mapState(['login','user'])
    },
    methods:{
      ...mapActions(['logout','getInterestingApts','resetApts']),
      
      tryLogout(){
        this.logout();
        this.$router.push('/login');
      },

      getWishList() {
        this.getInterestingApts();
      },
      aptReset() {
        this.resetApts();
      }
    }
}
</script>
<style scoped>
</style>
<template>
  <div id="app">
    <navi />
    <router-view />
  </div>
</template>

<script>
import Navi from "@/components/mainpage/Navi.vue";

export default{
  el : "#app",
  name : "App",
  components: {
    Navi
  }
}


</script>
<style scoped>
@import url('https://fonts.googleapis.com/css2?family=Jua&family=Noto+Sans+KR:wght@300&display=swap');
*{
  font-family: 'Jua', sans-serif !important;
  letter-spacing: 1px;
  font-size: 1.2rem;
}
</style>
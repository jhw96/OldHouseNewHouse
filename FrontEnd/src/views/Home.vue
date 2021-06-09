<template>
  <div class="home" align="center">
    <br>
    <search/>
    <air-pollution></air-pollution>
    <store-status></store-status>
    <apt-list />
  </div>
</template>

<script>
import Search from "@/components/mainpage/Search.vue";
import AptList from "@/components/apt/AptList.vue";
import AirPollution from '@/components/mainpage/AirPollution.vue';
import {mapState} from 'vuex';
import StoreStatus from '@/components/dong/StoreStatus.vue';


export default {
  name: "Home",
  components: {
    AptList,
    Search,
    AirPollution,
    StoreStatus
  },
  computed:{
    ...mapState(['apts'])
  },
  methods:{
    goDong(){
      this.$router.push('/donginfo');
    }
  }
};
</script>

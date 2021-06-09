<template>
  <div class="search">
    <b-form-select class="mt-3" size="lg" @change="fetchGu_" :disabled="!sido_.length">
      <b-form-select-option value="" selected disabled>시/도</b-form-select-option>
      <b-form-select-option v-for="sido in sido_" :key="sido.name" :value="sido.name">{{sido.name}}</b-form-select-option>
    </b-form-select>
    <b-form-select v-model="selectedGu" @change="fetchDong_" :disabled="!gu_.length">
      <b-form-select-option value="" selected disabled>구/군</b-form-select-option>
      <b-form-select-option v-for="gu in gu_" :key="gu.name" :value="gu.name">{{gu.name}}</b-form-select-option>
    </b-form-select>
    <b-form-select v-model="selectedDong" :disabled="!dongInforms.length">
        <b-form-select-option value="" selected disabled>동</b-form-select-option>
        <b-form-select-option v-for="(dongInform,idx) in dongInforms" :key="idx" :value="dongInform.dong">{{ dongInform.dong }}</b-form-select-option>
    </b-form-select>
    <b-button variant="primary" @click="search">검색</b-button>
  </div>
</template>

<script>
import gu_ from "./gugun";
import sido_ from "./sido";
import {mapState, mapActions} from 'vuex';


export default {
  name: "Search",
  data(){
    return{
      gu_: [],
      sido_: [],
      selectedGu:'',
      selectedDong: ''
    }
  },
  components: {

  },
  computed:{
    ...mapState(['dongInforms']),
  },
  methods:{
    ...mapActions(['getDongList','getAptList', 'selectGu','selectDong']),
    async fetchGu_(){
      this.gu_ = gu_; //구 가져오기
    },
    async fetchSi_(){
      this.sido_ = sido_; //시도 가져오기
    },
    fetchDong_(){
      this.getDongList(this.selectedGu);
      
    },
    search() {
      this.getAptList(this.selectedDong);
      this.selectGu(this.selectedGu);
      this.selectDong(this.selectedDong);
    }
  },
  mounted(){
    this.fetchSi_();
  }
};
</script>
<style scoped>

select{
  text-align-last: center;

  width: 150px;
  height: 50px;
  margin: 15px;
  border-radius: .5em;
}
select:hover{
  border-color: #0275d8;
}
option{
  padding: 10px
}
button{
  margin-left: 15px;
}
</style>
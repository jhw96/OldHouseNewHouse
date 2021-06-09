<template>
  <div align="center" style="overflow:auto;">
      <br><h3>📋거래내역📋</h3><br>
      <b-button v-if="!show" type="button" @click="showChart">차트보기</b-button>
      <b-button v-if="show" type="button" @click="showChart">차트가리기</b-button>
      <div style="width:1600px;">
      <history-map style="float:left; margin-left:100px;"></history-map>
       <b-container class="bv-example-row mt-3">
            <div style="float:left; width:900px; margin-left:50px;">
            <b-table :items="histories" :fields="fields" id="aptTable" :per-page="perPage" :current-page="currentPage">
            </b-table>
            <b-pagination align="center" v-model="currentPage" :total-rows="rows" :per-page="perPage" aria-controls="aptTable"></b-pagination>
            </div>
      </b-container>
      </div>
      <vue-chart v-if="show"></vue-chart>
  </div>
</template>

<script>
import {mapState} from 'vuex';
import HistoryMap from '@/components/apt/HistoryMap.vue';
import VueChart from '@/components/chart/VueChartJS.vue';


export default {
  name: 'AptDetail',
  data(){
        return{
            perPage: 8,
            currentPage: 1,
            fields:[
                {key: 'no', label: '번호'},
                {key: 'dong', label: '법정동'},
                {key: 'aptName', label: '아파트이름'},
                {key: 'dealAmount', label: '거래금액'},
                {key: 'dealYear', label: '거래년도'},
                {key: 'dealMonth', label: '거래달'},
                {key: 'dealDay', label: '거래일'},
                {key: 'area', label: '면적'},
                {key: 'floor', label: '층 수'},
                {key: 'jibun', label: '지번' }
            ],
            items:[],
            pm10Data:'',
            pm25Data:'',
            show: false,
        }
    },
  computed: {
    ...mapState(['histories', 'selectedGugun']),
    rows(){
            return this.histories.length
        }
  },
  components:{
    HistoryMap,
    VueChart
  },
  methods:{
    showChart() {
      this.show = !this.show;
    }
  }
}
</script>

<style>
</style>
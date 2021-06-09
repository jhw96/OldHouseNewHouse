<template>
  <div class="wish" align="center">
    <br><h3>⭐관심 주택⭐</h3><br>

     <b-container class="bv-example-row mt-3">
            <b-table hover :items="interestingApts" :fields="fields" id="aptTable" :per-page="perPage"  @row-clicked="rowClick" :current-page="currentPage">
            <template v-slot:cell(삭제)="{item}">
                    <button style="width:18px; height:18px; cursor:pointer" @click="deleteWish(item)">❌</button>
                </template>
            </b-table>
            <b-pagination align="center" v-model="currentPage" :total-rows="rows" :per-page="perPage" aria-controls="aptTable"></b-pagination>
      </b-container>
  </div>
</template>

<script>
import {mapState, mapActions} from 'vuex';

export default{
  name: 'Wish',
  data(){
        return{
            perPage: 5,
            currentPage: 1,
            fields:[
              {key: 'dong', label: '법정동'},
              {key: 'aptName', label: '아파트 이름'},
              '삭제'
            ]
        }
    },
  computed:{
    ...mapState(['interestingApts']),
     rows(){
            return this.interestingApts.length
        }
  },
  methods: {
    ...mapActions(['getDealHistories','deleteInteresting','setHistoryApt']),
    rowClick(item){
          this.setHistoryApt(item);
          this.getDealHistories({dong: item.dong, aptName: item.aptName});
          this.$router.push('/aptdetail');
      },
      
      deleteWish(item) {
        this.deleteInteresting({
          dong : item.dong, 
          aptName: item.aptName, 
          id : localStorage.getItem("user")
        })
      }
  }
}
</script>
<style scoped>

</style>
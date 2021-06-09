<template>
  <div>
      <span v-if="apts.length != 0">
          학원👩‍🏫 : {{academies.length}} | 
          오락🎮 : {{games.length}} | 
          패스트푸드🍔 : {{fastfoods.length}} | 
          마트🛒 : {{markets.length}} | 
          카페☕ : {{cafes.length}} | 
          운동🏋️‍♂️ : {{fitnesses.length}} | 
          극장🎪 : {{theaters.length}}
          <b-button @click="moveDetail">상세보기</b-button>
      </span>
  </div>
</template>

<script>
import {mapState,mapActions} from "vuex";

export default {
    name: 'StoreStatus',
    computed:{
        ...mapState(['apts','academies','games','fastfoods','markets','cafes','fitnesses','theaters'])
    },
    methods:{
        ...mapActions(['selectItem']),
        moveDetail() {
            this.selectItem(this.academies[0]);
            this.$router.push('/store');
        }
    }
}
</script>

<style>

</style>
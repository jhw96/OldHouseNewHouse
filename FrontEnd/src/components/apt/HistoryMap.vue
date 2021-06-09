<template>
 <div v-if="this.historyApt">
     <GmapMap ref="mapRef" :center="{lat : historyApt.lat *= 1 , lng : historyApt.lng*=1}" :zoom="13" style="width:360px; height:360px">
         <GmapMarker 
         :position="{lat : historyApt.lat*=1 , lng : historyApt.lng*=1}"
         :label="historyApt.aptName"
          />
     </GmapMap>
 </div>
</template>

<script>
import {mapState} from 'vuex';

export default {
    name: "OneMap",
    computed:{
        ...mapState(['historyApt'])
    }
}
</script>


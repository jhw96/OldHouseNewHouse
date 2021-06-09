<template>
  <div v-if="selectedArr.length != 0">
     <GmapMap ref="mapRef" :center="{lat: selectedItem.lat *=1, lng: selectedItem.lng*=1}" :zoom="17" style="width:1000px; height:400px">
         <GmapMarker 
         :key="index" 
         v-for="(store, index) in selectedArr" 
         :position="{lat : store.lat*=1 , lng : store.lng*=1}"
         :title="'[' + store.addr + '] ' + store.storename"
         :clickable="true"
         :icon="{ url: require('../../assets/'+img+'.png')}" 
         @click="toggleInfo(store, index)"
         />
         <GmapInfoWindow
          @closeclick="window_open=false"
          :opened="window_open"
         :position="infoWindowPos"><div v-html="infoContent"/></GmapInfoWindow>
     </GmapMap>
 </div>
</template>

<script>
import {mapState} from 'vuex';

export default {
    name:'StoreMap',
    props:{
        selectedArr:[],
        selectedCate: String
    },
    data(){
        return{
            img:String,
            window_open: false,
            infoContent: '',
            infoWindowPos:{
                lat:0,
                lng:0
            },
            currentMidx: null
        }
    },
    computed:{
        ...mapState(['selectedItem']),

    },
    updated() {
        if(this.selectedCate == 'academies')
            this.img = 'academy';
        else if(this.selectedCate == 'games')
            this.img = 'game';
        else if(this.selectedCate == 'fastfoods')
            this.img = 'fastfood';
        else if(this.selectedCate == 'markets')
            this.img = 'market';
        else if(this.selectedCate == 'cafes')
            this.img = 'cafe';
        else if(this.selectedCate == 'fitnesses')
            this.img = 'fitness';
        else
            this.img = 'theater';

    },
    methods:{
        toggleInfo(marker, index){
            this.infoWindowPos.lat = marker.lat;
            this.infoWindowPos.lng = marker.lng;
            this.infoContent = marker.storename;
            if(this.currentMidx == index){
                this.window_open = !this.window_open;
            }else{
                this.window_open = true;
                this.currentMidx = index;
            }
        }
    }
}
</script>
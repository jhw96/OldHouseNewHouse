<template>
  <div style="width:1200px; margin-top:50px;">
      <google-map v-if="this.apts.length != 0" style="float:left; margin-left: 60px;"></google-map>
    <div style="height: 500px; width:700px; overflow:auto;">
        <b-container v-if="apts && apts.length != 0" class="bv-example-row mt-3" style="float:left;">
            <!-- <apt-list-item v-for="(apt, index) in apts" :key="index" :apt="apt" /> -->
            <b-table hover :items="apts" :fields="computedFields" id="aptTable" @row-clicked="rowClick" :per-page="perPage" :current-page="currentPage">
                <template v-slot:cell(관심주택_추가)="{item}">
                    <button @click="addWish(item)" style="background-color:transparent; width:18px; height:18px; cursor:pointer">⭐</button>
                </template>
            </b-table>
            <b-pagination align="center" v-model="currentPage" :total-rows="rows" :per-page="perPage" aria-controls="aptTable"></b-pagination>
        </b-container>
        <b-container v-else class="bv-example-row mt-3">
            <b-row>
                <b-col><img src="../../img/main.png" alt="happyhouse" style="width: 680px; height: 450px;"></b-col>
            </b-row>
        </b-container>
    </div>
  </div>
</template>

<script>
// import AptListItem from "@/components/apt/AptListItem.vue";
import GoogleMap from "@/components/apt/Map.vue";
import {mapState, mapActions} from "vuex";

export default {
    name: 'AptList',
    data(){
        return{
            perPage: 5,
            currentPage: 1,
            fields:[
                {key: 'no', label: '번호'},
                {key: 'aptName', label: '아파트 이름'},
                {key: 'buildYear', label: '건축년도'},
                '관심주택_추가'
            ],
            user: localStorage.getItem('user')
        }
    },
    components: {
        // AptListItem,
        GoogleMap
    },
    computed: {
        ...mapState(['apts', 'login']),
        rows(){
            return this.apts.length
        },
        computedFields(){
            return this.fields;
            // if(this.login){
            //     return this.fields;
            // }else{
            //     return this.fields.filter(field => !field.requireLogin);
            // }
        }
    },
    methods:{
        ...mapActions(['getDealHistories', 'addInteresting','setHistoryApt']),
        rowClick(item){
            this.setHistoryApt(item);
            this.getDealHistories({dong: item.dong, aptName: item.aptName});
            this.$router.push({
                path: `/aptdetail`
            })
        },
        addWish(item){
            console.log(JSON.stringify(item));
            this.addInteresting({
                aptName: item.aptName,
                dong: item.dong,
                id: localStorage.getItem('user'),
                lat: item.lat,
                lng: item.lng
            })
        }
    }
    
}
</script>

<style>
table{
    text-align: center;
}
</style>
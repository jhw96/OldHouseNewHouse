<template>
<div>
    <span align="center">
    <br><h3>🌏{{selectedDong}} 상권정보🌏</h3><br>
    </span>
    <div style="margin-top:30px;">
        <div style="margin-left:200px; margin-top:30px; float:left;">
            <b-form-radio v-model="selectedCategory" @change="click" value="academies">👩‍🏫학원</b-form-radio>
            <b-form-radio v-model="selectedCategory" @change="click" value="games">🎮오락</b-form-radio>
            <b-form-radio v-model="selectedCategory" @change="click" value="fastfoods">🍔패스트푸드</b-form-radio>
            <b-form-radio v-model="selectedCategory" @change="click" value="markets">🛒마트</b-form-radio>
            <b-form-radio v-model="selectedCategory" @change="click" value="cafes">☕카페</b-form-radio>
            <b-form-radio v-model="selectedCategory" @change="click" value="fitnesses">🏋️‍♂️운동</b-form-radio>
            <b-form-radio v-model="selectedCategory" @change="click" value="theaters">🎪극장</b-form-radio>
        </div>
        <div style="float:left; margin-left: 150px; width:1000px;">
            <b-table hover 
                :items="stores" 
                :fields="fields" id="storeTable" 
                @row-clicked="rowClick" 
                :per-page="perPage" 
                :current-page="currentPage"></b-table>
            <b-pagination 
                align="center" 
                v-model="currentPage"
                :total-rows="rows"
                :per-page="perPage"
                aria-controls="storeTable"></b-pagination>
        </div>
    </div>
    <div style="margin:400px;" align="center">
        <store-map :selectedArr="selectedStores" :selectedCate = "selectedCategory"></store-map>
        </div>

</div>
</template>
<script>
import { mapState, mapActions } from 'vuex'
import StoreMap from '@/components/dong/StoreMap.vue';

export default{
    data(){
        return{
            selectedCategory: 'academies',
            fields:[
                {key: 'storename', label: '상점명'},
                {key: 'addr', label: '주소'}
            ],
            perPage: 5,
            currentPage: 1,
            selectedStores: []
        }
    },
    components:{
        StoreMap
    },
    computed:{
        ...mapState(['selectedItem','selectedDong','academies', 'games', 'fastfoods', 'markets', 'cafes', 'fitnesses', 'theaters']),
        rows(){
            if(this.selectedCategory == 'academies')
                return this.academies.length
            else if(this.selectedCategory == 'games')
                return this.games.length
            else if(this.selectedCategory == 'fastfoods')
                return this.fastfoods.length
            else if(this.selectedCategory == 'markets')
                return this.markets.length
            else if(this.selectedCategory == 'cafes')
                return this.cafes.length
            else if(this.selectedCategory == 'fitnesses')
                return this.fitnesses.length
            else
                return this.theaters.length
        },
        stores(){
            if(this.selectedCategory == 'academies') 
                return this.academies;
            
            else if(this.selectedCategory == 'games') 
                return this.games
            
            else if(this.selectedCategory == 'fastfoods') 
                return this.fastfoods
            
            else if(this.selectedCategory == 'markets') 
                return this.markets
            
            else if(this.selectedCategory == 'cafes') 
                return this.cafes
            
            else if(this.selectedCategory == 'fitnesses') 
                return this.fitnesses
            
            else 
                return this.theaters
            
        }
    },
    methods:{
        ...mapActions(['selectItem']),
        rowClick(item){
            this.selectItem(item);
            console.log(this.selectedItem);
        },
        click(){
            if(this.selectedCategory == 'academies') 
                this.selectedStores = this.academies;
            else if(this.selectedCategory == 'games') 
                this.selectedStores =this.games;
            else if(this.selectedCategory == 'fastfoods') 
                this.selectedStores =this.fastfoods;
            else if(this.selectedCategory == 'markets') 
                this.selectedStores = this.markets;
            else if(this.selectedCategory == 'cafes') 
                this.selectedStores =this.cafes;
            else if(this.selectedCategory == 'fitnesses') 
                this.selectedStores = this.fitnesses;
            else 
                this.selectedStores = this.theaters;
            
            if(this.selectedStores.length != 0)
                this.selectItem(this.selectedStores[0]);
        }
    },
    created(){
         this.selectedStores = this.academies;
    }
}
</script>
<style>
</style>
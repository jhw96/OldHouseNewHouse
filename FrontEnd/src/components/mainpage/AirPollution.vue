<template>
    <div v-if="apts.length != 0">
        <span>서울특별시 {{selectedGugun}} 👉 
            미세먼지 농도 : <span id="pm10">{{pm10Data}}㎍/㎥</span> 
            초미세먼지 농도 : <span id="pm25">{{pm25Data}}㎍/㎥</span>
        </span>
    </div>
</template>

<script>
import {mapState} from 'vuex';

export default {
    name:'AirPollution',
    computed:{
        ...mapState(['selectedGugun','pm10Data','pm25Data','apts'])
    },
    updated() {
        if(this.pm10Data) {
            let num1 = (this.pm10Data*=1);
            let num2 = (this.pm25Data*=1);
            let dom1 = document.querySelector('#pm10');
            let dom2 = document.querySelector('#pm25');
            if(num1<30)
                dom1.style.color= "blue";
            else if(num1<80)
                dom1.style.color = "green";
            else if(num1<150)
                dom1.style.color = "orage";
            else
                dom1.style.color = "red";

            if(num2<30)
                dom2.style.color= "blue";
            else if(num2<80)
                dom2.style.color = "green";
            else if(num2<150)
                dom2.style.color = "orage";
            else
                dom2.style.color = "red";
            
            
        }
    }

}
</script>
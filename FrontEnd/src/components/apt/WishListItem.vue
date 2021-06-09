<template>
  <div>
      <span @click="selectApt">{{apt.dong}} {{apt.aptName}}</span><button type="button" @click="deleteWish">삭제</button>
  </div>
</template>

<script>
import {mapActions} from 'vuex';

export default {
    name: 'WishListItem',
    props: {
        apt:Object
    },
    methods:{
        ...mapActions(["getDealHistories","deleteInteresting", "getInterestingApts"]),
        selectApt() {
            this.getDealHistories({dong : this.apt.dong, aptName: this.apt.aptName});
            this.$router.push('/aptdetail');
        },
        deleteWish() {
            this.deleteInteresting({
                dong : this.apt.dong, 
                aptName: this.apt.aptName, 
                id : localStorage.getItem("user")
            })

        }
    }
}
</script>

<style>

</style>
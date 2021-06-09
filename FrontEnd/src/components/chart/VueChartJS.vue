<template>
    <div class="columns" align="center" style="margin-top:380px;">
      <div class="column">
        <line-chart></line-chart>
      </div>
    </div>
</template>
 
<script>
  import LineChart from '@/components/chart/LineChart'
 
  export default {
    name: 'VueChartJS',
    components: {
      LineChart
    },
 
  }
</script>
 
<style scoped>
 
</style>
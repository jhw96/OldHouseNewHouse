<script>
  import {Bar} from 'vue-chartjs'
import { mapState } from 'vuex'
  export default { 
    extends: Bar,
    computed:{
      ...mapState(['chartData', 'chartLabel'])
    },
    data () {
      return {
        datacollection:null,
        options: {
          scales: {
            yAxes: [{
              ticks: {
                beginAtZero: true 
              },
              gridLines: {
                display: true 
              }
            }],
            xAxes: [ {
              gridLines: {
                display: true 
              }
            }]
          },
          legend: {
            display: true
          },
          responsive: false, 
          maintainAspectRatio: false,
          width:1000
        }
      }
    },
    mounted () {
      this.renderChart(this.datacollection, this.options) 
    },
    created(){
      console.log("차트 세팅 : " + this.chartLabel);
      console.log("차트 세팅 : " + this.chartData);
      this.datacollection = {
        labels: this.chartLabel,
        datasets:[
          {
            label:'거래금액(단위:1만원)',
            backgroundColor: 'green',
            data: this.chartData
          }
        ]
      }
    }
  }
</script>
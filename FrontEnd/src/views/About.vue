<template>
  <div class="about" align="center">
    <div style="margin-top:100px;">
    <h3>부동산 실거래가 웹사이트 김나영, 장현웅</h3>
    </div>
    <div style="margin-top:100px;">
    <div class="nayoung" style="float:left; margin-left:500px;">
      <img src="../img/nayoung.png">
      <b-list-group>
        <b-list-group-item>김나영</b-list-group-item>
        <b-list-group-item>서울여자대학교</b-list-group-item>
        <b-list-group-item><a href="https://github.com/kimmy01" target="_blank"><img src="@/assets/github.png" style="width:25px; height:25px"></a></b-list-group-item>
      </b-list-group>
    </div>
    <div class="hyeonwoong" style="float:right; margin-right:500px;">
      <img src="../img/hyeonwoong.png">
      <b-list-group>
        <b-list-group-item>장현웅</b-list-group-item>
        <b-list-group-item>단국대학교</b-list-group-item>
        <b-list-group-item><a href="https://github.com/jhw96" target="_blank"><img src="@/assets/github.png" style="width:25px; height:25px"></a></b-list-group-item>
      </b-list-group>
      </div>
    </div>
    <div>
      <b-button v-if="!license" type="button" @click="showLicense">라이센스 보기</b-button>
      <b-button v-if="license" type="button" @click="showLicense">라이센스 안보기</b-button>
    </div>
      <div v-if="license" style="margin-top:300px; width:700px">
        배달의민족 한나체, 한나체 Air, 한나체 Pro, 주아체, 도현체, 연성체, 기랑해랑체, 을지로체, 을지로10년후체 글꼴의 지식재산권은 ㈜우아한형제들이 보유합니다.
배달의민족에서 무료로 배포하는 글꼴은(한나체·주아체·도현체·연성체·기랑해랑체·한나체 Air·한나체 Pro·을지로체·배민 을지로10년후체) 자유롭게 수정·변경하여 영리적·비영리적 목적으로 개인 및 기업 사용자가 모두 사용하실 수 있습니다.
다만, 글꼴 폰트 파일(otf/ttf)자체를 유상으로 판매하는 것은 금지하고 있으니 유의 부탁드립니다.
- 사용 가능 범위 : 간판, 현수막, 브로슈어, 포스터, 책, 잡지, 명함, 스티커, 패키지, 제품, 웹페이지, 광고 배너, E브로슈어, 영상 자막, 영화, TV광고, 웹툰, 게임 UI, 앱 UI, 뉴스레터, 웹진, 프리젠테이션, E-book, 메신저 스티커, 로고, 마크, 신문 광고, 잡지 광고, 지면 광고, 컵홀더, 부채, 쇼핑백, 컵홀더, 포장지, 핸드폰 케이스, 노트, 가방, 신발, 옷 등 상업적·비상업적 목적의 제작물 등
- 사용 불가능 범위 : 폰트파일((otf/ttf)의 유료 판매
배민에서 무료로 배포하는 글꼴(한나체·주아체·도현체·연성체·기랑해랑체·한나체 Air·한나체 Pro· 을지로체·배민 을지로10년후체)를 사용한 인쇄물, 광고물(온라인 포함)등의 이미지는 당사의 자료 수집 및 연구 목적으로 활용될 수 있습니다. 이를 원치 않는 사용자는 언제든지 당사 고객센터(1600-0987/ CS@woowahan.com)로 요청 부탁드립니다.
아래 “지식재산권 안내 및 라이선스” 전문을 표시하는 경우 다른 소프트웨어와 번들, 재배포 또는 판매하실 수 있습니다
지식재산권 안내 및 라이선스 Copyright © 2013, Woowa Brothers Corporation (https://www.woowahan.com), with Reserved Font Name BM HANNA 11yrs old, BM HANNA 11yrs old OTF, BMHANNAAir_otf, BMHANNAAir_
      </div>
      <br>
      <div v-if="license">Icons made by <a href="https://www.flaticon.com/authors/dinosoftlabs" title="DinosoftLabs" target="_blank">DinosoftLabs</a> from <a href="https://www.flaticon.com/" title="Flaticon" target="_blank">www.flaticon.com</a></div>
      <div v-if="license">Icons made by <a href="" title="surang" target="_blank">surang</a> from <a href="https://www.flaticon.com/" title="Flaticon" target="_blank">www.flaticon.com</a></div>
      <div v-if="license">Icons made by <a href="" title="surang" target="_blank">surang</a> from <a href="https://www.flaticon.com/" title="Flaticon" target="_blank">www.flaticon.com</a></div>
      <div v-if="license">Icons made by <a href="https://www.freepik.com" title="Freepik" target="_blank">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon" target="_blank">www.flaticon.com</a></div>
      <div v-if="license">Icons made by <a href="https://www.freepik.com" title="Freepik" target="_blank">Freepik</a> from <a href="https://www.flaticon.com/" title="Flaticon" target="_blank">www.flaticon.com</a></div>
      <div v-if="license">Icons made by <a href="https://icon54.com/" title="Pixel perfect" target="_blank">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon" target="_blank">www.flaticon.com</a></div>
      <div v-if="license">Icons made by <a href="" title="inipagistudio" target="_blank">inipagistudio</a> from <a href="https://www.flaticon.com/" title="Flaticon" target="_blank">www.flaticon.com</a></div>
      <div v-if="license">Icons made by <a href="https://www.flaticon.com/authors/pixel-perfect" title="Pixel perfect" target="_blank">Pixel perfect</a> from <a href="https://www.flaticon.com/" title="Flaticon" target="_blank">www.flaticon.com</a></div>
  </div>
</template>
<script>
export default{
  components:{

  },
  data(){
    return{
      license: false
    }
  },
  methods: {
    showLicense() {
      this.license = !this.license;
    }
  }

  
}
</script>

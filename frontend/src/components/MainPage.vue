<template>
    <v-app>
      <!-- 상단바 컴포넌트를 import 해서 불러옵니다 -->
      <!-- <AppBar /> -->
      <v-app-bar app color="navy" height="128" dark>
        <!-- 로고 이미지를 클릭하면 메인페이지로 이동합니다. -->
        <v-router-link :to="{ name: 'MainPage' }">
          <v-img src="../assets/CRIME.png" alt="로고" height="120" width="240"/>
        </v-router-link>
    
        <!-- 메뉴 버튼 -->
        <!-- <v-app-bar-nav-icon @click="toggleMenu" /> -->
    
        <!-- 버튼 그룹 -->
        <v-btn-toggle v-model="selectedButton" class="ml-4" >
          <v-btn @click="navigateTo('ServiceInfo')" dark>CrimeFin?</v-btn>
          <v-btn @click="navigateTo('Agency')" dark>가까운 기관 조회</v-btn>
          <v-btn @click="navigateTo('DigitalExp')" dark>디지털 체험관</v-btn>
        </v-btn-toggle>
    
        <!-- 로그인한 사용자 정보 및 토글 버튼 -->
        <v-menu offset-y v-model="menuOpen">
          <template v-slot:activator="{ on, attrs }">
            <v-btn text v-bind="attrs" v-on="on" dark>
              <!-- {{ loggedInUser }} 님 -->
              <v-icon>mdi-chevron-down</v-icon>
            </v-btn>
          </template>
          <v-list>
            <v-list-item @click="goTo('MyPage')" >마이페이지</v-list-item>
            <v-list-item @click="goTo('DashBoard')" >자산/대시보드</v-list-item>
          </v-list>
        </v-menu>
      </v-app-bar>
      <v-main>
      <v-container>
        <!-- 카드를 가로로 배치하는 Flexbox 레이아웃 -->
        <div class="d-flex justify-center">
          <!-- 가로로 3개의 카드 배치 -->
          <!-- 첫 번째 카드 -->
          <v-card class="mx-2 mt-6" width="450" tile>
            <v-card-title>
              <v-card class="mx-auto" width="400" height="350" tile>
                <v-card-text>
                  <h2 class="text-center">이상한 전화가 왔어요</h2>
                </v-card-text>
                
              </v-card>
            </v-card-title>
            <v-card-actions class="justify-center">
              <!-- "바로가기" 버튼 -->
              <v-btn color="primary" @click="redirectToPhishingNumber('Phone')">바로가기</v-btn>
            </v-card-actions>
          </v-card>

          <!-- 두 번째 카드 -->
          <v-card class="mx-2 mt-6" width="450" height="450" tile>
            <v-card-title>
              <v-card class="mx-auto" width="400" height="350" tile>
                <v-card-text>
                  <h2 class="text-center">이상한 문자가 왔어요</h2>
                </v-card-text>
                
              </v-card>
            </v-card-title>
            <v-card-actions class="justify-center">
              <!-- "바로가기" 버튼 -->
              <v-btn color="primary" @click="redirectToPhishingNumber('Message')">바로가기</v-btn>
            </v-card-actions>
          </v-card>

          <!-- 세 번째 카드 -->
          <v-card class="mx-2 mt-6" width="450" height="450" tile>
            <v-card-title>
              <v-card class="mx-auto" width="400" height="350" tile>
                <v-card-text>
                  <h2 class="text-center">이상한 카톡이 왔어요</h2>
                </v-card-text>
                
              </v-card>
            </v-card-title>
            <v-card-actions class="justify-center">
              <!-- "바로가기" 버튼 -->
              <v-btn color="primary" @click="redirectToPhishingLink('Message')">바로가기</v-btn>
            </v-card-actions>
          </v-card>
        </div>
      </v-container>
    </v-main>
    </v-app>
  </template>
  
  <script>
// import AppBar from '../views/AppBar.vue'; // 상단바 컴포넌트를 import 합니다.
  
  export default {
    components: {
      // AppBar, // 상단바 컴포넌트를 등록합니다.
    },
    methods: {
    redirectToPhishingNumber(type) {
      // PhishingNumber.vue로 이동하는 로직을 작성합니다.
      this.$router.push({ name: 'PhishingNumber' , params: { type } });
    },
    redirectToPhishingLink(type) {
      // PhishingNumber.vue로 이동하는 로직을 작성합니다.
      this.$router.push({ name: 'PhishingLink' , params: { type } });
    },
  },
  };
  </script>
  
  <style scoped>
  /* 스타일을 필요에 따라 추가하세요. */
  </style>
  
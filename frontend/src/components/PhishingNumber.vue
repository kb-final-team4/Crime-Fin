<template>
  <v-app>

  <!-- 상단바 컴포넌트import -->
  <!-- <AppBar /> -->
  <v-app-bar app color="navy" height="128" dark>
  <!-- 로고 이미지를 클릭하면 메인페이지로 이동합니다. -->
  <v-router-link :to="{ name: 'MainPage' }">
    <!-- <v-img src="../assets/CRIME.png" alt="로고" height="100px" /> -->
  </v-router-link>

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
        {{ loggedInUser }} 님
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
        <v-row justify="center">
          <v-col cols="12" sm="6" md="4">
            <!-- 전화번호 폼 -->
            <h1>{{ $route.params.type }} :: 전화번호를 입력하세요</h1>
            <v-form @submit.prevent="sendPhoneNumber">
              <v-text-field
                v-model="phoneNum"
                label="전화번호"
                required
              ></v-text-field>
              <v-btn type="submit">조회하기</v-btn>
            </v-form>
          </v-col>
        </v-row>
      </v-container>
    </v-main>
  
  </v-app>

  </template>
  
  <script>
  import axios from 'axios';
  // import AppBar from '../views/AppBar.vue'; // 상단바 컴포넌트를 import 합니다.
 

  export default {
    components: {
      // AppBar, // 상단바 컴포넌트를 등록합니다.
    },
    data() {
      return {
        phoneNum: '', // 사용자 입력을 저장할 변수
      };
    },
    methods: {
    sendPhoneNumber() {
    // 사용자 입력된 전화번호를 사용하여 GET 요청을 보냅니다.
    const phoneNum = this.phoneNum;
    axios.get(`/phishing?phoneNumber=${phoneNum}`)
      .then(response => {
        // 성공적으로 요청을 보낸 경우 실행될 로직
        console.log('GET 요청 성공:', response.data);

        
        // {{ $route.params.type }}의 값에 따라 다른 결과 페이지로 이동합니다.
        if (this.$route.params.type === 'Message') {
            this.$router.push({
              name: 'MessageNumberResult',
              query: { result: response.data },
            });
          } else if (this.$route.params.type === 'Phone') {
            this.$router.push({
              name: 'PhoneNumberResult',
              query: { result: response.data },
            });
          }
      })
      .catch(error => {
        // 요청 중 오류가 발생한 경우 실행될 로직
        console.error('GET 요청 오류:', error);
      });
  },
}}
  </script>
  
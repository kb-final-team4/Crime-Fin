import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

//import InitPage from '../components/InitPage.vue' // 예시로 Home 컴포넌트를 가져옵니다.
//import SignIn from '../components/SignIn.vue' // SignIn 컴포넌트 경로 설정
//import SignUp from '../components/SignUp.vue' // SignUp 컴포넌트 경로 설정
// import MainPage from '../components/MainPage.vue' // MainPage 컴포넌트 경로 설정
import MainPage from '../components/MainPage.vue' // MainPage 컴포넌트 경로 설정

//import ServiceInfo from "../components/ServiceInfo.vue";
//import Agency from "../components/Agency.vue";
//import DigitalExp from "../components/DigitalExp.vue";
//import MyPage from "../components/MyPage.vue";
//import DashBoard from "../components/DashBoard.vue";

import PhishingNumber from "../components/PhishingNumber.vue";
import PhishingNumberResult from "../components/PhishingNumberResult.vue";

// import Appbar from '../views/Appbar.vue' // Appbar 컴포넌트 경로 설정

const routes = [
  //{ path: '/', component: InitPage },
  //{ path: '/signin', component: SignIn }, // "/signin" 경로 설정
  //{ path: '/signup', component: SignUp }, // "/signup" 경로 설정
  { path: '/main', component: MainPage }, // "/MainPage" 경로 설정
  //{ path: "/serviceinfo", component: ServiceInfo, name: "ServiceInfo" },
  //{ path: "/agency", component: Agency, name: "Agency" },
  //{ path: "/digitalexp", component: DigitalExp, name: "DigitalExp" },
  //{ path: "/mypage", component: MyPage, name: "MyPage" },
  //{ path: "/dashboard", component: DashBoard, name: "DashBoard" },
  { path: "/num", component: PhishingNumber, name: "PhishingNumber" },
  { path: "/numresult", component: PhishingNumberResult, name: "PhishingNumberResult" },
  // 추가 라우트 정의
]

const router = new VueRouter({
  routes,
  mode: 'history',
})

export default router
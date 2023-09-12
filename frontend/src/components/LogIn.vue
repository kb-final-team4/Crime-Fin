<template>
  <v-container fluid class="d-flex flex-column align-center justify-center h-100">
    <v-row justify="center" align="center" >
      <v-col width="50%" height="80%">
        <v-card >
          <v-card-title class="text-center" >
            <div height="50px"><v-img src="../assets/CRIME.png"></v-img></div>
            <h2 class="mb-4">LOGIN</h2>
          </v-card-title>
          <v-card-text>
            <v-form @submit.prevent="login" class="mx-auto" max-width="80%">
              <v-text-field
                v-model="memberId"
                label="아이디"
                outlined
                dense
                required
              ></v-text-field>
              <v-text-field
                v-model="password"
                label="비밀번호"
                outlined
                dense
                required
                type="password"
              ></v-text-field>
              <v-btn
                type="submit"
                color="primary"
                class="mt-4"
                block
                outlined
                depressed
              >
                로그인
              </v-btn>

              <router-link to="/main"><v-btn
                color="primary"
                class="mt-4"
                block
                outlined
                depressed
              >
                로그인
              </v-btn></router-link>
            </v-form>
          </v-card-text>
          <v-card-actions class="justify-center">
            <v-btn text color="primary" class="mr-2">아이디/비밀번호 찾기</v-btn><br>
          </v-card-actions>
          <!-- 가로선 추가 -->
          <hr class="separator my-6">
          <!-- 카카오 로그인 버튼 (노란색) -->
          <v-row justify="center">
            <v-col cols="12">
              <v-btn color="yellow darken-2" class="mt-1" block outlined depressed>카카오 로그인</v-btn>
            </v-col>
          </v-row>

          <!-- 네이버 로그인 버튼 (연두색으로 수정) -->
          <v-row justify="center">
            <v-col cols="12">
              <v-btn color="lime" class="mt-4" block outlined depressed>네이버 로그인</v-btn>
            </v-col>
          </v-row>

          <!-- 구글 로그인 버튼 (크기 조절) -->
          <v-row justify="center">
            <v-col cols="12">
              <v-btn color="yellow darken-2" class="mt-4" block outlined depressed style="max-width: 200px;">구글 로그인</v-btn>
            </v-col>
          </v-row>
        </v-card>
      </v-col>
    </v-row>
  </v-container>
</template>

<script>
import axios from 'axios';

export default {
    data:function(){
        return{
            memberId: '',
            password:'',
        }
    },
    methods: {
        login:function(){
            console.log(this.memberId, this.password);
            var url = "/user/login";
            //var url = "/login"; //백엔드 로그인 주소 확인
            //var response = "";
            var data={
                memberId: this.memberId,
                password: this.password
            }

            var customAxios = axios.create({});

            customAxios.post(url, data)
            //.then(function(response){
            //    console.log();
            //})
            .then(response =>
                console.log(response))
            //.catch(function(error){
            //    console.log(response);
            //});
        }
    },
}
</script>

<style scoped>
/* 페이지의 가운데에 위치하도록 스타일 조정 */
.d-flex {
  display: flex;
}

.flex-column {
  flex-direction: column;
}

.align-center {
  align-items: center;
}

.justify-center {
  justify-content: center;
}

.h-100 {
  height: 100vh;
}

/* 가로선 스타일 */
.separator {
  width: 100%;
  border: 1px solid #000; /* 원하는 색상과 두께로 변경 가능 */
}

/* 카카오 로그인 버튼 스타일 (노란색) */
.v-btn[color="yellow darken-2"] {
  background-color: #FFEB00; /* 원하는 노란색으로 변경 가능 */
  color: #000; /* 버튼 텍스트 색상 (검정색 등)으로 변경 가능 */
}

/* 네이버 로그인 버튼 스타일 (연두색으로 수정) */
.v-btn[color="lime"] {
  background-color: #00CC00; /* 원하는 연두색으로 변경 가능 */
  color: #000; /* 버튼 텍스트 색상을 흰색으로 지정 */
}
</style>

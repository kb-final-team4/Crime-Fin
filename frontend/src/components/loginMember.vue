<template>
<div>
    <h2>LOGIN</h2>
    <form @submit.prevent="login">
        <input type="text" id="id" name="memberId" placeholder="아이디" v-model="memberId"><br>
        <input type="password" id="password" name="password" placeholder="비밀번호" v-model="password"><br>
        <h5 id="find">아이디/비밀번호 찾기</h5>
        <button type="submit">로그인</button>
        <input type="button" id="login" value="로그인"><br>
        <hr id="hr">
        <input type="button" id="kakaologin" value="카카오 로그인"><br>
        <input type="button" id="naverlogin" value="네이버 로그인"><br>
        <input type="button" id="googlelogin" value="구글 로그인">
    </form>
</div>
</template>
<!--
<template>
    <form v-on:submit="submitForm"> 
      <div>
        <label for="username">id: </label>
        <input id="username" type="text" v-model="username">
      </div>
      <div>
        <label for="password">password: </label>
        <input id="password" type="password" v-model="password">
      </div>
      <button type="submit">login</button>
    </form>
  </template>
-->
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

            axios.post(url, data)
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
<!--
<script>
export default {
  data: function() {
    return {
      username: '',
      password: ''
    }
  },
  methods: { // 메서드 구현
    submitForm: function() {
      console.log(this.username, this.password);
    }
  }
}
</script>
-->


<style>
/* 아이디폼 */
#id{
    position: absolute;
    width: 350px;
    height: 50px;
    left: 600px;
    top: 272px;
    size: 350%; 
    }
    
#id{
    /* Rectangle 1 */

box-sizing: border-box;

position: absolute;
width: 350px;
height: 50px;
left: 545px;
top: 272px;

background: rgba(255, 255, 255, 0.9);
border: 1px solid #000000;
border-radius: 10px;

}
/* 비밀번호폼 */
#password{
    position: absolute;
    width: 350px;
    height: 50px;
    left: 600px;
    top: 339px;}

#password{
        /* Rectangle 2 */
    
    box-sizing: border-box;
    
    position: absolute;
    width: 350px;
    height: 50px;
    left: 545px;
    top: 339px;
    
    background: rgba(255, 255, 255, 0.9);
    border: 1px solid #000000;
    box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.25);
    border-radius: 10px;
    }


/* 로그인버튼 */
#login{
position: absolute;
width: 241px;
height: 60px;
left: 652px;
top: 447px;}

#login{
    /* Rectangle 3 */

box-sizing: border-box;

position: absolute;
width: 241px;
height: 60px;
left: 587px;
top: 447px;

background: rgba(255, 255, 255, 0.8);
border: 1px solid #000000;
box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.25);
border-radius: 30px;
}






/* 아이디비밀번호찾기 */
#find{
position: absolute;
width: 134px;
height: 18px;
left: 820px;
top: 391px;}

/* Rectangle 3 */

#googlelogin{
    box-sizing: border-box;

position: absolute;
width: 350px;
height: 60px;
left: 545px;
top: 753px;

background: rgba(255, 255, 255, 0.8);
border: 1px solid #000000;
box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.25);
border-radius: 30px;}

/* Rectangle 3 */

#naverlogin{
    box-sizing: border-box;

position: absolute;
width: 350px;
height: 60px;
left: 545px;
top: 671px;

background: rgba(30, 200, 0, 0.8);
border: 1px solid #000000;
box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.25);
border-radius: 30px;}


#kakaologin{
    /* Rectangle 3 */

box-sizing: border-box;

position: absolute;
width: 350px;
height: 60px;
left: 545px;
top: 589px;

background: rgba(254, 240, 27, 0.8);
border: 1px solid #000000;
box-shadow: 5px 5px 10px rgba(0, 0, 0, 0.25);
border-radius: 30px;

}

/* Line 7 */
hr{
position: absolute;
width: 410px;
height: 0px;
left: 515px;
top: 556px;

border: 5px dashed #000000;}
</style>
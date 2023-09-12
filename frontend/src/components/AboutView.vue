<template>
  <div class="about">
    <h1 class="white-text">This is an about page</h1>

    <div>
      <router-link to="/login"><v-btn color="#445069" id="btn">Sign In</v-btn></router-link>
      <router-link to="/join"><v-btn color="#445069" id="btn">Join</v-btn></router-link>
  </div>
  </div>

  
  </template>

<style scoped>
.white-text {
  color: white; /* 글씨 색상을 하얀색으로 설정 */
}
</style>
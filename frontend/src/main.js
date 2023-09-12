import Vue from 'vue'
import loginMember from './components/loginMember.vue'

Vue.config.productionTip = false

new Vue({
  render: h => h(loginMember),
}).$mount('#app')

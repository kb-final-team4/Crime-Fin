import Vue from 'vue'
import MainPage from './components/MainPage.vue'
import router from './router/router'
import vuetify from './plugins/vuetify'

Vue.config.productionTip = false

new Vue({
  router,
  vuetify,
  render: h => h(MainPage)
}).$mount('#app')

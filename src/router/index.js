import Vue from 'vue'
import VueRouter from 'vue-router'
import Welcome from '../components/Welcome'

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Welcome',
      component: Welcome,
      meta: {
        roles: [ 'guest', 'user' ]
      }
    },
   ]
})

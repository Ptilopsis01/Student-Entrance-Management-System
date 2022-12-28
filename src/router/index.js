import Vue from 'vue'
import VueRouter from 'vue-router'
import Welcome from '../components/Welcome'
import StudentDash from "../components/StudentDash.vue";
import ClassAdminDash from "../components/ClassAdminDash.vue";
import SuperUserDash from "../components/SuperUserDash.vue";

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Welcome',
      component: Welcome,
    },
    {
      path: '/student',
      name: 'StudentDash',
      component: StudentDash,
    },
    {
      path: '/admin/class',
      name: 'ClassAdminDash',
      component: ClassAdminDash,
    },
    {
      path: '/superuser',
      name: 'SuperUserDash',
      component: SuperUserDash,
    }
   ]
})

import Vue from 'vue'
import VueRouter from 'vue-router'
import Welcome from '../components/Welcome'
import StudentDash from "../components/StudentDash.vue";
import ClassAdminDash from "../components/ClassAdminDash.vue";
import DeptAdminDash from "../components/DeptAdminDash.vue";
import SuperUserDash from "../components/SuperUserDash.vue";

Vue.use(VueRouter)

export default new VueRouter({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Welcome',
      component: Welcome,
      meta: {
        roles: ['guest', 'student', 'class', 'department', 'superuser']
      }
    },
    {
      path: '/student',
      name: 'StudentDash',
      component: StudentDash,
      meta: {
        roles: ['student']
      }
    },
    {
      path: '/admin/class',
      name: 'ClassAdminDash',
      component: ClassAdminDash,
      meta: {
        roles: ['class']
      }
    },
    {
      path: '/admin/dept',
      name: 'DeptAdminDash',
      component: DeptAdminDash,
      meta: {
        roles: ['department']
      }
    },
    {
      path: '/superuser',
      name: 'SuperUserDash',
      component: SuperUserDash,
      meta: {
        roles: ['superuser']
      }
    }
   ]
})

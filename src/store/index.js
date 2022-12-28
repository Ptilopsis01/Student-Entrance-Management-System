import Vue from 'vue'
import Vuex from 'vuex'
Vue.use(Vuex)

export default new Vuex.Store({
  state: {
    user: {
      id: window.sessionStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.sessionStorage.getItem('user' || '[]')).id,
      name: window.sessionStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.sessionStorage.getItem('user' || '[]')).name,
      classId: window.sessionStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.sessionStorage.getItem('user' || '[]')).classId,
      deptId: window.sessionStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.sessionStorage.getItem('user' || '[]')).deptId,
      role: window.sessionStorage.getItem('user' || '[]') == null ? '' : JSON.parse(window.sessionStorage.getItem('user' || '[]')).role,
    }
  },
  mutations: {
    login (state, user) {
      state.user = user
      window.sessionStorage.setItem('user', JSON.stringify(user))
    },
  }
})

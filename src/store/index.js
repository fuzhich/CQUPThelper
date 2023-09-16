import Vue from 'vue'
import Vuex from 'vuex'
 
Vue.use(Vuex)
const state = {
  isLogin:false,
  baseUrl:"http://localhost:8080",
  userId:"",
  userInfo:{},
  notice:[],
}

export default new Vuex.Store({
  //数据，相当于data
  state,
  getters: {
    
  },
  //里面定义方法，操作state方发
  mutations: {
    
  },
  // 操作异步操作mutation
  actions: {
    
  },
  modules: {
    
  },
})
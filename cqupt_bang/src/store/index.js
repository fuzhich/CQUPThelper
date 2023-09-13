import Vue from 'vue'
import Vuex from 'vuex'
 
Vue.use(Vuex)
const state = {
  isLogin:true,
  
}

export default new Vuex.Store({
  //数据，相当于data
  state,
  getters: {
    
  },
  //里面定义方法，操作state方发
  mutations: {
    updateLoginStatus(status){
      this.state.isLogin=status;
    } 
  },
  // 操作异步操作mutation
  actions: {
    
  },
  modules: {
    
  },
})
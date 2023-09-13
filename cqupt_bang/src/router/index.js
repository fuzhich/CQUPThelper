import Vue from 'vue'
import Router from 'vue-router'
import HelloWorld from '@/components/HelloWorld'

Vue.use(Router)

export default new Router({
  mode:"history",
  routes: [
    
    {
      path:"/",
      name:"login&index",
      component:()=>{return import("../components/login.vue")}

    },
    {
      path: '/index',
      name: 'index',
      component: ()=>{return import("../components/index.vue")}
    },
    {
      path:"/dining",
      name:"dining",
      component:()=>{return import("../components/dining/dining.vue")}
    },
    {
      path:"/window",
      name:"window",
      component:()=>{return import("../components/dining/window.vue")}
    },
    {
      path:"/user",
      name:"user",
      component:()=>{return import("../components/user/user.vue")}
    },
    {
      path:"/schoolbus",
      name:"user",
      component:()=>{return import("../components/schoolbus/schoolbus.vue")}
    }
  ]
})

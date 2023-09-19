<template>
  <div id="app">
    
    <router-view></router-view>
  </div>
</template>

<script>
import login from "./components/login.vue"
import index from "./components/index.vue"

export default {
  name: 'App',
  components:{login,index},
  beforeDestroy(){
    localStorage.clear();
  } ,
  created(){
   
  }
}
</script>

<style>
#app{
  overflow: hidden;
}
router-view{
  overflow: hidden;
}
</style>

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
  padding:0;
  margin:0;
}
router-view{
  overflow: hidden;
}
</style>

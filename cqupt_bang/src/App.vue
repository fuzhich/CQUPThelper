<template>
  <div id="app">
    <login v-if="!this.$store.state.isLogin"></login>
    <!-- <index v-else/> -->
    <router-view v-else></router-view>
  </div>
</template>

<script>
import login from "./components/login.vue"
import index from "./components/index.vue"

export default {
  name: 'App',
  components:{login,index},
  
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

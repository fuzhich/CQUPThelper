
<template>
    <div id="root">
        <img class="background" src="../../../static/首页-背景.png">
        <el-container>
            <el-header height="70px">
              <div class="header">
            <h3 class="back" @click="back">&lt</h3>
            <h2>{{ name }}</h2>
            </div>  
            </el-header>
            
            <el-main>
                <div class="dishes" v-for="(item,index) in dishes">
                {{ item.name }}&nbsp; {{ item.pricce }}元
                </div>
            </el-main>
        </el-container>
        
    </div>
</template>
<script>
export default {
    name:"dining",
    data(){
        return{
            diningId:this.$route.query.diningId,
            windowId:this.$route.query.id,
            name:"",
            dishes:[],
        }
    },
    methods:{
        back(){
            this.$router.push({path:"/dining",query:{id:this.diningId}});
        },
       
        
    },
    async created(){
        console.log(this.$route.query);   
        let result = await this.$axios({
            method:"get",
            timeout:30000,
            url:"/window",
            params:{
                id:this.windowId
            }
        }) 
        console.log(result);
        this.name = result.data.result.data.name;
        this.dishes = result.data.result.data.dishes;
    }
}
</script>
<style>
*{
    padding:0;
    margin:0;
    text-decoration:none;
    color:#385339;
}
#root{
    width:100vw;
    height:100vh;
    overflow:hidden;
}
.background{
    position:absolute;
    width:calc(100vw);
    height:calc(100vh) ;
    z-index:-1;
    min-width: 1000px;
    min-height:400px;
}
.el-container{
    overflow:hidden;
}
header.el-header{
    z-index:10;
    top:0;
    left:0;
    width:100vw;
    min-width:1000px;
    height:70px;
    display:inline-flex;
    overflow: hidden;
    background-color:#E2FCE3;
    align-items: center;
    padding-left:0 !important;
}
.el-main{
    width:80vw;
    min-width:900px;
    
}
.back{
    user-select: none;
    cursor: pointer;
    font-size:48px;
    font-weight:300;
    color:#385339;
}
.el-aside{
    height:700px;
    border-right:#E2FCE3 10px solid;
    overflow: hidden;
}
.nav-menu{
    background-color:#38533900;
  
    padding:10px 0 0;
}
.menu-item{
   user-select: none;
   display:block;
   background-color:#b2d3b300;
   color:#385339;
   font-size:24px;
   line-height:38px;
   font-family:宋体;
   height:38px;
   margin:10px 0;
   border-top-right-radius:10px ;
   border-bottom-right-radius: 10px;
   cursor:pointer;
}
.menu-item:hover{
    background:#E2FCE3;
    width:140px;
    padding-left:20px;
}
.menu-item a{
    padding-left:20px;
    display:block;
    width:140px;
    height:100%;
    border-top-right-radius:10px ;
    border-bottom-right-radius: 10px;
}
a.router-link-exact-active{
    background:#E2FCE3;
}
.dishes{
    display:inline-block;
    width:200px;
    margin-left:80px;
}
</style>
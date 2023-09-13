<template>
    <div id="index">
        <img class="background" src="../../static/首页-背景.png">
        <div class="header">
            <img src="../../static/个人-重邮校徽 (1).png" class="cqupt" >
            <nav>
                <ul class="nav">
                    <li class="li_router"><router-link to="/index">|首页|</router-link></li>
                    <li class="li_router"><router-link to="/dining?id=135587">|食堂|</router-link></li>
                    <li class="li_router"><router-link to="/schoolbus?id=101">|校车|</router-link> </li>
                    <li class="li_router"><router-link to="/user">|个人|</router-link> </li>
                    <li class="logout" @click="logout">|退出登录|</li>
                </ul>
            </nav>
        </div>
        <div>
            <img class="notice" src="../../static/首页—公告栏.png" >
        </div>
        
        
    </div>
</template>
<script scoped>
export default {
    name:"index",
    data(){
        return{

        }
    },
    methods:{
        logout(){
            this.$store.state.isLogin=false;
            this.$router.push({path:"/"});
        }
    }
}
</script>

<style >
*{
    margin:0;
    padding:0;
    color:black;
    text-decoration:none;
    list-style: none;
}
#index{
    width:100vw;
    height:100vh;
    overflow:hidden;
}
.background{
    position: absolute;
    width:calc(100vw);
    height:calc(100vh);
    min-width: 1000px;
    min-height:400px;
    z-index:-1;
}

.header{
    position: absolute;
    z-index:10;
    top:0;
    left:0;
    width:100vw;
    min-width: 1000px;
    height:70px;
    display:inline-flex;
    overflow: hidden;
    background-color:#E2FCE3;
    align-items: center;
}
img.cqupt{
    width:100px;
    margin-top:10px;
}
.nav{
    display:inline-flex;
    margin-left:10px;
    height:70px;
    align-items: center;
    user-select: none;
}
.li_router{
    width:50px;
}
.logout{
    width:80px;
    cursor: pointer;
}
.nav li {
    display: inline-block;
    color:#385339;
    justify-content: center;
    line-height:40px;
    height:40px;
    margin-right:10px;
    text-align: center;
}

.nav li a{
    color:#385339;
}
.nav li:nth-child(4){
    margin-left:900px;
}
a.active{
    color:red;
}
img.notice{
   position:absolute;
   width:500px;
   z-index:10;
   left:400px;
   top:100px;
}

</style>
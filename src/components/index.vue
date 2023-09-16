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
        <div class="notice">
            <!-- <img class="notice" src="../../static/首页—公告栏.png" > -->
            <div class="single_info" v-for="(item,index) in notice" :key="item.id">
                <h4>{{ item.msg }}</h4>    
                <p>{{ item.updateTime | getDateTime }}</p>
            </div>
        </div>
        
        
    </div>
</template>
<script scoped>
export default {
    name:"index",
    data(){
        return{
            notice:this.$store.state.notice,
        }
    },
    methods:{
        logout(){
            this.$store.state.userId="";
            this.$store.state.isLogin=false;
            this.$router.push({path:"/"});
        }
    },
    filters:{
        getDateTime(value) {
	        return (new Date(value)).toLocaleDateString() + " " + (new Date(value)).toLocaleTimeString()
        },

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
div.notice{
    box-sizing: border-box;
    position:absolute;
    height:400px;
    width:550px;
    z-index:10;
    left:30vw;
    top:100px;
    background:url("../../static/首页—公告栏.png") ;
    background-size:cover;
    padding:60px 16px 0 88px;
    
}
.single_info{
    height:30px;
    line-height:30px;
}
.single_info p, .single_info h4{
    display: inline;
    color:#385339;
}
.single_info p{
    float:right;
}


</style>
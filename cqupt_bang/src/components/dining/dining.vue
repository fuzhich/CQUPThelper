<template>
    <div id="root">
        <img class="background" src="../../../static/首页-背景.png">
        <el-container>
            <el-header height="70px">
              <div class="header">
            <h3 class="back" @click="back">&lt</h3>
            </div>  
            </el-header>
            <el-aside width="200px">
                <ul class="nav-menu"> 
                    <li class="menu-item" v-for="(item,index) in dining" :key="index"
                   >

                    <router-link :to="'/dining?id='+item.id" exact>{{ item.name }}</router-link>   
                    </li>
                </ul>
                
            </el-aside>
            <el-main>

            </el-main>
        </el-container>
        
    </div>
</template>
<script>
export default {
    name:"dining",
    data(){
        return{
            dining:[
                {name:"延生食堂",id:"135587"},
                {name:"樱花食堂",id:"829910"},
                {name:"莘莘食堂",id:"342891"},
                {name:"千喜鹤",id:"398899"},
                {name:"中心食堂",id:"796533"},
                {name:"大西北",id:"120033"},
                {name:"小食荟",id:"279901"},
            ],
            id:this.$route.query.id,
        }
    },
    methods:{
        back(){
            this.$router.push({path:"/index"});
        },
       
        
    },
    created(){
 
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
    padding-left:0;
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

</style>
<template>
    <div id="root">
        <img class="background" src="../../../static/首页-背景.png">
        <el-container>
            <el-header height="70px">
              <div class="header">
            <h3 class="back" @click="back">&lt</h3>
            </div>  
            </el-header>
            <el-container>
               <el-aside width="200px">
                <ul class="nav-menu"> 
                    <li class="menu-item" v-for="(item,index) in buses" :key="index"
                   @click="change(item.id)">

                    <router-link :to="'/schoolbus?id='+item.id" exact>{{ item.name }}</router-link>   
                    </li>
                </ul>
                
            </el-aside>
            <el-main class="pic">
                <Suspense>
                 <img :src="pic"  class="bus-line">   
                </Suspense>
                
            </el-main>  
            </el-container>
           
        </el-container>
        
    </div>
</template>
<script>
export default {
    name:"dining",
    data(){
        return{
            buses:[
                {name:"一号线",id:101,picUrl:""},
                {name:"二号线",id:102,picUrl:""},
                {name:"三号线",id:103,picUrl:""},
            ],
            id:Number(this.$route.query.id),
            pic:"",
            schoolbus:[],

        }
    },
    methods:{
        back(){
            this.$router.push({path:"/index"});
        },
       async change(val){
        this.id = val;       
           
        for(var item of this.schoolbus){
            if(item.number == this.$route.query.id){
                this.pic = item.picUrl;
                console.log("item.picUrl = "+item.picUrl);
            }
            // console.log(item);
            // console.log(item.number + typeof(item.number));
        }
         console.log(this.pic);   
        
       }
       
        
    },
    computed:{
        target(){
            let url;
            for(var i of this.buses){
                if(i.id == this.$route.query.id){
                    this.pic= i.picUrl;
                }
            }
            return url;
        }
    },
    async created(){
        this.id = this.$route.query.id;
      
        let result  = await this.$axios({
            method:"get",
            url:"/schoolbus",
            timeout:30000,
            params:{
                id:this.id
            }
        })
        console.log(result);
        if(result.data.code==200){
           let index = 0;
            this.schoolbus =  result.data.result.data;
            console.log("this.schoolbus")
            console.log(this.schoolbus);
        }
        for(var item of this.schoolbus){
            if(item.number === this.id){
                this.pic = item.picUrl;
            }
        }
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
    height:calc(100vh);
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
.el-main.pic{
    width:100%;
    height:100%;
    min-width:900px;
    height:500px;
}
.bus-line{
   height:80%;
   min-height:340px;
    width:80%;
    min-width:600px;
    margin-left:200px;
}

</style>
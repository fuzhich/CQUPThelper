<template>
    <div id="root">
        <img class="background" src="../../../static/首页-背景.png">
        <el-container>
            <el-header height="70px">
              <div class="header">
            <h3 class="back" @click="back">&lt</h3>
            </div>  
            </el-header>
           
            <el-main>
                <!-- <img src="../../../static/个人-信息面板.png" width="600px"> -->
                <div class="info">
                    <img src="../../../static/个人-四条信息.png">
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
            person:{},
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
.el-main{
    overflow: hidden;
}
.back{
    user-select: none;
    cursor: pointer;
    font-size:48px;
    font-weight:300;
    color:#385339;
}

.info{
    width:600px;
    height:300px;
    border-radius:10px;
    background:rgba(255, 255, 255, 0.627);
    margin:30px 290px;
    overflow: hidden;
}
.info img{
    width:1000px;
    margin: -90px -180px ;
}


</style>
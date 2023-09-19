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
                    <!-- <img src="../../../static/个人-四条信息.png"> -->
                    <h4>姓名：&nbsp{{ userInfo.name }}</h4>
                    <h4>年纪：&nbsp{{ userInfo.grade }}</h4>
                    <h4>性别：&nbsp{{ userInfo.gender }}</h4>
                    <h4>学院：&nbsp{{ userInfo.institute }}</h4>
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
            userInfo:{}
        }
    },
    methods:{
        back(){
            this.$router.push({path:"/index"});
        },
       
        
    },
    async created(){
        console.log("this.id");
        console.log(this.$store.state.userId);
        let result = await this.$axios({
            method:"get",
            url:"/user",
            timeout:30000,
            params:{
                id:Number(sessionStorage.getItem("userId"))
            }
        });
    
        console.log(result);
        this.userInfo = result.data.result;
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
    min-height:500px;
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
    height:100%;
    width:100%;
    display: flex;
    justify-content: center;
    align-items: center;
}
.back{
    user-select: none;
    cursor: pointer;
    font-size:48px;
    font-weight:300;
    color:#385339;
}

.info{
    display:flex;
    flex-flow: column;
    box-sizing:border-box;
    z-index:100;
    position:absolute;
    background:rgba(255, 255, 255, .5);
    border-radius:10px;
    width:25vw;
    height:25vh;
    min-width:300px;
    min-height:300px;
    top:200px;
    padding-left:2vw;
    justify-content: center;
    align-items: left;
    
}
.info h4{    
    display: block;
    font-size:larger;
    margin: 2px 2px;
}
/* .info img{
    width:1000px;
    margin: -90px -180px ;
} */


</style>
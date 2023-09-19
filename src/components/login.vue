<template>
    <div id="login">
        <img class="background" src="../../static/登录-登录背景.png">
        <keep-alive>
           <el-container>
            <el-aside>
                <div>
                    <div class="float"> 账号：5749163  密码：p2a8s7t5r14 </div>
                <div class="input">
            <!-- <input type="text" class="admin" v-model="user.admin"><br>
            <input type="password" class="password" v-model="user.password"><br> -->
                账号：<input class="admin" name="账号" type="text" v-model="user.admin"><br>
                密码：<input class="password" label="密码" type="password" v-model="user.password"><br>
                <button class="submit" @click="submit">登</button> 
                </div>
        
        </div>
            </el-aside>
            <el-main>
                <div class="Info">
                <div class="single_info" v-for="(item,index) in notice" :key="item.id">
                <h4>{{ item.msg }}</h4>    
                <p>{{ item.updateTime | getDateTime }}</p>
                </div>
                </div>
            </el-main>
        </el-container> 
        </keep-alive>
        
    </div>
</template>
<script>
import { Message } from 'element-ui';
import {getNotice} from "../network/utils"
export default{
    name:"login",
    data(){
        return{
            user:{
                admin:"",
                password:""
            },
            notice:"",
        }
    },
    methods:{
        async submit(){
        let result  = await this.$axios({
            method:"post",
            url:"/login",
            timeout: 30000,
            data:{
                admin:this.user.admin,
                password:this.user.password,
            }
        })
        console.log(result);
        if(result.data.code==200){
            this.$message.success("登录成功");
            this.$store.isLogin = true;
            this.$store.state.userId =result.data.result.userId;
            sessionStorage.setItem("userId",result.data.result.userId);
            await console.log("userId = "+this.$store.state.userId);
            this.$router.push({path:"/index"});
            
        } else {
            this.$message.error("登录失败")
        }
        // this.$store.isLogin = true;
        // this.$router.push({path:"/index"});
        }
           
    },
    
    async created(){
        if(sessionStorage.getItem("notice")){
            this.notice = JSON.parse(sessionStorage.getItem("notice"));
        } else{
            let re = await getNotice()
            this.notice = re;
            sessionStorage.setItem("notice",JSON.stringify(re));
        }                      
        
    },
    filters:{
        getDateTime(value) {
	        return (new Date(value)).toLocaleDateString() + " " + (new Date(value)).toLocaleTimeString()
        },

    }
   
}


</script>
<style>
*{
    margin:0;
    padding:0;
}
#login{
    width:100vw;
    height:100vh;
    min-width:700px;
    min-height:500px;
}
.background{
    width:100%;
    height:100%;
    min-width:1109px;
    min-height:585px;
    z-index: -1;
    position:absolute;
    
}
.float{
    position:absolute;
    background:white;
    top:0;
    left:0;
}
.el-container{
    width:100%;
    height:100%;
}
/**-----------左边，登录 */
.el-aside{
    box-sizing:border-box;
    width:40vw;
    min-width:600px;
    height:100%;
    min-height:500px;
    /* border:1px red solid; */
    z-index:10;
    display:flex;
    justify-content: center;
    align-items: center;
}
.el-aside>div{
    display:flex;
    flex-flow:nowrap;
    width:270px;
    min-height:470px;
    height:80%;
    background:url("../../static/登录框.png");
    background-size:cover;
    
    /* border:1px solid black; */
    justify-content: center;
    align-items:center;
}
.input ,.Info{
    position:absolute;
}
/**-----------输入框---输入账号密码 */
.input{
    color:#385339;
    font-family: 华文新魏;
    font-weight:600;    
    justify-content: center;
}
.admin ,.password{
    width:180px;
    height:26px;
    margin:5px 0;
    padding:0 2px;
    background-color:#385339;
    border:none;
    border-radius:10px;
    color:white;
    line-height:26px;
    outline: none;
}
button.submit{
    float:right;
    border-radius:50%;
    width:30px;
    height:30px;
    background-color:#385339;
    color:#fff;
    font-weight:600;
    font-family:华文新魏;
  
}
/**--------公告栏---------- */
.el-main{
    /* border:1px solid blue; */
    box-sizing: border-box;
    display:flex;
    align-items: center;
}
.Info{
    box-sizing:border-box;
    width:550px;
    height:400px;
    /* border: red 1px solid; */
    color:white;
    padding:0 32px;
    background-image: url("../../static/公告板.png");
    background-size: cover;
    /**弹性盒模型控制文本居中 */
    display:flex;
    flex-direction: column;
    flex-wrap: nowrap;
   justify-content: center;
}
.single_info{
    height:30px;
    line-height:30px;
}
.Info h4, .Info p{
    display:inline;
}

.single_info p{
    float:right;
}
</style>
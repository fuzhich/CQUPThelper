<template>
    <div id="login">
        <img class="background" src="../../static/登录.jpg">
        <div class="float"> 账号：5749163  密码：p2a8s7t5r14 </div>
        <div class="input">
            <!-- <input type="text" class="admin" v-model="user.admin"><br>
            <input type="password" class="password" v-model="user.password"><br> -->
            <input class="admin" type="text" v-model="user.admin"><br>
            <input class="password" type="password" v-model="user.password"><br>
            <button class="submit" @click="submit">提交</button>
        </div>
        <div class="Info">
            <div class="single_info" v-for="(item,index) in notice" :key="item.id">
                <h4>{{ item.msg }}</h4>    
                <p>{{ item.updateTime | getDateTime }}</p>
            </div>
        </div>
    </div>
</template>
<script>
import { Message } from 'element-ui';
export default{
    name:"login",
    data(){
        return{
            user:{
                admin:"",
                password:""
            },
            notice:this.$store.state.notice,
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
            await console.log("userId = "+this.$store.state.userId);
            this.$router.push({path:"/index"})
            
        } else {
            this.$message.error("登录失败")
        }
        // this.$store.isLogin = true;
        // this.$router.push({path:"/index"});
        }
           
    },
    
    async created(){
        let re = await this.$axios({
            method:"get",
            url:"/notice",
            timeout:30000,
            params:{
                limit:4,
            }
        });
        if(re.data.code ==200){
            console.log(re);
            this.notice = re.data.result.data;
            this.$store.state.notice=re.data.result.data;
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

.background{
    width:100vw;
    height:100vh;
    min-width:1350px;
    min-height:610px;
    z-index: -1;
    position:absolute;
}
.float{
    position:absolute;
    background:white;
}
.input ,.Info{
    position:absolute;
}
.input{
    border:1px black solid;
    height:200px;
    width:210px;
    margin-right:100px;
    margin-top:240px;
    margin-left:206px;
    justify-content: center;
}
.admin ,.password{
    margin:18px auto 0px;
    height:24px;
    width:200px;
    border:none;
    outline: none;
    /* background-color:rgba(127, 255, 212, 0); */
    background-color:green;
    line-height:20px;
    color:white;
}
button.submit{
    margin-top:34px;
    margin-left:150px;
    border:none;
    border-radius:50%;
    width:30px;
    height:30px;
    
}
.Info{
    width:500px;
    height:300px;
    /* border: red 1px solid; */
    color:white;
    left:600px;
    top:200px;
    
}
.Info h4, .Info p{
    display:inline;
}
.single_info{
    height:30px;
    line-height:30px;
}
.single_info p{
    float:right;
}
</style>
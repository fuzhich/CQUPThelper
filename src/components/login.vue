<template>
    <div id="login">
        <img class="background" src="../../static/登录.jpg">
        <div class="input">
            <form>
                <input type="text" class="admin" v-model="user.admin"><br>
                <input type="password" class="password" v-model="user.password"><br>
                <input type="submit" @click="submit" value="">
            </form>
        </div>
        <div class="Info">
            <h3>动态生成公告内容</h3>
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
            }
        }
    },
    methods:{
        submit(){
            // console.log(this.user);
            // alert("login");
            this.$router.push({path:"/index"});
            this.$store.commit("updateLoginStatus",true);
        }
    }
}
</script>
<style>
*{
    margin:0;
    padding:0;
}

.background{
    width:1350px;
    height:610px;
    z-index: -1;
    position:absolute;
}
.input ,.Info{
    position:absolute;
}
.input{
    /* border:1px black solid; */
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
    line-height:20px;
    color:white;
}
input[type="submit"]{
    margin-top:34px;
    margin-left:152px;
    border:none;
    border-radius:50%;
    width:30px;
    height:30px;
    opacity: 0.2;
}
.Info{
    width:500px;
    height:300px;
    /* border: red 1px solid; */
    color:white;
    left:600px;
    top:200px;
    
}
</style>
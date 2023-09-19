
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
                <div class="dishes" v-for="(item,index) in dishes" :key="index">
               <h4>{{ item.name }}</h4> <p> {{ item.pricce }}元</p>
                </div>
            </el-main>
        </el-container>
        
    </div>
</template>
<script>
//滚动条样式
import "./scroll.css"

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
    min-width:700px;
    min-height:500px;
    overflow: hidden;
}
/**背景图 */
.background{
    position:absolute;
    width:100vw;
    height:100vh;
    z-index:-1;
    min-width: 1000px;
    min-height:400px;
}
/**----------------------头                          */
.header{
    display: inline-flex;
    align-items:center;
}
.header h2,.header h3{
    display: inline-block;
}

.el-container{
    width:100%;
    height:100%;
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
/**----------主体----------- */
.el-main{
    width:100%;
    overflow: scroll; 
    height:calc(100vh - 70px);
    min-height:430px;
    box-sizing: border-box;
    padding:0 4%;
    display:flex;
    flex-flow: row wrap;
    align-content: flex-start;
}
.back{
    user-select: none;
    cursor: pointer;
    font-size:48px;
    font-weight:300;
    color:#385339;
}
.dishes{
    display:inline-flex;
    /* border:#385339 1px solid; */
    height:3em;
    line-height:3em;
    width:20rem;
    text-align: justify;
    margin:0 2em;
    padding:0;
    display:flex;
    flex-direction: row;
    justify-content: space-between;
}
.dishes>h4{
    display: inline-block;    
}
.dishes>p{
    display:inline-block;
}
</style>
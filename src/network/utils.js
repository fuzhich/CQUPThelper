//        获取每日公告 *****************
import axios from "axios";
export async function getNotice(){
    let re = await axios({
            method:"get",
            url:"/notice",
            timeout:30000,
            params:{
                limit:4,
            }
        })
    if(re.data.code ==200){
            console.log(re.data.result.data);
            return re.data.result.data;
            // this.$store.state.notice=re.data.result.data;
            // localStorage.setItem("notice",JSON.stringify(re.data.result.data))
        } else {
            this.$message.error("获取公告失败");
        }
    }
    
    
    


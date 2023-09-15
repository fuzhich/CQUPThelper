//此文件已废弃
import axios from 'axios';
import vuex from '../store/index';
import { Message } from 'element-ui';

// 该项目所有请求均为 get请求
export default function request() {
  // 请求超过30秒则判定为超时
  const AxiosRequest = axios.create({
    
    baseURL:"/api",
    timeout: 30000,
    // withCredentials: true,
  });
    
  return AxiosRequest;
 
}
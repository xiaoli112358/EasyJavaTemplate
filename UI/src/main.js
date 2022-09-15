import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import VueRouter from 'vue-router'
import store from './vuex/store'
import Vuex from 'vuex'
import routes from './routes'
import 'font-awesome/css/font-awesome.min.css'
import axios from 'axios'
import { Notification, MessageBox, Message, Loading } from 'element-ui'

//跳转到登录页面
function goToLoginPage(message){
    MessageBox.confirm(message, '系统提示', {
            confirmButtonText: '重新登录',
            cancelButtonText: '取消',
            type: 'warning'
        }
    ).then(() => {
        location.href = '/login#/login';
    }).catch(() => {
        location.href = '/login#/login';
    });
}
//响应拦截器
axios.interceptors.response.use(res => {
    const code = res.data.code || 200;
    const message = res.data.message
    console.log("后台响应状态码=" + code);
    if(code != null && code == '9999'){
        goToLoginPage(message);
        return Promise.reject(new Error(message));
    }else{
        return res;
    }
},error => {
    console.log('err' + error)
    let { message } = error;
    if (message == "Network Error") {
        message = "后端接口连接异常";
    }
    else if (message.includes("timeout")) {
        message = "系统接口请求超时";
    }
    else if (message.includes("Request failed with status code")) {
        message = "系统接口" + message.substr(message.length - 3) + "异常";
    }
    Message({
        message: message,
        type: 'error',
        duration: 5 * 1000
    });
    return Promise.reject(error);
});

//axios前置拦截器，每次请求都会走这里
axios.interceptors.request.use(config => {
    //如果已经登录了,每次都把token作为一个请求头传递过程
    if (localStorage.getItem('U-TOKEN')) {
        // 让每个请求携带token--['X-Token']为自定义key 请根据实际情况自行修改
        config.headers['token'] = localStorage.getItem('U-TOKEN');
    }
    // console.debug('config',config)
    return config
}, error => {
    // Do something with request error
    Promise.reject(error)
});

//配置axios的全局基本路径
axios.defaults.baseURL='http://localhost:8002'
//全局属性配置，在任意组件内可以使用this.$http获取axios对象
Vue.prototype.$http = axios

import BaiduMap from 'vue-baidu-map'

Vue.use(BaiduMap, {
    // ak 是在百度地图开发者平台申请的密钥 详见 http://lbsyun.baidu.com/apiconsole/key */
    ak: 'TvDzvZNeapR0NfFRHj7ejjB4odWSH51O'
})
Vue.use(ElementUI)
Vue.use(VueRouter)
Vue.use(Vuex)

//NProgress.configure({ showSpinner: false });

const router = new VueRouter({
  routes
})

//前置拦截器（每次发送请求之前，会执行该方法）每次路由之前都要执行,每次请求都要经过路由
router.beforeEach((to, from, next) => {
    if (to.path == '/login') {
        //如果访问的是/login路径，就把原来存localStorage的用户信息移除掉
        localStorage.removeItem('avatar');
        localStorage.removeItem('userName');
        localStorage.removeItem('U-TOKEN');
    }
    next();
    //从localStorage获取用户信息做判断
    let userName = localStorage.getItem('userName');
    //如果访问/login和/register路径以外的路径都需要user有值，才能继续访问，否则就跳转到登录页面进行登录
    if (!userName &&(to.path != '/login' && to.path != '/register') ) {
        //没有登录，则跳转到登录页面
        // next({ path: '/login' })
        goToLoginPage("认证状态失效，请重新登录！");
    } else {
        //已经登录,正常访问
        next();
    }
});
//router.afterEach(transition => {
//NProgress.done();
//});

new Vue({
  //el: '#app',
  //template: '<App/>',
  router,
  store,
  //components: { App }
  render: h => h(App) // index.html id为app的div标签下面使用<App/>和template: '<App/>',一样的效果
}).$mount('#app') // 和el: '#app'效果一样都是挂载在index.html id为app的div标签上面


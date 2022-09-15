import babelpolyfill from 'babel-polyfill'
import Vue from 'vue'
import App from './App'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
// import 'element-ui/lib/theme-default/index.css'
//import './assets/theme/theme-green/index.css'
import VueRouter from 'vue-router'
import store from './vuex/store'
import Vuex from 'vuex'
//import NProgress from 'nprogress'
//import 'nprogress/nprogress.css'
import routes from './routes'
// import Mock from './mock'
// Mock.bootstrap();
import 'font-awesome/css/font-awesome.min.css'

import axios from 'axios'

//响应拦截器
axios.interceptors.response.use(config => {
    return config
},error => {
    if (error && error.response) {
        console.log("===================================");
        console.log(error);
    }
    Promise.reject(error)
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
    console.log("********************");
    if (to.path == '/login') {
        //如果访问的是/login路径，就把原来存localStorage的用户信息移除掉
        localStorage.removeItem('avatar');
        localStorage.removeItem('userName');
        localStorage.removeItem('U-TOKEN');
    }
    next()
    /*//从localStorage获取用户信息做判断
    let user = JSON.parse(localStorage.getItem('user'));
    //如果访问/login和/register路径以外的路径都需要user有值，才能继续访问，否则就跳转到登录页面进行登录
    if (!user &&(to.path != '/login' && to.path != '/register') ) {
        //没有登录，则跳转到登录页面
        next({ path: '/login' })
    } else {
        //已经登录,正常访问
        next()
    }*/
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


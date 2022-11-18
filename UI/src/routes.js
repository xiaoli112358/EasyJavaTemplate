import Login from './views/Login.vue'
import NotFound from './views/404.vue'
import Home from './views/Home.vue'
import User from './views/system/User.vue'
import SysOrder from './views/order/SysOrder.vue'
import SysEmp from './views/system/SysEmp.vue'
import echarts from './views/charts/echarts.vue'

//路由配置
let routes = [
    {
        path: '/login',
        component: Login,
        name: '',
        hidden: true
    },
    {
        path: '/404',
        component: NotFound,
        name: '',
        hidden: true
    },
    {
        path: '/',
        component: Home,
        name: '首页',
        leaf: true,//只有一个节点
        iconCls: 'fa fa-bar-chart',
        children: [
            { path: '/echarts', component: echarts, name: '首页' }
        ]
    },
    {
        path: '/',
        component: Home,
        name: '系统管理',
        iconCls: 'el-icon-setting',//图标样式class
        children: [
            { path: '/User', component: User, name: '用户管理' },
            { path: '/SysEmp', component: SysEmp, name: '员工管理' },
            { path: '/SysOrder', component: SysOrder, name: '订单管理' }
        ]
    }
    ,
    {
        path: '*',
        hidden: true,
        redirect: { path: '/404' }
    }
];

export default routes;
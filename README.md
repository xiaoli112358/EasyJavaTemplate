# EasyJavaTemplate

![mp](images/mp.png)

## 1、技术栈

1. 后台：SpringBoot、MyBatisPlus、Redis、MySQL
2. 前端：VUE、ElementUI（前端页面采用静态路由）

> 特点：

本项目最大的特点就是，能够为大家提供快速开发脚手架，后台的代码生成工具类，可以一键生成后台和前台所有代码，包括：controller、mapper、domain、service、mapper.xml、vue页面等，**实战起来开发效率非常高**

## 2、后台如何运行

1. 将SQL脚本在数据库中执行一下
2. 修改application.yml中连接数据库/Redis等服务器的参数，确保可以连接上就可以了
3. 然后运行启动类即可

## 3、前台如何运行

1. npm install：安装相关依赖
2. npm run dev：启动项目

> 注意点：

config/index.js中的assetsPublicPath的值需要根据实际情况修改：

1. IDEA运行时这样配置：assetsPublicPath: '/'
2. build打包时这样配置：assetsPublicPath: './'



下面是相关报错解决方案：

### 3.1、node-sass报错

如果你npm install时，报错信息中包含下面错误：

npm ERR! node-sass@4.12.0 postinstall: `node scripts/build.js`

那就这样解决：

```
首先保证你本地Git已经正确安装成功了，然后在前端目录中cmd，依次执行下面命令即可解决：
npm install -g node-gyp
npm install --global --production windows-build-tools //注意，如果运行这一行报错的话，不用管，继续运行下面的命令即可
npm uninstall node-sass
npm i node-sass --sass_binary_site=https://npm.taobao.org/mirrors/node-sass/
npm install
npm run dev
```



## 4、后续

大家想学什么技术栈，想做什么功能的，可以留言，我会尽快更新进去，希望大家能有所收获

## 5、登录

运行成功登录页面：

![image-20220921125433440](images/image-20220921125433440.png)

账号：admin

密码：123456

登录成功首页：

![image-20220921125536460](images/image-20220921125536460.png)

目前里面只有两个菜单：用户管理和员工管理：

![image-20220921125608210](images/image-20220921125608210.png)

![image-20220921125627268](images/image-20220921125627268.png)

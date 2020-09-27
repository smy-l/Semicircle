## 项目介绍

`mall-admin-web`是一个电商后台管理系统的前端项目，基于Vue+Element实现。主要包括商品管理、订单管理、会员管理、促销管理、运营管理、内容管理、统计报表、财务管理、权限管理、设置等功能。

### 项目演示

项目在线演示地址：[http://mall.banyuan.club/](http://mall.banyuan.club)

### 技术选型

技术 | 说明 | 官网
----|----|----
Vue | 前端框架 | [https://vuejs.org/](https://vuejs.org/)
Vue-router | 路由框架 | [https://router.vuejs.org/](https://router.vuejs.org/)
Vuex | 全局状态管理框架 | [https://vuex.vuejs.org/](https://vuex.vuejs.org/)
Element | 前端UI框架 | [https://element.eleme.io/](https://element.eleme.io/)
Axios | 前端HTTP框架 | [https://github.com/axios/axios](https://github.com/axios/axios)
v-charts | 基于Echarts的图表框架 | [https://v-charts.js.org/](https://v-charts.js.org/)
Js-cookie | cookie管理工具 | [https://github.com/js-cookie/js-cookie](https://github.com/js-cookie/js-cookie)
nprogress | 进度条控件 | [https://github.com/rstacruz/nprogress](https://github.com/rstacruz/nprogress)
vue-element-admin | 项目脚手架参考 | [https://github.com/PanJiaChen/vue-element-admin](https://github.com/PanJiaChen/vue-element-admin)

### 项目布局

``` lua
src -- 源码目录
├── api -- axios网络请求定义
├── assets -- 静态图片资源文件
├── components -- 通用组件封装
├── icons -- svg矢量图片文件
├── router -- vue-router路由配置
├── store -- vuex的状态管理
├── styles -- 全局css样式
├── utils -- 工具类
└── views -- 前端页面
    ├── home -- 首页
    ├── layout -- 通用页面加载框架
    ├── login -- 登录页
    ├── oms -- 订单模块页面
    ├── pms -- 商品模块页面
    └── sms -- 营销模块页面
```

## 搭建步骤
- 下载node并安装：[https://nodejs.org](https://nodejs.org);
- 如果无法按运行node，则需要配置环境变量
```
export PATH="/Users/liyi/works/develop/node-v12.15.0-darwin-x64/bin:$PATH"
```
- 进入项目文件夹，命令行中运行命令：`npm install`,下载相关依赖;
- 命令行中运行命令：`npm run dev`,运行项目;
- 访问地址：[http://localhost:8090](http://localhost:8090) 即可打开后台管理系统页面;

## nodejs安装问题
#### 问题
如果windows下运行`npm install`时遇到如下问题
```
npm ERR! code EBADPLATFORM
npm ERR! notsup Unsupported platform for fsevents@2.1.2: wanted {"os":"darwin","arch":"any"} (current: {"os":"win32","arch":"x64"})
npm ERR! notsup Valid OS:    darwin
npm ERR! notsup Valid Arch:  any
npm ERR! notsup Actual OS:   win32
npm ERR! notsup Actual Arch: x64
```
执行以下命令之后，在运行`npm install`
```
npm i -f
```

#### 问题
如果`npm install`时遇到如下问题
```
node-pre-gyp ERR! Tried to download(404): https://fsevents-binaries.s3-us-west-2.amazonaws.com/v1.2.3/fse-v1.2.3-node-v72-darwin-x64.tar.gz node-pre-gyp ERR! Pre-built binaries not found for fsevents@1.2.3 and node@12.15.0 (node-v72 ABI, unknown) (falling back to source compile with node-gyp)
```
运行以下命令之后再运行`npm install`
```
npm install fsevents@latest
```

运行`npm run dev`出现的问题

```
npm install webpack-dev-server -g

npm install -g webpack

npm install node-sass@latest
```


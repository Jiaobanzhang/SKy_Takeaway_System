1️⃣项目介绍: 这个项目是一个外卖单体项目(不涉及微服务)

2️⃣项目技术选型: (简单介绍一下该项目用到的技术)
<img width="948" alt="截屏2024-08-25 17 35 36" src="https://github.com/user-attachments/assets/43ef0ca8-220e-403c-999c-988dbe5897a7">

1.网关层 :

  Nginx: 当前端的请求发送给后端的时候, Nginx 可以起到反向代理的作用.(使用方式: 自己使用 VMware 部署了 Centos 虚拟机, 在虚拟机中使用 docker 下载 Nginx 镜像, 其中Nginx中有三个文件额外重要(如下图所示, 分别是 nginx日志, nginx 配置文件, nginx存放默认前端的文件), 其中 nginx 配置文件中标注了 nginx的81端口和虚拟机的80端口进行对应, 并且能够根据前端的访问地址分别反向代理到 html 文件所在地址和 后端服务器所在地址)
  
<img width="186" alt="截屏2024-08-25 18 13 22" src="https://github.com/user-attachments/assets/7b36d912-1cad-4ef3-892c-f885f91b360b">
<img width="1000" alt="截屏2024-08-25 18 17 36" src="https://github.com/user-attachments/assets/ffe3e5bb-a956-4ddb-a891-f32bde38aa2d">
<img width="742" alt="截屏2024-08-25 18 26 51" src="https://github.com/user-attachments/assets/43419bab-114d-47b1-9bbf-eaf17a20dd83">

2. 应用层:
   
  (1) Swagger: 用于生成接口文档, 可以进行后端的接口测试
  
  (2) JWT:
  
  (3) 阿里云:
  
  (4) httpClient:
  
  (5) Spring Cache:
  

3. 数据层:

   (1) Redis: 用于缓存菜品数据和商店的状态信息.
     先使用终端开启 redis:
   
     <img width="706" alt="截屏2024-08-26 01 56 34" src="https://github.com/user-attachments/assets/2aad5c03-18e3-4374-9d57-9f54770e1819">

    然后在使用 Another redis Desktop Manager 进行可视化操作redis
   
   (2) pagehelper: 用于将后端查询到的数据进行分页
   
   (3) spring data redis: 一种redis的Java 客户端, 可以通过 Spring data redis 来操作 redis
   
    <img width="974" alt="截屏2024-08-26 02 02 32" src="https://github.com/user-attachments/assets/3be6425c-f622-4b90-b94f-2448bfaf0d7a">

# 用一个Blog练习springboot+mybatis+vue.js
纯前端模板来源--->[杨青|女程序员的个人博客](http://www.yangqq.com/) 

2019.3.1补充: 系统为响应式布局，前端总的布局为模块，其中的一些页面为自己添加。

## 代码用到的技术
* 代码均用idea编写
* springboot+mybatis(用[MybatisGenerator逆向工程](https://github.com/GaryLeeeee/MybatisGenerator-UI))提高开发效率
* 前端js框架用Jquery和vue.js
* 数据库用mysql(后续可能会结合redis等)

## 已经实现的功能
* #### 日志列表(用来显示全部日志,其中分页技术用的是mybatis的分页插件PageHelper)
![日志列表](https://github.com/GaryLeeeee/blog/blob/master/image/%E6%97%A5%E8%AE%B0%E5%88%97%E8%A1%A8.jpg)<br>

* #### 日志详情(通过vue进行响应式渲染数据,点赞量和访问量的实现目前通过mysql,后期会结合redis)
![日志详情](https://github.com/GaryLeeeee/blog/blob/master/image/%E6%97%A5%E5%BF%97%E8%AF%A6%E6%83%85%E9%A1%B5.jpg)<br>

* #### 日志编辑(用的是[所见即所得轻量级WYSIWYG编辑器](http://www.jq22.com/jquery-info1679),可格式化存放入数据库(Text格式存储))
![日志编辑](https://github.com/GaryLeeeee/blog/blob/master/image/%E6%97%A5%E8%AE%B0%E7%BC%96%E8%BE%91%E5%99%A8.jpg)<br>

* #### 相册列表
![相册列表](https://github.com/GaryLeeeee/blog/blob/master/image/%E7%9B%B8%E5%86%8C%E5%88%97%E8%A1%A8.jpg)<br>

* #### 相册详情页(列表查看/高清查看)
![相册详情页](https://github.com/GaryLeeeee/blog/blob/master/image/%E7%9B%B8%E5%86%8C%E8%AF%A6%E6%83%85%E9%A1%B5.jpg)<br>

* #### 图片上传(用的是[jquery图片上传](http://www.jq22.com/jquery-info1845),可批量上传图片)
![图片上传](https://github.com/GaryLeeeee/blog/blob/master/image/%E5%9B%BE%E7%89%87%E4%B8%8A%E4%BC%A0.jpg)<br>

## 待实现功能
搜索功能(√)，日志分类，标签，留言板，评论功能，置顶操作，相册页(√)，根据访问量和点赞量排行(√)，管理员权限(√)等.

## 优化点
* 界面可以通过异步刷新数据，避免共同的资源重复请求
* mysql级联删除

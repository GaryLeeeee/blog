# 用一个Blog练习springboot+mybatis+vue.js
纯前端模板来源--->[杨青|女程序员的个人博客](http://www.yangqq.com/) 

## 代码用到的技术
* 代码均用idea编写
* springboot+mybatis(用[MybatisGenerator逆向工程](https://github.com/GaryLeeeee/MybatisGenerator-UI))提高开发效率
* 前端js框架用Jquery和vue.js
* 数据库用mysql(后续可能会结合redis等)

## 已经实现的功能
* #### 日志列表(用来显示全部日志,其中分页技术用的是mybatis的分页插件PageHelper)
![avatar](http://pfyy4w362.bkt.clouddn.com/%E6%97%A5%E5%BF%97%E5%88%97%E8%A1%A8.png)<br>

* #### 日志编辑(用的是[所见即所得轻量级WYSIWYG编辑器](http://www.jq22.com/jquery-info1679),可格式化存放入数据库(Text格式存储))
![avatar](http://pfyy4w362.bkt.clouddn.com/%E6%97%A5%E5%BF%97%E7%BC%96%E8%BE%91.png)<br>

* #### 日志详情(通过vue进行响应式渲染数据,点赞量和访问量的实现目前通过mysql,后期会结合redis)
![avatar](http://pfyy4w362.bkt.clouddn.com/%E6%97%A5%E5%BF%97%E8%AF%A6%E7%BB%86.png)<br>

## 待实现功能
搜索功能，日志分类，标签，留言板，评论功能，置顶操作，相册页，根据访问量和点赞量排行，管理员权限等.

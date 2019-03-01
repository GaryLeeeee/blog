// 主页的初始化工作
new Vue({
    el:"#demo",
    data:{
        pictures:[],
        pageInfo:[],
        blogs:[],
        sortedBlogs:[]
    },
    created:function () {
        var self = this;
        $.ajaxSettings.async = false;//设置后则为同步执行(即执行完ajax才执行后续代码)
        //访问量
        $.get(
            "showPictures",
            function (data) {
                self.pictures = data;
            }
        );
        $.get(
            "getBlogPageInfo",
            {start: GetQueryString("start"?"start":0)},
            function (data) {
                self.pageInfo = data;
                self.blogs = data["list"];
            }
        )
        $.get(
            "sortBlogs",
            function (data) {
                self.sortedBlogs = data;
            }
        )
    },
    methods: {
        goTo: function (event) {//页数跳转
//                获取当前标签的文本值
            var text = event.target.innerHTML;
            console.log("点击事件(页数为):" + text);
            window.location.href = "list?start=" + text;
        },
        search: function () {
            var self = this;
//                console.log("搜索");
//                console.log($('#keyboard').val());
            /*
            缺：查询到的结果分页，关键词高亮
             */
            $.get(
                "searchBlog",
                {keyword: $('#keyboard').val(), start: GetQueryString("start" ? "start" : 0)},
                function (data) {
//                        self.blogs = data;
                    self.pageInfo = data;
                    self.blogs = data["list"];
//                      在搜索列表第一个上面加上提示信息(搜索结果),不直接在父级容器加(对不齐)
                    $(".pp:first").before("<font>搜索结果(" + $('#keyboard').val() + "):</font>")
                }
            )
        }
    }
});
function GetQueryString(name) {//获取url中key为name的value
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}
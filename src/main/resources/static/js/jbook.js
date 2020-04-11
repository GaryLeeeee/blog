// 主页的初始化工作
new Vue({
    el:"#demo",
    data:{
        pictures:[],
        pageInfo:[],
        blogs:[],
        sortedBlogs:[],
        messages:[]
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
            "getMessagePageInfo",
            {start: (GetQueryString("start")?GetQueryString("start"):0),type:3,targetId:-1},
            function (data) {
                self.pageInfo = data;
                self.messages = data["list"];
            }
        )
    },
    methods: {
        goTo: function (event) {//页数跳转
//                获取当前标签的文本值
            var text = event.target.innerHTML;
            console.log("点击事件(页数为):" + text);
            window.location.href = "list?start=" + text;
        }
    }
});
function GetQueryString(name) {//获取url中key为name的value
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return unescape(r[2]);
    return null;
}

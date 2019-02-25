new Vue({
    el:"#demo",
    data:{
        pictures:[]
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

    }
});
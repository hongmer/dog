Page({
    onTap:function(){
        // wx.navigateTo(({
        //     url: '../home/home',父页面跳到子页面 可以返回原页面
        // }));

        wx.redirectTo({
            url: '../home/home',//平行跳
        })
    }
})

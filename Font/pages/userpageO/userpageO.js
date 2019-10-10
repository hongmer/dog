var userpostsData = require('../../data/userposts-data.js')
Page({
  lookingForDetail: function() {
    wx.navigateTo(({
      url: '../detail/detail',
    }));
  },
  onTap: function() {
   // wx.navigateTo(({
   //     url: '../revise/revise',父页面跳到子页面 可以返回原页面
   // }));
   wx.redirectTo({
   url: '../revise/revise', //平行跳
   })
  },
  lookingForDetail: function () {
    wx.navigateTo(({
      url: '../submitted/submitted', //先写好跳转函数 检测跳转是否成功
    }));
  },
    data: {
        username:"refresh",
        usersex:"男",
        userlocal:"地球",
        userimage:"/images/avatar/1.png",
        userword:"se太难了",
    active: 0,
    icon: {
      normal: '//img.yzcdn.cn/icon-normal.png',
      active: '//img.yzcdn.cn/icon-active.png'
    },
    date: "2019年1月7日",
    posts_key: [

          ]
        },
        /**
         * 点击下面的三个按钮的事件函数
         */
        onChange(event) {
          console.log(event.detail);
        },
        /**
         * 生命周期函数--监听页面初次渲染完成
         */
  onLoad: function (options) {
    //页面初始化 option为 页面跳转所带来的参数
   
    this.setData({
      posts_key: userpostsData.userpostsList
    });
  },
        onReady: function() {

        },

        /**
         * 生命周期函数--监听页面显示
         */
        onShow: function() {

        },

        /**
         * 生命周期函数--监听页面隐藏
         */
        onHide: function() {

        },

        /**
         * 生命周期函数--监听页面卸载
         */
        onUnload: function() {

        },

        /**
         * 页面相关事件处理函数--监听用户下拉动作
         */
        onPullDownRefresh: function() {

        },

        /**
         * 页面上拉触底事件的处理函数
         */
        onReachBottom: function() {

        },

        /**
         * 用户点击右上角分享
         */
        onShareAppMessage: function() {

        }
      })
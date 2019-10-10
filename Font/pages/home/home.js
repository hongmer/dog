var postsData = require('../../data/posts-data.js')
// pages/home/home.js
Page({
  goToAdd: function() {
    wx.navigateTo(({
      url: '../add/add',
    }));
  },
  lookingForHelp: function () {
    wx.navigateTo(({
      url: '../help/help',
    }));
    wx.request({
      url: 'http://localhost:8080/Pets/petsHelpList?pets_kind=mao&pets_address=abc',
      data: {
        message:'damn_se!',
      },
      header: {
        'content-type': 'application/json'
      },
      method:'GET',
            success: function (res) {
        console.log("message"+res.data);
      
      },
      fail: function (err) {
        console.log(err)
      }
    })

  },
  willingToAdopt: function() {
    wx.navigateTo(({
      url: '../adopt/adopt', //先写好跳转函数 检测跳转是否成功
    }));
    wx.request({
      url: 'http://localhost:8080/Pets/petsHelpList?pets_kind=mao&pets_address=abc',
      data: {
        message: 'damn_se!',
      },
      header: {
        'content-type': 'application/json'
      },
      method: 'GET',
      success: function (res) {
        console.log("message" + res.data);

      },
      fail: function (err) {
        console.log(err)
      }
    })
  },

  lookingForDetail: function() {
    wx.navigateTo(({
      url: '../detail/detail',
    }));
    wx.request({
      url: 'http://localhost:8080/Pets/personalAdoptSaveList?pets_name=hong&pets_kind=neko&pets_address=abb',
      data: {
        message: 'damn_se!',
      },
      header: {
        'content-type': 'application/json'
      },
      method: 'GET',
      success: function (res) {
        console.log("message" + res.data);

      },
      fail: function (err) {
        console.log(err)
      }
    })

  },
  goToUser: function() {
    wx.navigateTo(({
      url: '../userpageO/userpageO',
    }));
  },
  /**
   * 页面的初始数据
   */
  data: {
    //小程序总是会读取data对象来做数据绑定，这个动作我们成为动作a
    //而这个动作a的执行，是在onLoad时间执行之后发生的
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
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    //页面初始化 option为 页面跳转所带来的参数
    this.setData({
      posts_key: postsData.postList
    });
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
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
// pages/addSuccess/addSuccess.js
Page({
  returnMine: function() {
    // wx.navigateTo(({
    //     url: '../home/home',父页面跳到子页面 可以返回原页面
    // }));

    wx.redirectTo({
      url: '../userpageO/userpageO', //平行跳
    })
  },
  returnHome: function() {
    // wx.navigateTo(({
    //     url: '../home/home',父页面跳到子页面 可以返回原页面
    // }));

    wx.redirectTo({
      url: '../home/home', //平行跳
    })
  },
  /**
   * 页面的初始数据
   */
  data: {

  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {

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
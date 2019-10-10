// pages/detail.js
Page({
  goToUser: function () {
    wx.navigateTo(({
      url: '../userpageO/userpageO',//先写好跳转函数 检测跳转是否成功
    }));
  },
  popupClose1: function () {
    wx.navigateTo(({
      url: '../home/home',//先写好跳转函数 检测跳转是否成功
    }));
  },
  popupClose2: function(){
    wx.navigateTo(({
      url: '../userpageO/userpageO',//先写好跳转函数 检测跳转是否成功
    }));
  },
  /**
   * 页面的初始数据
   */
  data: {
    show: false
  },
  popupOpen() {
    this.setData({ show: true });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var content =
    {
      name: "refresh",
      title: "【求助or领养】",
      img: {
        detail_img: "/images/post/crab.png",
        author_img: "/images/avatar/1.png"
      },
      content: "小宠物已经三个多月，会吃猫粮，用猫砂，性格开朗温顺！无偿赠送，养了就对它负责，不随意送人，接收偶尔的回访就行！",
    }
    this.setData(content);
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {

  }
})
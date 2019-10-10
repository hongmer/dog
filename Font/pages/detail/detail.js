var detailData = require('../../data/detail-data.js')
// pages/detail.js
Page({
    goToUser: function () {
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
    popupClose() {
        this.setData({ show: false });
    },
    /**
     * 生命周期函数--监听页面加载
     */
    onLoad: function (options) {
      content = {
        name: "refresh",
        title: " ",
        detail: "/images/post/crab.png",
        author: "/images/avatar/1.png",
        content: " 这只小动物真的可爱，你们说是不是啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊",
      }
      this.setData(content);
    },
  /**
   * 页面的初始数据
   */
  data: {
    show: false,
    aaa: "ABC123",
    detailData: {}
  },

  popupOpen() {
    this.setData({ show: true });
  },
  popupClose() {
    this.setData({ show: false });
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {

    var This = detailData.detailList;
   
    this.setData({
      detailData: This,
    });
    console.log(this.data.detailData);
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
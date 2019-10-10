package edu.hunnu.model;
import java.io.Serializable;
import java.sql.Timestamp;
public class petsTrade implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer tradeId;
	private Integer petsId;
	private petsAdop petsAdop;
	private Integer senderId;
    private users trade_sender;
	private Integer reciverId;
	private users trade_reciver;
	private Integer tradeStateId;
	private states tradeStates;
	private Timestamp saveTime;
	
	@Override
	public String toString() {
		return "petsTrade [tradeId=" + tradeId + ", petsId=" + petsId
				+ ", petsAdop=" + petsAdop + ", senderId=" + senderId
				+ ", trade_sender=" + trade_sender + ", reciverId=" + reciverId
				+ ", trade_reciver=" + trade_reciver + ", tradeStateId="
				+ tradeStateId + ", tradeStates=" + tradeStates + ", saveTime="
				+ saveTime + "]";
	}
	
	public Integer getTradeId() {
		return tradeId;
	}
	public void setTradeId(Integer tradeId) {
		this.tradeId = tradeId;
	}
	public Integer getPetsId() {
		return petsId;
	}
	public void setPetsId(Integer petsId) {
		this.petsId = petsId;
	}
	public petsAdop getPetsAdop() {
		return petsAdop;
	}
	public void setPetsAdop(petsAdop petsAdop) {
		this.petsAdop = petsAdop;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public users getTrade_sender() {
		return trade_sender;
	}
	public void setTrade_sender(users trade_sender) {
		this.trade_sender = trade_sender;
	}
	public Integer getReciverId() {
		return reciverId;
	}
	public void setReciverId(Integer reciverId) {
		this.reciverId = reciverId;
	}
	public users getTrade_reciver() {
		return trade_reciver;
	}
	public void setTrade_reciver(users trade_reciver) {
		this.trade_reciver = trade_reciver;
	}
	public Integer getTradeStateId() {
		return tradeStateId;
	}
	public void setTradeStateId(Integer tradeStateId) {
		this.tradeStateId = tradeStateId;
	}
	public states getTradeStates() {
		return tradeStates;
	}
	public void setTradeStates(states tradeStates) {
		this.tradeStates = tradeStates;
	}
	public Timestamp getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(Timestamp saveTime) {
		this.saveTime = saveTime;
	}
	
}

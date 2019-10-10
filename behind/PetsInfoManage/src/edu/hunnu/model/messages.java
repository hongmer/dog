package edu.hunnu.model;
import java.io.Serializable;
import java.sql.Timestamp;

public class messages implements Serializable{
	    private static final long serialVersionUID = 1L;
	    private Integer mesId;
	    private Integer mesSenderId;
	    private users mes_sender;
	    private Integer mesReceiverId;
	    private users mes_reciver;
	    private Integer saveStateId;
	    private states mesStates;
	    private String mesDescribe;
	    private Timestamp mesTime;
	    
	    
		@Override
		public String toString() {
			return "messages [mesId=" + mesId + ", mesSenderId=" + mesSenderId
					+ ", mes_sender=" + mes_sender + ", mesReceiverId="
					+ mesReceiverId + ", mes_reciver=" + mes_reciver
					+ ", saveStateId=" + saveStateId + ", mesStates="
					+ mesStates + ", mesDescribe=" + mesDescribe + ", mesTime="
					+ mesTime + "]";
		}
		
		
		public Integer getMesId() {
			return mesId;
		}
		public void setMesId(Integer mesId) {
			this.mesId = mesId;
		}
		public Integer getMesSenderId() {
			return mesSenderId;
		}
		public void setMesSenderId(Integer mesSenderId) {
			this.mesSenderId = mesSenderId;
		}
		public users getMes_sender() {
			return mes_sender;
		}
		public void setMes_sender(users mes_sender) {
			this.mes_sender = mes_sender;
		}
		public Integer getMesReceiverId() {
			return mesReceiverId;
		}
		public void setMesReceiverId(Integer mesReceiverId) {
			this.mesReceiverId = mesReceiverId;
		}
		public users getMes_reciver() {
			return mes_reciver;
		}
		public void setMes_reciver(users mes_reciver) {
			this.mes_reciver = mes_reciver;
		}
		public Integer getSaveStateId() {
			return saveStateId;
		}
		public void setSaveStateId(Integer saveStateId) {
			this.saveStateId = saveStateId;
		}
		public states getMesStates() {
			return mesStates;
		}
		public void setMesStates(states mesStates) {
			this.mesStates = mesStates;
		}
		public String getMesDescribe() {
			return mesDescribe;
		}
		public void setMesDescribe(String mesDescribe) {
			this.mesDescribe = mesDescribe;
		}
		public Timestamp getMesTime() {
			return mesTime;
		}
		public void setMesTime(Timestamp mesTime) {
			this.mesTime = mesTime;
		}
	    
	    
}

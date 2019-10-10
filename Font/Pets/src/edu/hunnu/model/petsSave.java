package edu.hunnu.model;
import java.io.Serializable;
import java.sql.Timestamp;
public class petsSave implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer saveId;
    private String saveLinkman;
	private String saveLmPhone;
    private String saveAddress;
    private String saveDescribe;
    private Integer senderId;
    private users save_sender;
    private Integer reciverId;
    private users save_reciver;
    private Integer saveStateId;
    private states saveStates;
    private Timestamp saveTime;
    private String save_img;
    private String save_species;
    
    
	public petsSave(String saveAddress, String saveDescribe, String save_img, String save_species) {
		super();
		this.saveAddress = saveAddress;
		this.saveDescribe = saveDescribe;
		this.save_img = save_img;
		this.save_species = save_species;
	}
	public petsSave() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getSave_species() {
		return save_species;
	}
	public void setSave_species(String save_species) {
		this.save_species = save_species;
	}
	public String getSave_img() {
		return save_img;
	}
	public void setSave_img(String save_img) {
		this.save_img = save_img;
	}
	@Override
	public String toString() {
		return "petsSave [saveId=" + saveId + ", saveLinkman=" + saveLinkman
				+ ", saveLmPhone=" + saveLmPhone + ", saveAddress="
				+ saveAddress + ", saveDescribe=" + saveDescribe
				+ ", senderId=" + senderId + ", save_sender=" + save_sender
				+ ", reciverId=" + reciverId + ", save_reciver=" + save_reciver
				+ ", saveStateId=" + saveStateId + ", saveStates=" + saveStates
				+ ", saveTime=" + saveTime + "]";
	}
	public Integer getSaveId() {
		return saveId;
	}
	public void setSaveId(Integer saveId) {
		this.saveId = saveId;
	}
	public String getSaveLinkman() {
		return saveLinkman;
	}
	public void setSaveLinkman(String saveLinkman) {
		this.saveLinkman = saveLinkman;
	}
	public String getSaveLmPhone() {
		return saveLmPhone;
	}
	public void setSaveLmPhone(String saveLmPhone) {
		this.saveLmPhone = saveLmPhone;
	}
	public String getSaveAddress() {
		return saveAddress;
	}
	public void setSaveAddress(String saveAddress) {
		this.saveAddress = saveAddress;
	}
	public String getSaveDescribe() {
		return saveDescribe;
	}
	public void setSaveDescribe(String saveDescribe) {
		this.saveDescribe = saveDescribe;
	}
	public Integer getSenderId() {
		return senderId;
	}
	public void setSenderId(Integer senderId) {
		this.senderId = senderId;
	}
	public users getSave_sender() {
		return save_sender;
	}
	public void setSave_sender(users save_sender) {
		this.save_sender = save_sender;
	}
	public Integer getReciverId() {
		return reciverId;
	}
	public void setReciverId(Integer reciverId) {
		this.reciverId = reciverId;
	}
	public users getSave_reciver() {
		return save_reciver;
	}
	public void setSave_reciver(users save_reciver) {
		this.save_reciver = save_reciver;
	}
	public Integer getSaveStateId() {
		return saveStateId;
	}
	public void setSaveStateId(Integer saveStateId) {
		this.saveStateId = saveStateId;
	}
	public states getSaveStates() {
		return saveStates;
	}
	public void setSaveStates(states saveStates) {
		this.saveStates = saveStates;
	}
	public Timestamp getSaveTime() {
		return saveTime;
	}
	public void setSaveTime(Timestamp saveTime) {
		this.saveTime = saveTime;
	}
	
}

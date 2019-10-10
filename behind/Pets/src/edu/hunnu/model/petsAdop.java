package edu.hunnu.model;
import java.io.Serializable;
import java.sql.Timestamp;
public class petsAdop implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer pets_id;
	private String pets_name;
	private String pets_kind;
	private String pets_species;
	private String pets_address;
	private String pets_adopCondition;
	private String pets_describe;
	private String pets_linkman;
	private String pets_lmPhone;
    private Integer sender_id;
    private users adop_sender;
    private Timestamp send_time;
    private  String pets_img;
    private Integer isMoney;
    
    
	public petsAdop(String pets_species, String pets_address, String pets_describe, String pets_img, Integer isMoney) {
		super();
		this.pets_species = pets_species;
		this.pets_address = pets_address;
		this.pets_describe = pets_describe;
		this.pets_img = pets_img;
		this.isMoney = isMoney;
	}

	public Integer getIsMoney() {
		return isMoney;
	}

	public void setIsMoney(Integer isMoney) {
		this.isMoney = isMoney;
	}

	public petsAdop() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public petsAdop(String pets_name,String pets_kind, String pets_species, String pets_address,
			String pets_adopCondition, String pets_describe, String pets_linkman, String pets_lmPhone) {
		super();
		this.pets_name = pets_name;
		this.pets_kind = pets_kind;
		this.pets_species = pets_species;
		this.pets_address = pets_address;
		this.pets_adopCondition = pets_adopCondition;
		this.pets_describe = pets_describe;
		this.pets_linkman = pets_linkman;
		this.pets_lmPhone = pets_lmPhone;
	}

	public Integer getPets_id() {
		return pets_id;
	}

	public void setPets_id(Integer pets_id) {
		this.pets_id = pets_id;
	}

	public String getPets_name() {
		return pets_name;
	}

	public void setPets_name(String pets_name) {
		this.pets_name = pets_name;
	}

	

	public String getPets_kind() {
		return pets_kind;
	}

	public void setPets_kind(String pets_kind) {
		this.pets_kind = pets_kind;
	}

	public String getPets_species() {
		return pets_species;
	}

	public void setPets_species(String pets_species) {
		this.pets_species = pets_species;
	}

	public String getPets_address() {
		return pets_address;
	}

	public void setPets_address(String pets_address) {
		this.pets_address = pets_address;
	}

	public String getPets_adopCondition() {
		return pets_adopCondition;
	}

	public void setPets_adopCondition(String pets_adopCondition) {
		this.pets_adopCondition = pets_adopCondition;
	}

	public String getPets_describe() {
		return pets_describe;
	}

	public void setPets_describe(String pets_describe) {
		this.pets_describe = pets_describe;
	}

	public String getPets_linkman() {
		return pets_linkman;
	}

	public void setPets_linkman(String pets_linkman) {
		this.pets_linkman = pets_linkman;
	}

	public String getPets_lmPhone() {
		return pets_lmPhone;
	}

	public void setPets_lmPhone(String pets_lmPhone) {
		this.pets_lmPhone = pets_lmPhone;
	}

	public Integer getSender_id() {
		return sender_id;
	}

	public void setSender_id(Integer sender_id) {
		this.sender_id = sender_id;
	}

	public users getAdop_sender() {
		return adop_sender;
	}

	public void setAdop_sender(users adop_sender) {
		this.adop_sender = adop_sender;
	}

	public Timestamp getSend_time() {
		return send_time;
	}

	public void setSend_time(Timestamp send_time) {
		this.send_time = send_time;
	}

	public String getPets_img() {
		return pets_img;
	}

	public void setPets_img(String pets_img) {
		this.pets_img = pets_img;
	}

	

	
    
}

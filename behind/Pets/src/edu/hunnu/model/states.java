package edu.hunnu.model;
import java.io.Serializable;
public class states implements Serializable{
	 private static final long serialVersionUID = 1L;
	 private String statesDescribe;
	 private Integer statesId;
	 
	@Override
	public String toString() {
		return "states [statesDescribe=" + statesDescribe + ", statesId="
				+ statesId + "]";
	}
	
	public String getStatesDescribe() {
		return statesDescribe;
	}
	public void setStatesDescribe(String statesDescribe) {
		this.statesDescribe = statesDescribe;
	}
	public Integer getStatesId() {
		return statesId;
	}
	public void setStatesId(Integer statesId) {
		this.statesId = statesId;
	}
}

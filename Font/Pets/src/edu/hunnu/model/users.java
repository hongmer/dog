package edu.hunnu.model;
import java.io.Serializable;
public class users implements Serializable{
	private static final long serialVersionUID = 1L;
	private Integer usersId;
    private String userName;
    private String password;
    private String usersAddress;
    private String usersPhone;
    private Integer usersRolesId;
    private roles roles;
    
    public users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public users(String userName, String password) {
		super();
		this.userName = userName;
		this.password = password;
	}
	

	public users(String userName, String password, String usersAddress, String usersPhone, Integer usersRolesId) {
		super();
		this.userName = userName;
		this.password = password;
		this.usersAddress = usersAddress;
		this.usersPhone = usersPhone;
		this.usersRolesId = usersRolesId;
	}

	public Integer getUsersId() {
		return usersId;
	}

	public void setUsersId(Integer usersId) {
		this.usersId = usersId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsersAddress() {
		return usersAddress;
	}

	public void setUsersAddress(String usersAddress) {
		this.usersAddress = usersAddress;
	}

	public String getUsersPhone() {
		return usersPhone;
	}

	public void setUsersPhone(String usersPhone) {
		this.usersPhone = usersPhone;
	}

	public Integer getUsersRolesId() {
		return usersRolesId;
	}

	public void setUsersRolesId(Integer usersRolesId) {
		this.usersRolesId = usersRolesId;
	}

	public roles getRoles() {
		return roles;
	}

	public void setRoles(roles roles) {
		this.roles = roles;
	}
    

	
	
}

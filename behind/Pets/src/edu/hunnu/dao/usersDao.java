package edu.hunnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.hunnu.model.PageBean;
import edu.hunnu.model.petsAdop;
import edu.hunnu.model.users;
import edu.hunnu.util.DateUtil;
import edu.hunnu.util.StringUtil;

import com.mysql.jdbc.ResultSetMetaData;


public class usersDao {

	/**
	 * µÇÂ¼ÑéÖ¤
	 * @param con
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public users login(Connection con,users user) throws Exception{
		users resultUser=null;
		String name=user.getUserName();
		String password=user.getPassword();
		String sql="select * from users where users_name='"+name+"' and users_password='"+password+"'";
		System.out.println(sql);
		PreparedStatement pstmt=con.prepareStatement(sql);
		//pstmt.setString(1, user.getUserName());
		//pstmt.setString(2, user.getPassword());
//		System.out.println(user.getUserName());
//		System.out.println(user.getPassword());
//		System.out.println(sql);
		ResultSet rs=pstmt.executeQuery();
//		System.out.println(sql);
//		ResultSetMetaData meta= rs.getMetaData();
//		for(int index =1 ; index<=meta.getColumnCount();index++){
//			System.out.println("column"+ index +" is named "+ 
//					meta.getColumnName(index));
//		}
//     	if(rs.isClosed()){
//			System.out.println("......");
//     	}
		if(rs.next()){
			resultUser=new users();
			System.out.println(rs.getString("users_name"));
			resultUser.setUserName(rs.getString("users_name"));
			resultUser.setPassword(rs.getString("users_password"));
		}
		return resultUser;
	}
	
	
	public static  ResultSet usersList(Connection con,PageBean pageBean,users users)throws Exception{
		StringBuffer sb=new StringBuffer("SELECT users_id,users_name,users_address,users_phone,users_role FROM users WHERE 1=1");
		if(StringUtil.isNotEmpty(users.getUserName())){
			sb.append(" and users_name like '%"+users.getUserName()+"%'");
		}
		if(StringUtil.isNotEmpty(users.getUsersAddress())){
			sb.append(" and users_address like '%"+users.getUsersAddress()+"%'");
		}
		if(users.getUsersRolesId()!=-1){
			sb.append(" and users_role ="+users.getUsersRolesId());
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		System.out.println(sb);
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public static int usersCount(Connection con,users users)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total FROM users where 1=1");
		
		if(StringUtil.isNotEmpty(users.getUserName())){
			sb.append(" and users_name like '%"+users.getUserName()+"%'");
		}
		if(StringUtil.isNotEmpty(users.getUsersAddress())){
			sb.append(" and users_address like '%"+users.getUsersAddress()+"%'");
		}
		if(users.getUsersRolesId()!=-1){
			sb.append(" and users_role ="+users.getUsersRolesId());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	public  int usersDelete(Connection con,String delIds)throws Exception{
		String sql="delete from users where users_id in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public static int usersAdd(Connection con,users users)throws Exception{
		String sql="insert into users values(null,?,?,?,?,?,null)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, users.getUserName());
		pstmt.setString(2, users.getPassword());
		pstmt.setString(3, users.getUsersAddress());
		pstmt.setString(4, users.getUsersPhone());
		pstmt.setInt(5, users.getUsersRolesId());
		return pstmt.executeUpdate();
	}
	
	public static int usersModify(Connection con,users users)throws Exception{
		String sql="update users set u.users_id=?,u.users_name=?,u.users_address=?,u.users_phone=?,r.roles_name=? where users_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, users.getUserName());
		pstmt.setString(2, users.getPassword());
		pstmt.setString(3, users.getUsersAddress());
		pstmt.setString(4, users.getUsersPhone());
		pstmt.setInt(5, users.getUsersRolesId());
		pstmt.setInt(6, users.getUsersId());
		return pstmt.executeUpdate();
	}
	
	public boolean getUsersByRoleId(Connection con,int SenderId)throws Exception{
		String sql="select * from users where users_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setInt(1, SenderId);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}
}

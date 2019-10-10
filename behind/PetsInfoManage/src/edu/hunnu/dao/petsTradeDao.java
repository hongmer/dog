package edu.hunnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.hunnu.model.PageBean;
import edu.hunnu.model.users;
import edu.hunnu.util.StringUtil;

public class petsTradeDao {
	public static  ResultSet petsTradeList(Connection con,PageBean pageBean,users users)throws Exception{
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
		System.out.println(delIds);
		String sql="delete from users where users_id in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		System.out.println(sql);
		System.out.println(pstmt);
		return pstmt.executeUpdate();
	}
	
	public static int usersAdd(Connection con,users users)throws Exception{
		String sql="insert into users values(null,?,?,?,?,?,null)";
		PreparedStatement pstmt=con.prepareStatement(sql);
//		System.out.println(users.getUserName());
//		System.out.println(users.getPassword());
//		System.out.println(users.getUsersAddress());
//		System.out.println(users.getUsersPhone());
		pstmt.setString(1, users.getUserName());
		pstmt.setString(2, users.getPassword());
		pstmt.setString(3, users.getUsersAddress());
		pstmt.setString(4, users.getUsersPhone());
		pstmt.setInt(5, users.getUsersRolesId());
		return pstmt.executeUpdate();
	}
	
	public static int usersModify(Connection con,users users)throws Exception{
		String sql="update users set users_name=?,users_password=?,users_address=?,users_phone=?,users_roles=? where users_id=?";
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

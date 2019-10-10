package edu.hunnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.hunnu.model.PageBean;
import edu.hunnu.model.petsSave;
import edu.hunnu.util.DateUtil;
import edu.hunnu.util.StringUtil;

public class petsSaveDao {

	public static ResultSet petsSaveList(Connection con,petsSave petsSave)throws Exception{
		StringBuffer sb=new StringBuffer("select save_id,save_linkman,save_lmPhone,save_address,save_describe,save_img,users_name from pets_save join users where usersId=senderId");
		
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public int petsSaveCount(Connection con,petsSave petsSave,String btime,String etime)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from pets_save  where 1=1");
		
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	
	public int petsSaveAdd(Connection con,petsSave petsSave)throws Exception{
		String sql="insert into pets_save values(null,null,null,?,?,?,null,null,null,null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, petsSave.getSave_species());
		pstmt.setString(2, petsSave.getSaveAddress());
		pstmt.setString(3, petsSave.getSaveDescribe());
		pstmt.setString(4, petsSave.getSave_img());
		return pstmt.executeUpdate();
	}
	
	
}


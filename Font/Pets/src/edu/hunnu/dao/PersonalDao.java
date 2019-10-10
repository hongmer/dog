package edu.hunnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.hunnu.model.petsAdop;
import edu.hunnu.model.users;
import edu.hunnu.util.StringUtil;

public class PersonalDao { 
	
	public static ResultSet PersonalList(Connection con,petsAdop petsAdop)throws Exception{
		StringBuffer sb=new StringBuffer("Select  pets_id,pets_name,pets_species,pets_address,pets_adopCondition,pets_describe,pets_linkman,pets_lmPhone from pets_adop join user where sender_id=usersId");
		
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public static int PersonalCount(Connection con,petsAdop petsAdop)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from pets_adop join pets_save where 1=1");
		
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	
}

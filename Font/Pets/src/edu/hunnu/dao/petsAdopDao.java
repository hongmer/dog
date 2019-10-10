package edu.hunnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.hunnu.model.PageBean;
import edu.hunnu.model.petsAdop;
import edu.hunnu.util.DateUtil;
import edu.hunnu.util.StringUtil;

public class petsAdopDao {

	public ResultSet petsAdopList(Connection con,petsAdop petsAdop)throws Exception{
		StringBuffer sb=new StringBuffer("select pets_id,pets_name,pets_species,pets_address,pets_adopCondition,pets_describe,pets_linkman,pets_lmPhone from pets_adop join user where sender_id=usersId");
		if(StringUtil.isNotEmpty(petsAdop.getPets_species())){
			sb.append(" and pets_species like '%"+petsAdop.getPets_species()+"%'");
		}
		
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public int petsAdopCount(Connection con,petsAdop petsAdop)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from pets_adop  where 1=1");
		
		if(StringUtil.isNotEmpty(petsAdop.getPets_species())){
			sb.append(" and pets_species like '%"+petsAdop.getPets_species()+"%'");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	
	public int petsAdopAdd(Connection con,petsAdop petsAdop)throws Exception{
		String sql="insert into pets_adop values(null,null,null,?,null,?,null,?,null,null,null,null,null,?,?)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, petsAdop.getPets_species());
		pstmt.setString(2, petsAdop.getPets_address());
		pstmt.setString(3, petsAdop.getPets_describe());
		pstmt.setString(4, petsAdop.getPets_img());
		pstmt.setInt(5, petsAdop.getIsMoney());
		return pstmt.executeUpdate();
	}
	
	
}


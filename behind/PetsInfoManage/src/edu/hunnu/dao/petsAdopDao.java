package edu.hunnu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.hunnu.model.PageBean;
import edu.hunnu.model.petsAdop;
import edu.hunnu.util.DateUtil;
import edu.hunnu.util.StringUtil;

public class petsAdopDao {

	public ResultSet petsAdopList(Connection con,PageBean pageBean,petsAdop petsAdop,String btime,String etime)throws Exception{
		StringBuffer sb=new StringBuffer("select pets_id,pets_name,pets_species,pets_address,pets_adopCondition,pets_describe,pets_linkman,pets_lmPhone from pets_adop where 1=1");
		if(StringUtil.isNotEmpty(petsAdop.getPets_name())){
			sb.append(" and pets_name like '%"+petsAdop.getPets_name()+"%'");
		}
		if(StringUtil.isNotEmpty(petsAdop.getPets_kind())){
			sb.append(" and pets_kind like '%"+petsAdop.getPets_kind()+"%'");
		}
		if(StringUtil.isNotEmpty(petsAdop.getPets_address())){
			sb.append(" and pets_address like '%"+petsAdop.getPets_address()+"%'");
		}
		if(StringUtil.isNotEmpty(btime)){
			sb.append(" and TO_DAYS(send_time)>=TO_DAYS('"+btime+"')");
		}
		if(StringUtil.isNotEmpty(etime)){
			sb.append(" and TO_DAYS(send_time)<=TO_DAYS('"+etime+"')");
		}
		if(pageBean!=null){
			sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		return pstmt.executeQuery();
	}
	
	public int petsAdopCount(Connection con,petsAdop petsAdop,String btime,String etime)throws Exception{
		StringBuffer sb=new StringBuffer("select count(*) as total from pets_adop p,users u  where p.sender_id =u.users_id");
		
		if(StringUtil.isNotEmpty(petsAdop.getPets_name())){
			sb.append(" and pets_name like '%"+petsAdop.getPets_name()+"%'");
		}
		if(StringUtil.isNotEmpty(petsAdop.getPets_kind())){
			sb.append(" and pets_kind like '%"+petsAdop.getPets_kind()+"%'");
		}
		if(StringUtil.isNotEmpty(petsAdop.getPets_address())){
			sb.append(" and pets_address like '%"+petsAdop.getPets_address()+"%'");
		}
		if(StringUtil.isNotEmpty(btime)){
			sb.append(" and TO_DAYS(send_time)>=TO_DAYS('"+btime+"')");
		}
		if(StringUtil.isNotEmpty(etime)){
			sb.append(" and TO_DAYS(send_time)<=TO_DAYS('"+etime+"')");
		}
		PreparedStatement pstmt=con.prepareStatement(sb.toString());
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return rs.getInt("total");
		}else{
			return 0;
		}
	}
	
	public int petsAdopDelete(Connection con,String delIds)throws Exception{
		String sql="delete from pets_adop where pets_id in("+delIds+")";
		PreparedStatement pstmt=con.prepareStatement(sql);
		return pstmt.executeUpdate();
	}
	
	public int petsAdopAdd(Connection con,petsAdop petsAdop)throws Exception{
		String sql="insert into pets_adop values(null,?,?,?,?,?,?,?,null,?,null,?,null,null)";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, petsAdop.getPets_name());
		pstmt.setString(2, petsAdop.getPets_kind());
		pstmt.setString(2, petsAdop.getPets_species());
		pstmt.setString(3, petsAdop.getPets_address());
		pstmt.setString(4, petsAdop.getPets_adopCondition());
		pstmt.setString(5, petsAdop.getPets_describe());
		pstmt.setString(6, petsAdop.getPets_linkman());
		pstmt.setString(7, petsAdop.getPets_lmPhone());
		pstmt.setString(8, DateUtil.formatDate(petsAdop.getSend_time(), "yyyy-MM-dd"));
		System.out.println(pstmt);
		return pstmt.executeUpdate();
	}
	
	public int petsAdopModify(Connection con,petsAdop petsAdop)throws Exception{
		String sql="update pets_adop set pets_name=?,pets_kind=?,pets_species=?,pets_address=?,pets_adopCondition=?,pets_describe=?,pets_linkman=?,pets_lmPhone=? where pets_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, petsAdop.getPets_name());
		pstmt.setString(2, petsAdop.getPets_kind());
		pstmt.setString(2, petsAdop.getPets_species());
		pstmt.setString(3, petsAdop.getPets_address());
		pstmt.setString(4, petsAdop.getPets_adopCondition());
		pstmt.setString(5, petsAdop.getPets_describe());
		pstmt.setString(6, petsAdop.getPets_linkman());
		pstmt.setString(7, petsAdop.getPets_lmPhone());
		pstmt.setString(8, DateUtil.formatDate(petsAdop.getSend_time(), "yyyy-MM-dd"));
		pstmt.setInt(9, petsAdop.getPets_id());
		return pstmt.executeUpdate();
	}
	
	public boolean getpetsAdopBySenderId(Connection con,String sender_id)throws Exception{
		String sql="select * from petsAdop where sender_id=?";
		PreparedStatement pstmt=con.prepareStatement(sql);
		pstmt.setString(1, sender_id);
		ResultSet rs=pstmt.executeQuery();
		if(rs.next()){
			return true;
		}else{
			return false;
		}
	}
}


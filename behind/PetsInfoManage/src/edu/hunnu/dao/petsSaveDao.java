package edu.hunnu.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import edu.hunnu.model.PageBean;
import edu.hunnu.model.petsSave;
import edu.hunnu.util.DateUtil;
import edu.hunnu.util.StringUtil;

public class petsSaveDao {

		public ResultSet petsSaveList(Connection con,PageBean pageBean,petsSave petsSave,String btime,String etime)throws Exception{
			StringBuffer sb=new StringBuffer("select save_id,save_linkman,save_lmPhone,save_address,save_describe from pets_save where 1=1");

			if(StringUtil.isNotEmpty(petsSave.getSaveAddress())){
				sb.append(" and save_address like '%"+petsSave.getSaveAddress()+"%'");
			}
			if(StringUtil.isNotEmpty(btime)){
				sb.append(" and TO_DAYS(save_time)>=TO_DAYS('"+btime+"')");
			}
			if(StringUtil.isNotEmpty(etime)){
				sb.append(" and TO_DAYS(save_time)<=TO_DAYS('"+etime+"')");
			}
			if(pageBean!=null){
				sb.append(" limit "+pageBean.getStart()+","+pageBean.getRows());
			}
			PreparedStatement pstmt=con.prepareStatement(sb.toString());
			return pstmt.executeQuery();
		}
		
		public int petsSaveCount(Connection con,petsSave petsSave,String btime,String etime)throws Exception{
			StringBuffer sb=new StringBuffer("select count(*) as total from pets_save where 1=1");
			
			if(StringUtil.isNotEmpty(petsSave.getSaveAddress())){
				sb.append(" and save_address like '%"+petsSave.getSaveAddress()+"%'");
			}
			if(StringUtil.isNotEmpty(btime)){
				sb.append(" and TO_DAYS(save_time)>=TO_DAYS('"+btime+"')");
			}
			if(StringUtil.isNotEmpty(etime)){
				sb.append(" and TO_DAYS(save_time)<=TO_DAYS('"+etime+"')");
			}
			PreparedStatement pstmt=con.prepareStatement(sb.toString());
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()){
				return rs.getInt("total");
			}else{
				return 0;
			}
		}
		
		public int petsSaveDelete(Connection con,String delIds)throws Exception{
			String sql="delete from pets_save where save_id in("+delIds+")";
			PreparedStatement pstmt=con.prepareStatement(sql);
			return pstmt.executeUpdate();
		}
		
		public int petsSaveAdd(Connection con,petsSave petsSave)throws Exception{
			String sql="insert into pets_save values(null,?,?,?,?,null,null,null,?,null,null)";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, petsSave.getSaveLinkman());
			pstmt.setString(2, petsSave.getSaveLmPhone());
			pstmt.setString(3, petsSave.getSaveAddress());
			pstmt.setString(4, petsSave.getSaveDescribe());
			pstmt.setString(5, DateUtil.formatDate(petsSave.getSaveTime(), "yyyy-MM-dd"));
			System.out.println(pstmt);
			return pstmt.executeUpdate();
		}
		
		public int petsSaveModify(Connection con,petsSave petsSave)throws Exception{
			String sql="update pets_save set save_linkman=?,save_lmPhone=?,save_address=?,save_describe=?,save_time=? where save_id=?";
			PreparedStatement pstmt=con.prepareStatement(sql);
			pstmt.setString(1, petsSave.getSaveLinkman());
			pstmt.setString(2, petsSave.getSaveLmPhone());
			pstmt.setString(3, petsSave.getSaveAddress());
			pstmt.setString(4, petsSave.getSaveDescribe());
			pstmt.setString(5, DateUtil.formatDate(petsSave.getSaveTime(), "yyyy-MM-dd"));
			pstmt.setInt(6, petsSave.getSaveId());
			return pstmt.executeUpdate();
		}
		
		public boolean getpetsSaveBySenderId(Connection con,String sender_id)throws Exception{
			String sql="select * from petsSave where sender_id=?";
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


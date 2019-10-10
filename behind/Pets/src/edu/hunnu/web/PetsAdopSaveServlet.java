package edu.hunnu.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hunnu.dao.petsAdopDao;
import edu.hunnu.model.petsAdop;
import edu.hunnu.util.DbUtil;
import edu.hunnu.util.ResponseUtil;
import edu.hunnu.util.StringUtil;
import net.sf.json.JSONObject;

public class PetsAdopSaveServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	petsAdopDao petsAdopDao=new petsAdopDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String pets_id=request.getParameter("pets_id");
		String pets_kind=request.getParameter("pets_kind");
		String pets_name=request.getParameter("pets_name");
		String pets_species=request.getParameter("pets_species");
		String pets_address=request.getParameter("pets_address");
		String pets_adopCondition=request.getParameter("pets_adopCondition");
		String pets_describe=request.getParameter("pets_describe");
		String pets_linkman=request.getParameter("pets_linkman");
		String pets_lmPhone=request.getParameter("pets_lmPhone");
		String sender_id=request.getParameter("sender_id");
		String send_time=request.getParameter("send_time");
		
		petsAdop petsAdop=null;
		try {
			petsAdop = new petsAdop(pets_name,pets_kind,  pets_species, pets_address,
					 pets_adopCondition, pets_describe, pets_linkman, pets_lmPhone);
		}  catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(StringUtil.isNotEmpty(pets_id)){
			petsAdop.setPets_id(Integer.parseInt(pets_id));
		}
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int saveNums=0;
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(pets_id)){
				saveNums=petsAdopDao.petsAdopModify(con, petsAdop);
			}else{
				saveNums=petsAdopDao.petsAdopAdd(con, petsAdop);
			}
			if(saveNums>0){
				result.put("success", "true");
			}else{
				result.put("success", "true");
				result.put("errorMsg", "±£¥Ê ß∞‹");
			}
			ResponseUtil.write(response, result);
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				dbUtil.closeCon(con);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
	
}


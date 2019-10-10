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
		String pets_img=request.getParameter("pets_img");
		String isMoney=request.getParameter("isMoney");
		
		petsAdop petsAdop=null;
		try {
			petsAdop = new petsAdop(pets_name,pets_kind,  pets_species, pets_address,
					 pets_adopCondition, pets_describe, pets_img, isMoney);
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
				saveNums=petsAdopDao.petsAdopAdd(con, petsAdop);
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


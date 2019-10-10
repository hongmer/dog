package edu.hunnu.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hunnu.dao.PersonalDao;
import edu.hunnu.dao.petsAdopDao;
import edu.hunnu.model.petsAdop;
import edu.hunnu.util.DbUtil;
import edu.hunnu.util.JsonUtil;
import edu.hunnu.util.ResponseUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PersonalAdoptSaveListServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	PersonalDao personalDao=new PersonalDao();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pets_name=request.getParameter("pets_name");
		String pets_kind=request.getParameter("pets_kind");
		String pets_address=request.getParameter("pets_address");
		petsAdop petsAdop=new petsAdop();
		
			petsAdop.setPets_name(pets_name);
			petsAdop.setPets_kind(pets_kind);
			petsAdop.setPets_address(pets_address);
		
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(PersonalDao.PersonalList(con, petsAdop));
			int total=PersonalDao.PersonalCount(con,petsAdop);
			result.put("rows", jsonArray);
			result.put("total", total);
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
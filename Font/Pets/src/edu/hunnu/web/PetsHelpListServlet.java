package edu.hunnu.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hunnu.dao.petsSaveDao;
import edu.hunnu.model.PageBean;
import edu.hunnu.model.petsSave;
import edu.hunnu.util.DbUtil;
import edu.hunnu.util.JsonUtil;
import edu.hunnu.util.ResponseUtil;
import edu.hunnu.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PetsHelpListServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	petsSaveDao petsAdopDao=new petsSaveDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String pets_kind=request.getParameter("pets_kind");
		String pets_address=request.getParameter("pets_address");
		petsSave petsSave=new petsSave();
		
			petsSave.setSave_species(pets_kind);
			petsSave.setSaveAddress(pets_address);
		
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(petsSaveDao.petsSaveList(con, petsSave));
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


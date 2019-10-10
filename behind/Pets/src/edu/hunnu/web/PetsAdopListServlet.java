package edu.hunnu.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hunnu.dao.petsAdopDao;
import edu.hunnu.model.PageBean;
import edu.hunnu.model.petsAdop;
import edu.hunnu.util.DbUtil;
import edu.hunnu.util.JsonUtil;
import edu.hunnu.util.ResponseUtil;
import edu.hunnu.util.StringUtil;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class PetsAdopListServlet extends HttpServlet{
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
		String pets_name=request.getParameter("pets_name");
		String pets_kind=request.getParameter("pets_kind");
		String pets_address=request.getParameter("pets_address");
		String sender_id=request.getParameter("sender_id");
		String btime=request.getParameter("btime");
		String etime=request.getParameter("etime");
		petsAdop petsAdop=new petsAdop();
		
			petsAdop.setPets_name(pets_name);
			petsAdop.setPets_kind(pets_kind);
			petsAdop.setPets_address(pets_address);
			if(StringUtil.isNotEmpty(sender_id)){
				petsAdop.setSender_id(Integer.parseInt(sender_id));
			}
		
		
		Connection con=null;
		try{
			con=dbUtil.getCon();
			JSONObject result=new JSONObject();
			JSONArray jsonArray=JsonUtil.formatRsToJsonArray(petsAdopDao.petsAdopList(con, pageBean,petsAdop,btime,etime));
			int total=petsAdopDao.petsAdopCount(con,petsAdop,btime,etime);
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


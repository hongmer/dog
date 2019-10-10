package edu.hunnu.web;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Timestamp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.hunnu.dao.petsSaveDao;
import edu.hunnu.model.petsSave;
import edu.hunnu.util.DbUtil;
import edu.hunnu.util.ResponseUtil;
import edu.hunnu.util.StringUtil;
import net.sf.json.JSONObject;

public class PetsSaveSaveServlet extends HttpServlet{
	DbUtil dbUtil=new DbUtil();
	petsSaveDao petsSaveDao=new petsSaveDao();
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String save_id=request.getParameter("save_id");
		String save_linkman=request.getParameter("save_linkman");
		String save_lmPhone=request.getParameter("save_lmPhone");
		String save_address=request.getParameter("save_address");
		String save_describe=request.getParameter("save_describe");
		String save_time=request.getParameter("save_time");
		
		petsSave petsSave=null;
		try {
			petsSave = new petsSave(save_linkman, save_lmPhone,save_address,save_describe,
					Timestamp.valueOf(save_time));
		}catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if(StringUtil.isNotEmpty(save_id)){
			petsSave.setSaveId(Integer.parseInt(save_id));
		}
		Connection con=null;
		try{
			con=dbUtil.getCon();
			int saveNums=0;
			JSONObject result=new JSONObject();
			if(StringUtil.isNotEmpty(save_id)){
				saveNums=petsSaveDao.petsSaveModify(con, petsSave);
			}else{
				saveNums=petsSaveDao.petsSaveAdd(con, petsSave);
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



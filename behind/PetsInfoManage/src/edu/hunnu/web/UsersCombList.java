package edu.hunnu.web;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import edu.hunnu.dao.usersDao;
import edu.hunnu.model.users;
import edu.hunnu.model.PageBean;
import edu.hunnu.util.DbUtil;
import edu.hunnu.util.JsonUtil;
import edu.hunnu.util.ResponseUtil;

	public class UsersCombList extends HttpServlet{
		DbUtil dbUtil=new DbUtil();
		usersDao usersDao=new usersDao();
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			this.doPost(request, response);
		}

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			Connection con=null;
			try{
				con=dbUtil.getCon();
				JSONArray jsonArray=new JSONArray();
				JSONObject jsonObject=new JSONObject();
				jsonObject.put("usersId", "");
				jsonObject.put("userName", "«Î—°‘Ò...");
				jsonArray.add(jsonObject);
				jsonArray.addAll(JsonUtil.formatRsToJsonArray(usersDao.usersList(con, null,null)));
				ResponseUtil.write(response, jsonArray);
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

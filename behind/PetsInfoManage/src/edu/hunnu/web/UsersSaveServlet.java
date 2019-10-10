	package edu.hunnu.web;

	import java.io.IOException;
	import java.sql.Connection;
	import java.util.Date;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import net.sf.json.JSONArray;
	import net.sf.json.JSONObject;

	import edu.hunnu.dao.usersDao;
	import edu.hunnu.model.users;
	import edu.hunnu.model.PageBean;
	import edu.hunnu.util.DateUtil;
	import edu.hunnu.util.DbUtil;
	import edu.hunnu.util.JsonUtil;
	import edu.hunnu.util.ResponseUtil;
	import edu.hunnu.util.StringUtil;

	public class UsersSaveServlet extends HttpServlet{
		DbUtil dbUtil=new DbUtil();
		usersDao users=new usersDao();
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			this.doPost(request, response);
		}

		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			String users_name=request.getParameter("users_name");
			String users_password=request.getParameter("users_password");
			String users_address=request.getParameter("users_address");
			String users_phone=request.getParameter("users_phone");
			String users_role=request.getParameter("users_role");
			String users_id=request.getParameter("users_id");
			users users=null;
			try {
				users = new users(users_name,users_password,users_address,
						users_phone,Integer .parseInt(users_role));
			}  catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(StringUtil.isNotEmpty(users_id)){
				users.setUsersId(Integer.parseInt(users_id));
			}
			
			Connection con=null;
			try{
				con=dbUtil.getCon();
				int saveNums=0;
				JSONObject result=new JSONObject();
				if(StringUtil.isNotEmpty(users_id)){
					saveNums=usersDao.usersModify(con, users);
				}else{
					saveNums=usersDao.usersAdd(con, users);
				}
				if(saveNums>0){
					result.put("success", "true");
				}else{
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


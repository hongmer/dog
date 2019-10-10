	package edu.hunnu.web;

	import java.io.IOException;
	import java.sql.Connection;
	import java.sql.Timestamp;

	import javax.servlet.ServletException;
	import javax.servlet.http.HttpServlet;
	import javax.servlet.http.HttpServletRequest;
	import javax.servlet.http.HttpServletResponse;

	import net.sf.json.JSONArray;
	import net.sf.json.JSONObject;

    import edu.hunnu.dao.usersDao;
	import edu.hunnu.model.PageBean;
	import edu.hunnu.model.users;
	import edu.hunnu.util.DbUtil;
	import edu.hunnu.util.JsonUtil;
	import edu.hunnu.util.ResponseUtil;
	import edu.hunnu.util.StringUtil;

	public class UsersListServlet extends HttpServlet{
		DbUtil dbUtil=new DbUtil();
		users users=new users();
		
		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			this.doPost(request, response);
		}
		
		@Override
		protected void doPost(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			String users_name=request.getParameter("users_name");
			String users_address=request.getParameter("users_address");
			String users_role=request.getParameter("users_role");
			System.out.println(users_name);
			System.out.println(users_address);
			System.out.println(users_role);
			users users=new users();
				users.setUserName(users_name);
				users.setUsersAddress(users_address);
				if(StringUtil.isNotEmpty(users_role)){
					users.setUsersRolesId(Integer.parseInt(users_role));
				}
			System.out.println(users.getUserName());
			System.out.println(users.getUsersAddress());
			System.out.println(users.getUsersId());
		    String page=request.getParameter("page");
		    String rows=request.getParameter("rows");
		
			PageBean pageBean=new PageBean(Integer.parseInt(page),Integer.parseInt(rows));
			Connection con=null;
			try{
				con=dbUtil.getCon();
				JSONObject result=new JSONObject();
				JSONArray jsonArray=JsonUtil.formatRsToJsonArray(usersDao.usersList(con,pageBean,users));
				int total=usersDao.usersCount(con,users);
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



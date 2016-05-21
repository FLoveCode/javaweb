package k.service.main;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import k.dao.DBO;

import java.io.*;
/**
 * Servlet implementation class DoLogin
 */
@WebServlet("/DoLogin")
public class DoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//客户端获取数据
		response.setContentType("text/html;charset=utf-8");
		String username = request.getParameter("username");//账号
		String password = request.getParameter("password");//密码
		String choose = request.getParameter("identity");//选择身份登录
		System.out.println(username);
		System.out.println(password);
		System.out.println(choose);
		int n = 0 ;//用于判断是否存在该用户
		String[] params = new String[]{username,password};
		HttpSession session = request.getSession();//存储账号密码
		
		PrintWriter out = response.getWriter();
		//对数据进行数据库查询
		DBO db = new DBO();
		ResultSet rs = null;
		String sql = null ;
		
		JSONObject json = new JSONObject();
		JSONObject js= new JSONObject();
		Boolean status = false;
		String detail = null;
		
		try {
			Connection conn = db.getConn();
			if(conn!=null)
				System.out.println("conn sucess!");
			if(choose.equals("1")){//顾客
				sql = new String("SELECT * FROM customer WHERE cusname=? AND cuspassword=?"); 
			}else if(choose.equals("2")){//商家
				sql = new String("SELECT * FROM merchant WHERE mername=? AND merpassword=?");
			}else if(choose.equals("3")){//管理员
				session.setAttribute("username", username);
				session.setAttribute("password", password);
			}else{
				System.out.println("请选择身份登录！");
				detail = new String("请选择身份登录！");
			}
			//对查询结果进行判断
			rs = db.executeQuery(sql, params);
			if (!rs.next()) {
				System.out.println("账号错误或密码错误！");
				detail = new String("账号错误或密码错误！");

			}else{
				if(rs.getBoolean(7)==false){
					out.println("该用户还未通过审核！");
					status = false;
					detail = new String("该用户还未通过审核！");
				}else{
					status = true;
					detail = new String("登陆成功！");
//					out.println("id:"+rs.getInt(1));
//					out.println("username:"+rs.getString(2));
//					out.println("password:"+rs.getString(3));
//					out.println(rs.getBoolean(7));
					session.setAttribute("id", rs.getInt(1));
					session.setAttribute("username", username);
					session.setAttribute("password", password);
					js.put("id", rs.getInt(1));
					js.put("username", rs.getString(2));
				}
			}
			
			json.put("status", status);
			json.put("detail", detail);
			json.put("message", js);
			System.out.println(json.toString());
			out.println(json.toString());
			db.closeAll();
//			if(choose.equals("1")){
//				response.sendRedirect("main.jsp");
//			}else if(choose.equals("2")){
//				response.sendRedirect("merchant.jsp");
//			}else if(choose.equals("3")){
//				response.sendRedirect("root.jsp");
//			}else{
//				response.sendRedirect("main.jsp");
//			}
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException |JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}

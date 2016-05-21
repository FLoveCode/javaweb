package k.service.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
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
/**
 * Servlet implementation class DoCusRegister
 */
@WebServlet("/DoCusRegister")
public class DoCusRegister extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DoCusRegister() {
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
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String cusname=request.getParameter("cusname");//"hzk"
		String cuspassword=request.getParameter("cuspassword");//="123456";
		String cussex=request.getParameter("cussex");//"1";
		String cusyear=null;//request.getParameter("cusyear");
		String custele=request.getParameter("custele");//"18898874867";
		String[] params = new String[]{cusname,cuspassword,cussex,cusyear,custele};
		
		DBO db = new DBO();
		String sql = null ;
		int n=0;//判断是否插入成功;
		JSONObject json = new JSONObject();
		JSONObject js= new JSONObject();
		Boolean Status = false;
		String detail = null;
		try {
			Connection conn = db.getConn();
			if(conn!=null)
				System.out.println("conn sucess!");
			
			sql = new String("INSERT INTO customer (cusname,cuspassword,cussex,cusyear,custele) values(?,?,?,?,?)");
			
			n = db.executeUpdate(sql, params);
			if(n==0){
				System.out.println("该用户已存在！");
				detail = new String("该用户已存在！");
			}else{
				System.out.println("注册成功！");
				Status = true;
				detail = new String("注册成功！");
			}
			json.put("Status", Status);
			json.put("detail", detail);
			json.put("message", js);
			out.println(json.toString());
			db.closeAll();
			
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException | JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

}

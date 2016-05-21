package k.service.customer;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;

import k.dao.DBO;

/**
 * Servlet implementation class CusAlter
 */
@WebServlet("/CusAlter")
public class CusAlter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CusAlter() {
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
		HttpSession session = request.getSession();//获取账号密码
		//String cusname=request.getParameter("username");
		String cusname = (String) session.getAttribute("username");
		System.out.println(cusname);
		String cuspassword=request.getParameter("password");
		System.out.println(cuspassword);
		String cussex=request.getParameter("sex");
		String cusyear=request.getParameter("year");
		String custele=request.getParameter("tele");
		String[] params = new String[]{cuspassword,cussex,cusyear,custele,cusname};
		
		DBO db = new DBO();
		String sql = null ;
		int n=0;//判断是否修改成功;
		
		JSONObject json = new JSONObject();
		JSONObject js= new JSONObject();
		Boolean status = false;
		String detail = null;
		try {
			Connection conn = (Connection) db.getConn();
			if(conn!=null)
				System.out.println("conn sucess!");
			
			sql = new String("UPDATE customer SET cuspassword=?,cussex=?,cusyear=?,custele=? WHERE cusname=?");
			
			n = db.executeUpdate(sql, params);
			if(n==0){
				System.out.println("修改失败！");
				detail = new String("进行修改失败！");
			}else{
				System.out.println("修改成功！");
				status = true;
				detail = new String("修改成功！");
				session.setAttribute("username", cusname);
				session.setAttribute("password", cuspassword);
			}
			json.put("status", status);
			json.put("detail", detail);
			json.put("message", js);
			out.println(json.toString());
			db.closeAll();
			
		}catch (ClassNotFoundException | InstantiationException|IllegalAccessException | SQLException | JSONException e) {
			 			// TODO Auto-generated catch block
			 			e.printStackTrace();	
		}
	}

}

package k.service.indent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;

import k.dao.DBO;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class Payment
 */
@WebServlet("/Payment")
public class Payment extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Payment() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
//		String cusid = (String) session.getAttribute("id");
//		String comid = (String) request.getParameter("comid");
		String cusid = "1";
		String comid = "3";
		
		String[] params = new String[]{cusid,comid}; 
		
		DBO db = new DBO();
		ResultSet rs = null;
		String sql = null;
		int n = 0;
		
		JSONObject json = new JSONObject();
		JSONObject js= new JSONObject();
		Boolean status = false;
		String detail = null;
		try{
			Connection conn = (Connection) db.getConn();
			if(conn!=null)
				System.out.println("conn sucess!");
			
			sql = new String("UPDATE indent SET isPay=true WHERE cusid=? AND comid=?");
			
			n=db.executeUpdate(sql, params);
			if(n!=0){
				System.out.println("支付成功！");
				status = true;
				detail = new String("支付成功！");
			}else{
				detail = new String("支付失败！");
			}
			json.put("status", status);
			json.put("detail", detail);
			json.put("message", js);
			out.println(json.toString());
			db.closeAll();
		}catch(ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException | JSONException e){
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

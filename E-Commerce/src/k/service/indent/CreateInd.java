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

import com.mysql.jdbc.Connection;

import k.dao.DBO;

/**
 * Servlet implementation class CreateInd
 */
@WebServlet("/CreateInd")
public class CreateInd extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateInd() {
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
		Date currDate = (Date) Calendar.getInstance().getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = sdf.format(currDate);
//		int count =new Integer(request.getParameter("count"));
//		float comprice =new Float(request.getParameter("comprice"));
//		float pc = comprice*count;
		float pc = 100;
		String purchase = new String(""+pc);
		System.out.print(purchase);
		String[] params = new String[]{cusid,comid,dateTime,purchase}; 
		
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
			
			sql = new String("INSERT INTO indent(cusid,comid,intime,purchase) values(?,?,?,?)");
			
			n=db.executeUpdate(sql, params);
			if(n==0){
				System.out.println("订单创建失败！");
				detail = new String("订单创建失败！");
			}else{
				System.out.println("订单创建成功！");
				status = true;
				detail = new String("订单创建成功！");
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

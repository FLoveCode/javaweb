package k.service.indent;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import k.dao.DBO;

/**
 * Servlet implementation class IndShow
 */
@WebServlet("/IndShow")
public class IndShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IndShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String cusid = "5"; //session.getAttribute("id");
		String[] params = new String[]{cusid};
		
		DBO db = new DBO();
		ResultSet rs = null;
		String sql = null;
		
		JSONObject json = new JSONObject();
		JSONArray js = new JSONArray();
		Boolean status = false;
		String detail = null;
		try{
			Connection conn = null;
			conn = db.getConn();
			if(conn!=null){
				System.out.println("连接成功!");
			}
			sql = new String("SELECT * FROM indent WHERE cusid=? AND isPay='true'");
			rs=db.executeQuery(sql, params);
			if(!rs.next()){
				System.out.println("无订单！");
				detail = new String("无订单！");
			}
			else{
				
				status = true;
				detail = new String("订单查看成功");
				rs=db.executeQuery(sql, params);
				while(rs.next()){
//					out.println("商品编号："+rs.getInt(1));
//					out.println("顾客编号："+rs.getInt(2));
//					out.println("创建时间："+rs.getDate(3).toString());
//					out.println("总额："+rs.getFloat(4));
					
					JSONObject temp = new JSONObject();
					temp.put("comid", rs.getInt(1));
					temp.put("cusid", rs.getInt(2));
					temp.put("time", rs.getDate(3).toString());
					temp.put("purchase", rs.getFloat(4));
					js.put(temp);
				}
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

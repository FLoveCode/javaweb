package k.service.merchant;

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

import k.dao.DBO;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Servlet implementation class MerSelf
 */
@WebServlet("/MerSelf")
public class MerSelf extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MerSelf() {
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
		String mername = "hzk";//request.getParameter("mername");
		String merpassword= "123456";//request.getParameter("merpassword");
		String[] params = new String[]{mername,merpassword};
		
		DBO db = new DBO();
		String sql = null;
		ResultSet rs = null;
		
		JSONObject json = new JSONObject();
		JSONObject js= new JSONObject();
		Boolean status = false;
		String detail = null;
		try{
			Connection conn = null;
			conn = db.getConn();
			if(conn==null){
				System.out.println("连接失败！");
			}
			sql = new String("SELECT * FROM merchant WHERE mername=? AND merpassword=?");
			rs = db.executeQuery(sql, params);
			if(!rs.next()){
				System.out.println("查询失败！");
				detail = new String("查询失败！");
			}else{
				System.out.println("查询成功！");
				status = true;
				detail = new String("查询成功！");
				js.put("mername", rs.getInt(1));
				js.put("merpassword", rs.getString(2));
				js.put("mersex", rs.getString(3));
				js.put("meryear", rs.getString(4));
				js.put("mertele", rs.getString(5));
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

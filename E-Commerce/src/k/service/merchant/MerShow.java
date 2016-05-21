package k.service.merchant;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.mysql.jdbc.Connection;

import k.dao.DBO;

/**
 * Servlet implementation class MerShow
 */
@WebServlet("/MerShow")
public class MerShow extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MerShow() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		String[] params = new String[]{};
		PrintWriter out = response.getWriter();
		//对数据进行数据库查询
		DBO db = new DBO();
		ResultSet rs = null;
		String sql = null ;
		
		JSONObject json = new JSONObject();
		JSONArray js= new JSONArray();
		Boolean status = false;
		String detail = null;
		try {
			Connection conn = (Connection) db.getConn();
			if(conn!=null)
				System.out.println("conn sucess!");
			
			sql = new String("SELECT * FROM merchant"); 
			
			//对查询结果进行判断
			rs = db.executeQuery(sql, params);
			if(!rs.next()){
				System.out.println("查询失败！");
				detail = new String("查询失败！");
			}else{
				rs = db.executeQuery(sql, params);
				System.out.println("查询成功！");
				status = true;
				detail = new String("查询成功！");
				while(rs.next()){
//					out.println("id:"+rs.getInt(1));
//					out.println("username:"+rs.getString(2));
//					out.println("password:"+rs.getString(3));
//					out.println(rs.getBoolean(7));
					JSONObject temp = new JSONObject();
					temp.put("merid", rs.getInt(1));
					temp.put("mername", rs.getString(2));
					temp.put("mercheck", rs.getBoolean(7));
					js.put(temp);
				}
			}
			json.put("status", status);
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}

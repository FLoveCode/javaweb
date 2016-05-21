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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import k.dao.DBO;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class CusDelete
 */
@WebServlet("/CusDelete")
public class CusDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CusDelete() {
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
		HttpSession session = request.getSession();//获取账号密码
		String cusname="hzk";
		String[] params = new String[]{cusname};
		
		DBO db = new DBO();
		String sql = null ;
		int n=0;//判断是否修改成功;
		JSONObject json = new JSONObject();
		JSONObject js = new JSONObject();
		Boolean status = false;
		String detail = null;
		try {
			Connection conn = (Connection) db.getConn();
			if(conn!=null)
				System.out.println("conn sucess!");
			
			sql = new String("DELETE FROM customer WHERE cusname=?");
			
			n = db.executeUpdate(sql, params);
			if(n==0){
				detail = new String("删除失败！");
				System.out.println("删除失败！");
			}else{
				System.out.println("删除成功！");
				detail = new String("删除成功！");
				status = true;
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

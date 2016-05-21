package k.service.merchant;

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

import k.dao.DBO;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class MerCheck
 */
@WebServlet("/MerCheck")
public class MerCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MerCheck() {
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
		String merid = "2";
		String[] params = new String[]{merid};
		
		DBO db = new DBO();
		int n = 0;
		String sql = null;
		
		JSONObject json = new JSONObject();
		JSONObject js= new JSONObject();
		Boolean status = false;
		String detail = null;
		try{
			Connection conn = (Connection) db.getConn();
			if(conn==null){
				System.out.println("连接成功！");
			}else{
				sql = new String("UPDATE merchant SET mercheck='true' WHERE merid=?");
				n = db.executeUpdate(sql, params);
			}
			if(n==0){
				System.out.println("审核失败！");
				detail = new String("审核失败！");
			}else{
				System.out.println("审核成功！");
				status = true;
				detail = new String("审核成功！");
			}
			
			json.put("status", status);
			json.put("detail", detail);
			json.put("message", js);
			out.println(json.toString());
			db.closeAll();
		}catch(ClassNotFoundException | InstantiationException
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

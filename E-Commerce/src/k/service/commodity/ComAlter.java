package k.service.commodity;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.jdbc.Connection;

import k.dao.DBO;

/**
 * Servlet implementation class ComAlter
 */
@WebServlet("/ComAlter")
public class ComAlter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComAlter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf-8");
		HttpSession session = request.getSession();
		String mername = "hzk";
		String comid = "1";
		String comname = "ZZZ";
		String comprice = "50";
		String comimage = "1";
		String comtotal = "10";
		String comsort = "z";
		String comdescribe = "isz";
		String[] params = new String[]{comname,comprice,comimage,comtotal,comsort,comdescribe,comid};
		
		DBO db = new DBO();
		int n = 0;
		String sql = null;
		try{
			Connection conn = (Connection) db.getConn();
			if(conn!=null){
				System.out.println("连接成功！");
			}
			sql = new String("UPDATE commodity SET comname=?,comprice=?,comimage=?,comtotal=?,comsort=?,comdescribe=? WHERE comid=?");
			n = db.executeUpdate(sql, params);
			if(n==0){
				System.out.println("修改失败！");
			}
		}catch(ClassNotFoundException | InstantiationException
				| IllegalAccessException | SQLException e) {
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

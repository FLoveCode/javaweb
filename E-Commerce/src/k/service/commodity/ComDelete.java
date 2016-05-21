package k.service.commodity;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import k.dao.DBO;

import com.mysql.jdbc.Connection;

/**
 * Servlet implementation class ComDelete
 */
@WebServlet("/ComDelete")
public class ComDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ComDelete() {
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
		String merid = "4";
		String comid = "1";
		
		String[] params = new String[]{merid,comid};
		
		DBO db = new DBO();
		int n = 0;
		String sql = null;
		try{
			Connection conn = (Connection) db.getConn();
			if(conn!=null){
				System.out.println("连接成功！");
			}
			sql = new String("DELETE FROM commodity WHERE merid=? AND comid=?");
			n = db.executeUpdate(sql, params);
			if(n==0){
				System.out.println("商品删除失败！");
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

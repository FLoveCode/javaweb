package k.service.commodity;

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

import k.dao.DBO;

/**
 * Servlet implementation class CheckCom
 */
@WebServlet("/CheckCom")
public class CheckCom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CheckCom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//商家查看自己的商品
		String username = "hzk";//账号
		String[] params = new String[]{username};
		HttpSession session = request.getSession();//存储账号密码
		
		PrintWriter out = response.getWriter();
		//对数据进行数据库查询
		DBO db = new DBO();
		ResultSet rs = null;
		String sql = null ;
		try {
			Connection conn = db.getConn();
			if(conn!=null)
				System.out.println("conn sucess!");
			
			sql = new String("SELECT * FROM commodity WHERE merid=(SELECT merid FROM merchant WHERE mername=?)"); 
			
			//对查询结果进行判断
			rs = db.executeQuery(sql, params);
			while(rs.next()){
				//out.println("comid:"+rs.getInt(1));
				out.println("comname:"+rs.getString(2));
				out.println("comprice:"+rs.getFloat(3));
				out.println("comimage:"+rs.getString(4));
				out.println("comtotal:"+rs.getInt(5));
				out.println("comsort:"+rs.getString(6));
				out.println("comdescribe:"+rs.getString(7));
			}
			db.closeAll();
		} catch (ClassNotFoundException | InstantiationException
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

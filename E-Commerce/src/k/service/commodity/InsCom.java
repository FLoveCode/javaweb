package k.service.commodity;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import k.dao.DBO;

/**
 * Servlet implementation class InsCom
 */
@WebServlet("/InsCom")
public class InsCom extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsCom() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String comname="hzk";
		String comprice="123456";
		String comimage="1";
		String comtotal=null;
		String comsort="18898874867";
		String comdescribe="xiaomi";
		String merid=null;
		String[] params = new String[]{comname,comprice,comimage,comtotal,comsort,comdescribe,merid};
		
		DBO db = new DBO();
		String sql = null ;
		int n=0;//判断是否插入成功;
		try {
			Connection conn = db.getConn();
			if(conn!=null)
				System.out.println("conn sucess!");
			
			sql = new String("INSERT INTO commodity (comname,comprice,comimage,comtotal,comsort,comdescribe,merid) values(?,?,?,?,?,?,?)");
			
			n = db.executeUpdate(sql, params);
			if(n==0){
				System.out.println("商品上架失败!");
			}else{
				System.out.println("商品上架成功!");
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

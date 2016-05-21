package k.dao;

import java.sql.*;
public class DBO {
	private Connection conn = null;//数据库连接
	private PreparedStatement pstmt = null;//预编译SQL容器
	private ResultSet rs = null;//结果集
	public DBO(){};
	
	public Connection getConn() throws ClassNotFoundException,InstantiationException,IllegalAccessException,SQLException{
		String driver = "com.mysql.jdbc.Driver";//jdbc驱动
		String url = "jdbc:mysql://115.28.228.39:3306/oss?"
		+"user=root&password=qq609150968.&useUnicode=true&characterEncoding=UTF8";//连接字符串
		Class.forName(driver);//加载驱动
		conn = DriverManager.getConnection(url);//获取连接
		return conn;//返回连接
	}
	//执行预处理语句，返回结果集
	public ResultSet executeQuery(String sql,String[] params){
		try{
			System.out.println(sql);
			//获取PreparedStatement对象
			pstmt=conn.prepareStatement(sql);
			//设置PreparedStatement对象的参数
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setString(i+1, params[i]);
				}
			}
			rs = pstmt.executeQuery();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return rs;
		
	}
	//执行更新，返回受影响的记录数
	public int executeUpdate(String sql,String[] params){
		int n=0;
		try{
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			if(params!=null){
				for(int i=0;i<params.length;i++){
					pstmt.setString(i+1, params[i]);
				}
			}
			n = pstmt.executeUpdate(); 
			System.out.println(n);
		}catch(SQLException e){
			e.printStackTrace();
		}
		return n;
	}
	public void closeAll(){
		//关闭ResultSet
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		//关闭PreparedStatement
		if(pstmt!=null){
			try{
				pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		//关闭Connection
		if(conn!=null){
			try{
				conn.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
	}
}


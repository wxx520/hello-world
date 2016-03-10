package test.cookie;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCTest {
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String user = "root";
		String password = "admin123";
		String url = "jdbc:mysql://localhost:3306/shopstore";
		String driver = "com.mysql.jdbc.Driver";
		
		 String tableName = "studinfo";
		 String sqlstr;
		 Connection con = null;
		 Statement stmt = null;
		 ResultSet rs = null;
		 
		 try {
			 
			Class.forName(driver);
			con = DriverManager.getConnection(url, user, password);
			stmt = con.createStatement();
			
			sqlstr = "insert into '+customer_info+' values ('wxx','123@qq.com')";
			stmt.executeUpdate(sqlstr);
			
			
			
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			System.out.println("数据库驱动不存在！");
			e1.printStackTrace();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			System.out.println("数据库存在异常！");
			e2.printStackTrace();
		}
		 
		 
		 
		 
		 
		

	}

}

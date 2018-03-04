package jayray.net.hello;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	String URL = "jdbc:mysql://localhost:3306/mysql_db";
	String user_name = "root";
	String pass = "Hackerbolt24";
	public String insertData(String userid,String password,String email,String phone)
	{
		 
		String query = "insert into logininfo Values ("+userid+",'"+password+"','"+email+"',"+phone+")";
		System.out.println(query);
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con=null;
		try {
			con = DriverManager.getConnection(URL,user_name,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement st=null;
		try {
			st = con.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ResultSet rs=null;
		String dataInsertion="Data inserted Successfully";
		System.out.println("userID"+userid);
		try {
		st.executeUpdate(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			dataInsertion="Data is not inserted";
		}
	
		
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return dataInsertion;
	}
	public String dbValidate(String n)
	{
		 
		String query = "select password from loginInfo where userId="+n+"";
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con=null;
		try {
			con = DriverManager.getConnection(URL,user_name,pass);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Statement st=null;
		try {
			st = con.createStatement();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		ResultSet rs=null;
		try {
			rs = st.executeQuery(query);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String password=null;
		try {
			while(rs.next())
			{
			 password = rs.getString("password");
			}
			System.out.println(password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			st.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return password;
		
	}
	
}

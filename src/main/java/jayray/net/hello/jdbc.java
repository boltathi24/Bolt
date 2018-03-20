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
	public String insertData(String userid,String password,String email,String phone) throws SQLException, ClassNotFoundException
	{
		 
		String query = "insert into logininfo Values ("+userid+",'"+password+"','"+email+"',"+phone+")";
		System.out.println("DBStatus:");
		System.out.println(userid);
		System.out.println(query);
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection(URL,user_name,pass);
		Statement st = con.createStatement();
		String datainsertion="Data insertion: Success";
		try
		{
		st.executeUpdate(query);
		}
		catch(Exception e)
		{
			datainsertion="Data insertion Failure";
		}
		System.out.println(datainsertion);
		return datainsertion;
		
	}
	public String dbValidate(String n) throws ClassNotFoundException, SQLException
	{
		String query = "select password from loginInfo where userId="+n+"";
		
		System.out.println("DBValidationStatus:");
		
		
		Class.forName("com.mysql.jdbc.Driver");
		String password="";
		Connection con = DriverManager.getConnection(URL,user_name,pass);
		Statement st = con.createStatement();
		try {
		ResultSet rs=st.executeQuery(query);	
		while(rs.next())
		{
			password=rs.getString("password");
		}
		}
		catch(Exception e)
		{
			password="unable to Retrieve";
		}
		
		return password;
		
	}
	
}

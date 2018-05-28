package bolt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Jdb {
	String URL = "jdbc:mysql://localhost:3306/mysql_db";
	String user_name = "root";
	String pass = "Hackerbolt24";
	public String insertData(String email,String userName,String password,String mobile) throws SQLException, ClassNotFoundException
	{
		 
		String query = "insert into userdetails Values ('"+email+"','"+userName+"','"+password+"','"+mobile+"')";
		System.out.println("DBStatus:");

		System.out.println("Query:"+query);
		
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

}

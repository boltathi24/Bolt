package jayray.net.hello;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloWorldResource {
	
	
	jdbc j=new jdbc();
	
	@Path("/run")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayhello() {
		return "hello";
	}	
	
	@Path("/json")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Students hijson() {
		Students a=new Students();
		a.setEmail("athithya24@gmail.com");
		a.setPassword("hackerbolt");
		a.setPhone("8015400865");
		a.setUserId("548759");
		System.out.println("HiTeam"+a);
		return a;
	}
		
	@Path("/consume")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces({MediaType.TEXT_PLAIN})
	
	public String  consumeJson(Students s) {
		System.out.println("Hi");
		System.out.println(s.getEmail());		
		return s.getEmail();
	}	
	
	@Path("/SignUp")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String signup(Students s) throws ClassNotFoundException, SQLException {		
		return j.insertData(s.getUserId(), s.getPassword(), s.getPassword(), s.getPhone());
	}
	
	@Path("/Login")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_JSON)
	public String Login(Students s) throws ClassNotFoundException, SQLException {	
		String errorMessage="";
		String actualPassword=j.dbValidate(s.getUserId());
		if(actualPassword.equalsIgnoreCase(s.getPassword()))
		{
			errorMessage="Login Successful";
		}
		else
			errorMessage="Login UnSuccessful! Either UserName or Password is Incorrect";
		return errorMessage;
	}

}
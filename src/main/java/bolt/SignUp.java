package bolt;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



@Path("SignUp")
public class SignUp {
	
	
	Jdb j=new Jdb();
	
	@Path("/run")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayhello() {
		return "hello";
	}	
	
	
	@Path("/Register")
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String signUp(Register R) throws ClassNotFoundException, SQLException {
		System.out.println(R.getEmail());
		return j.insertData(R.getEmail(), R.getUserName(), R.getPassword(), R.getMobile());
	
	}	
}

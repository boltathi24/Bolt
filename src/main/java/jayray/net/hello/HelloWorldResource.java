package jayray.net.hello;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("hello")
public class HelloWorldResource {
	
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
	
	@Path("/jsson")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Track  getTrackInJSON() {
		
		Track track = new Track();
		track.setTitle("Enter Sandman");
		track.setSinger("Metallica");
		System.out.println("HITest1"+track);
		return track;
	}
	
	
	@Path("/SignUp")
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String signup() {
		
		return "hello";
	}

}
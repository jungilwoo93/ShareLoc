package paths;
//comme Vol service

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import controllers.UserManager;

//il faut faire la securite
//une route envoyer, si c'est bon, alors faire token
@Path("/api")
public class Authentification {

	@GET
	public String getAllUser(){
		return "coucou";
		//return Response.ok().entity(UserManager.getAllUsers()).build();
	}
	
	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(@PathParam("id") String id) {
		return Response.ok().entity(UserManager.getUser(id)).build();
	}

	public static List<String> findUserRoles(String subject) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

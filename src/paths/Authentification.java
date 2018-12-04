package paths;
//comme Vol service

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

//il faut faire la securite
//une route envoyer, si c'est bon, alors faire token
@Path("/vols")
public class Authentification {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUser(){
		return Response.ok().entity(DaoUser.getUser()).build();
	}
}

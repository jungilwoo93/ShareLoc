package paths;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import controllers.ColocationManager;
import model.Colocation;

@Path("/colocation")
public class GestionColocation {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll() {
		return ColocationManager.getColocations().toString();
	}
	
	@GET
	@Path("/coloc")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getColoc(@QueryParam("name") String name) {
		return Response.ok().entity(ColocationManager.getColocation(name)).build();
	}
	
	@PUT
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createColoc(@FormParam("name") String name,@QueryParam("login") String login) {
		if(!ColocationManager.createColocation(name,login))
			return Response.ok().entity(Status.FORBIDDEN).build();
		return Response.ok().entity(Status.CREATED).build();
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	//problème, ne pas mis à jour, il a create un nouveau
	public Response update(@QueryParam("name") String name, @FormParam("name") String newName) {
		Colocation c = ColocationManager.getColocation(name);
		if(ColocationManager.update(name,newName))
			return Response.ok().entity(Status.ACCEPTED).build();
		return Response.ok().entity(Status.NOT_MODIFIED).build();
	}
	
	@POST
	@Path("/invite")
	@Produces(MediaType.APPLICATION_JSON)
	public Response inviteUser(@FormParam("colocation") String coloc, @FormParam("login") String user) {
		if(ColocationManager.inviteUser(coloc, user)) {
			return Response.ok().entity(Status.CREATED).build();
		}
		return Response.ok().entity(Status.NOT_FOUND).build();
	}
	
}

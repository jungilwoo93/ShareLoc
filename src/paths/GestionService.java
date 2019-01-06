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
import controllers.ServiceManager;
import model.Service;

@Path("/services")
public class GestionService {
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAll() {
		return ServiceManager.getServices().toString();
	}
	
	@GET
	@Path("/service")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getService(@QueryParam("name") String name) {
		return Response.ok().entity(ServiceManager.getService(name)).build();
	}
	
	@PUT
	@Path("/create")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createColoc(@FormParam("title") String title,@FormParam("description") String description,@FormParam("cost") String cost) {
		if(!ServiceManager.createService(title,description,Integer.parseInt(cost)))
			return Response.ok().entity(Status.FORBIDDEN).build();
		return Response.ok().entity(Status.CREATED).build();
	}
	
	/*@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Response update(@QueryParam("name") String name, @FormParam("name") String newName) {
		Service c = ServiceManager.getService(name);
		if(ServiceManager.update(name,newName))
			return Response.ok().entity(Status.ACCEPTED).build();
		return Response.ok().entity(Status.NOT_MODIFIED).build();
	}*/
	
	
}

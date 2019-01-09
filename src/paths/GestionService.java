package paths;

import java.io.IOException;

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
	public Response createService(@FormParam("name") String nameColoc, @QueryParam("login") String login,@FormParam("title") String title,@FormParam("description") String description,@FormParam("cost") String cost,@FormParam("days") String days) {
		if(!ServiceManager.createService(nameColoc,login,title,description,Integer.parseInt(cost),Integer.parseInt(days)))
			return Response.ok().entity(Status.FORBIDDEN).build();
		return Response.ok().entity(Status.CREATED).build();
	}
	
	@PUT
	@Path("/realisation")
	@Produces(MediaType.APPLICATION_JSON)
	public Response createServiceWithColocation(@QueryParam("login") String login,@QueryParam("name") String nameColoc,@QueryParam("title") String title, @FormParam("img") String urlImg, @FormParam("share") String share) {
		if(!ServiceManager.realisation(login,nameColoc,title,urlImg,Integer.parseInt(share)))
			return Response.ok().entity(Status.FORBIDDEN).build();
		return Response.ok().entity(Status.ACCEPTED).build();
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

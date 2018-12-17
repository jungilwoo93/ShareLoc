package paths;
//comme Vol service

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import controllers.UserManager;
import model.User;
import security.JWTokenUtility;
import security.SigninNeeded;

//TODO securite
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

	@GET
	@SigninNeeded
	@Path("/whoami")
	@Produces(MediaType.APPLICATION_JSON)
	public Response whoami(@Context SecurityContext security) {
		User user = UserManager.getUser(security.getUserPrincipal().getName());
		if (user!=null)
			return Response.ok().entity(user).build();
		return Response.status(Status.NO_CONTENT).build();
	}
	
	@POST
	@Path("/signin")
	@Produces(MediaType.APPLICATION_JSON)
	public Response signin(@QueryParam("login") String login, @QueryParam("password") String password) {
		User u = UserManager.login(login, password);

		if (u != null)
			return Response.ok().entity(JWTokenUtility.buildJWT(u.getLogin())).build();

		return Response.status(Status.NOT_ACCEPTABLE).build();
	}
	
	public static List<String> findUserRoles(String subject) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

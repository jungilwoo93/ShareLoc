package paths;
//comme Vol service

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.SecurityContext;

import controllers.UserManager;
import model.User;
import security.JWTAuthFilter;
import security.JWTokenUtility;
import security.SigninNeeded;

//TODO securite
//une route envoyer, si c'est bon, alors faire token
@Path("/api")
public class Authentification {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String getAllUser() {
		return UserManager.getUsers().toString();
	}

	@GET
	@SigninNeeded
	@Path("/whoami")
	@Produces(MediaType.APPLICATION_JSON)
	public Response whoami(@Context SecurityContext security) {
		//User user = UserManager.getUser(security.getUserPrincipal().getName());
		User user = null;//UserManager.getUser("315343948@qq.com");
		
		if (security.getUserPrincipal() != null) {
	        user = UserManager.getUser(security.getUserPrincipal().getName());
	    } else {
	        throw new WebApplicationException(Status.UNAUTHORIZED);
	    }
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
	
	@PUT
	@Path("/signup")
	@Produces(MediaType.APPLICATION_JSON)
	//@Consumes("application/x-www-form-urlencoded")
	//@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response createAccount(@FormParam("login") String login, @FormParam("password") String password,@FormParam("firstname") String firstname, @FormParam("lastname") String lastname) {
		//return login+" " + password+" "+firstname+" "+lastname;
		if(!UserManager.createUser(login, password, firstname, lastname))
			return Response.ok().entity(Status.FORBIDDEN).build();
		return Response.ok().entity(Status.CREATED).build();
	}
	
	@PUT
	@Path("/update")
	@Produces(MediaType.APPLICATION_JSON)
	public Response updateUser(@FormParam("login") String login, @FormParam("password") String password, @FormParam("firstname") String firstname, @FormParam("lastname") String lastname) {
		if(UserManager.update(login, password, firstname, lastname))
			return Response.ok().entity(Status.ACCEPTED).build();
		return Response.ok().entity(Status.NOT_MODIFIED).build();
	}
	
	
	public static List<String> findUserRoles(String subject) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}

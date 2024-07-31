import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.*;
import java.util.*;

@Path("/suppliers")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SupplierController {
	
	SupplierDAO dao=new SupplierDAO();
	
//   @GET
//   @Path("/sample")
//   public Response saveExample() {
//	   boolean f=dao.saveExample();
//	   if(f)
//		 return  Response.ok().build();
//	   else
//		 return  Response.status(Status.NO_CONTENT).build();
//   }
   
   @GET
   @Path("/{id}")
   public Response findSup(@PathParam("id") int id) {
	   Supplier s=dao.findSupById(id);
	   System.out.println(s);
	   if(s != null)
		 return  Response.ok().entity(s).build();
	   else
		 return  Response.status(Status.NO_CONTENT).build();
   }
   
   @GET
   public Response findAll() {
	   List<Supplier> sups=dao.getAll();
	   if(sups.size()>0)
		 return  Response.ok(sups).build();
	   else
		 return  Response.status(Status.NO_CONTENT).build();
   }
   
}

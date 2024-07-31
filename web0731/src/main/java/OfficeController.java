import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import model.*;

@Path("/offices")
public class OfficeController {
	OfficeDAO dao = new OfficeDAO();

	@GET
	@Path("/sample")
	public Response saveExample() {
		boolean f = dao.saveOffice();
		if (f)
			return Response.ok().build();
		else
			return Response.status(Status.NO_CONTENT).build();
	}

	@GET
	public Response findAll() {
		List<Office> ofs = dao.getAll();
		if (ofs.size() > 0)
			return Response.ok(ofs).build();
		else
			return Response.status(Status.NO_CONTENT).build();
	}
}

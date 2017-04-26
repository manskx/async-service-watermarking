package com.manskx.async.watermark.api;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.manskx.async.watermark.model.*;

@Path("/watermarks")
@Component
public class Watermarks {
	@Path("hello")
	@GET
	public Response helloSpringReasteasyStarter() throws Exception {
		return Response.status(200).entity("hello world").build();
	}

	@Path("/document")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response watermark(DocumentWrapper documentWrapper) {

		try {
			Watermark documentWrapperWatermark = new Watermark();
			documentWrapperWatermark.setTitle("watermarked");
			documentWrapper.getDocument().setWatermark(documentWrapperWatermark);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(500).entity("ERROR: " + e.getMessage()).build();
		}

		return Response.status(200).entity(documentWrapper).build();

	}

}

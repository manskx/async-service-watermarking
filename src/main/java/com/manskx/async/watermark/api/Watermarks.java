package com.manskx.async.watermark.api;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manskx.async.watermark.controller.WatermarkProcessor;
import com.manskx.async.watermark.model.*;

/**
 * 
 * @author ahmedm Watermarks API.
 */
@Path("/watermarks")
@Component
public class Watermarks {
	@Autowired
	private WatermarkProcessor watermarkProcessor;

	/**
	 * This is main watermarking service to watermark documents.
	 * 
	 * @param documentWrapper:
	 *            input document ( book , journal ....)
	 * @return
	 */
	@Path("/document")
	@POST
	@Consumes("application/json")
	@Produces("application/json")
	public Response watermark(DocumentWrapper documentWrapper) {
		Ticket ticket = null;
		try {
			// TODO: convert ticket object to jwt token.
			ticket = watermarkProcessor.startWaterMarking(documentWrapper.getDocument());
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(HttpServletResponse.SC_NOT_FOUND).entity("ERROR: " + e.getMessage()).build();
		}

		return Response.status(HttpServletResponse.SC_ACCEPTED).entity(ticket).build();

	}

	// Just Hello World
	@Path("hello")
	@GET
	public Response helloSpringReasteasyStarter() throws Exception {
		return Response.status(HttpServletResponse.SC_OK).entity("hello world").build();
	}
}

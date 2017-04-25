package com.manskx.async.watermark.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

@Path("/watermarks")
@Component
public class Watermarks {
	@Path("hello")
	@GET
	public Response helloSpringReasteasyStarter() throws Exception {
		return Response.status(200).entity("hello world").build();
	}
}

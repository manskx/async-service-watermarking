package com.manskx.async.watermark.api;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manskx.async.watermark.controller.WatermarkProcessor;
import com.manskx.async.watermark.model.Document;

/**
 * Endpoint for documents
 * 
 * @author ahmedm
 *
 */
@Path("/documents")
@Component
public class Documents {
	@Autowired
	private WatermarkProcessor watermarkProcessor;

	@GET
	@Produces("application/json")
	public Response getDocumebt(@QueryParam("document_id") int documentId) {
		Document document = null;

		try {
			document = watermarkProcessor.getdocument(documentId);
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(HttpServletResponse.SC_NOT_FOUND).entity("ERROR: " + e.getMessage()).build();
		}

		return Response.status(HttpServletResponse.SC_OK).entity(document).build();

	}
}

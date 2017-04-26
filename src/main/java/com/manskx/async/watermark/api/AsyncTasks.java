package com.manskx.async.watermark.api;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import com.manskx.async.watermark.controller.WatermarkProcessor;
import com.manskx.async.watermark.model.State;

/**
 * 
 * @author ahmedm This endpoint for async tasks
 */
@Path("asynctasks")
public class AsyncTasks {
	@Autowired
	private WatermarkProcessor watermarkProcessor;

	/**
	 * 
	 * @param taskId
	 * @return Task status
	 * @throws Exception
	 */
	@Path("status")
	@GET
	public Response checkWatermarkStatus(@QueryParam("task_id") int taskId) {
		State status = null;
		try {
			status = watermarkProcessor.checkTaskStatus(taskId);

			switch (status) {
			case NOT_STARTED:
				return Response.status(HttpServletResponse.SC_CONFLICT).entity(status).build();
			case PENDING:
				return Response.status(HttpServletResponse.SC_ACCEPTED).entity(status).build();
			case FINISHED:
				return Response.status(HttpServletResponse.SC_CREATED).entity(status).build();
			}
		} catch (Exception e) {
			e.printStackTrace();
			return Response.status(HttpServletResponse.SC_INTERNAL_SERVER_ERROR).entity("ERROR: " + e.getMessage())
					.build();
		}
		return Response.status(HttpServletResponse.SC_NOT_FOUND).entity(status).build();

	}

}

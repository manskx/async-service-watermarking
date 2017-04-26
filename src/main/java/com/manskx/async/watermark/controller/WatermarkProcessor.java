package com.manskx.async.watermark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manskx.async.watermark.data.*;
import com.manskx.async.watermark.model.*;

/**
 * 
 * @author ahmedm This is main processor (watermark manager)
 * 
 */
@Component
public class WatermarkProcessor {
	@Autowired
	DocumentData documentRepository;
	@Autowired
	AscyncTasksProcessor ascyncTasksProcessor;

	/**
	 * 
	 * @param document:
	 *            to be watermarked
	 * @return Ticket: contains job id and document id;
	 */
	public Ticket startWaterMarking(Document document) {

		documentRepository.insertDocument(document);
		int id = ascyncTasksProcessor.addwaterMarkAscyncTask(document);
		ascyncTasksProcessor.startAscyncTask(id);
		return new Ticket(document.getId(), id);
	}

	public State checkTaskStatus(int taskId) throws Exception {
		return ascyncTasksProcessor.getTaskState(taskId);
	}

	/**
	 * 
	 * @param documentId
	 * @return return document object of documentId.
	 * NOTE: if the document id not watermarked it will not contain watermark object
	 */
	public Document getdocument(int documentId) {
		return documentRepository.getDocumentByID(documentId);
	}
}

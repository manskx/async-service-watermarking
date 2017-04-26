package com.manskx.async.watermark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manskx.async.watermark.data.*;
import com.manskx.async.watermark.model.*;

@Component
public class WatermarkProcessor {
	@Autowired
	DocumentData documentRepository;
	@Autowired
	AscyncTasksProcessor ascyncTasksProcessor;

	// returns task id
	public Ticket startWaterMarking(Document document) {

		documentRepository.insertDocument(document);
		int id = ascyncTasksProcessor.addwaterMarkAscyncTask(document);
		ascyncTasksProcessor.startAscyncTask(id);
		return new Ticket(document.getId(), id);
	}

	public State checkTaskStatus(int taskId) throws Exception {

		return ascyncTasksProcessor.getTaskState(taskId);

	}

	public Document getdocument(int documentId) {
		return documentRepository.getDocumentByID(documentId);
	}
}

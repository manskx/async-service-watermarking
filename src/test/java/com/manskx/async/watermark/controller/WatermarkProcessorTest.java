package com.manskx.async.watermark.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.manskx.async.watermark.Application;
import com.manskx.async.watermark.config.Configuration;
import com.manskx.async.watermark.model.AsyncTask;
import com.manskx.async.watermark.model.Book;
import com.manskx.async.watermark.model.Content;
import com.manskx.async.watermark.model.Document;
import com.manskx.async.watermark.model.State;
import com.manskx.async.watermark.model.Ticket;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class WatermarkProcessorTest {
	@Autowired
	private WatermarkProcessor watermarkProcessor;

	@Test
	public void testPendingWatermarkingDocument1() throws Exception {
		Document document = new Book("mansy", "Ahmed", "topic", 23, Content.BOOK);
		Ticket ticket = watermarkProcessor.startWaterMarking(document);
		Thread.sleep(Configuration.WATERMARK_TIME / 2);
		assertEquals(watermarkProcessor.checkTaskStatus(ticket.getAsunc_task_id()), State.PENDING);
	}

	@Test
	public void testFinishedwatermarkingdocument1() throws Exception {
		Document document = new Book("mansy", "Ahmed", "topic", 23, Content.BOOK);
		Ticket ticket = watermarkProcessor.startWaterMarking(document);
		Thread.sleep(Configuration.WATERMARK_TIME + 100);
		assertEquals(watermarkProcessor.checkTaskStatus(ticket.getAsunc_task_id()), State.FINISHED);
	}

}

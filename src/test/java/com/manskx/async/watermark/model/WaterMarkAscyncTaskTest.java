package com.manskx.async.watermark.model;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.manskx.async.watermark.config.Configuration;

public class WaterMarkAscyncTaskTest {
	@Test
	public void WaterMarkAscyncTaskTestStarted() throws InterruptedException {
		Document document = new Book("mansy", "Ahmed", "topic", 23, Content.BOOK);
		AsyncTask ascyncTask = new WaterMarkAscyncTask(document);
		ascyncTask.Start();
		Thread.sleep(Configuration.WATERMARK_TIME / 2);
		assertEquals(ascyncTask.getState(), State.PENDING);
	}

	@Test
	public void WaterMarkAscyncTaskTestFinished() throws InterruptedException {
		Document document = new Book("mansy", "Ahmed", "topic", 23, Content.BOOK);
		AsyncTask ascyncTask = new WaterMarkAscyncTask(document);
		ascyncTask.Start();
		Thread.sleep(Configuration.WATERMARK_TIME + 20);
		assertEquals(ascyncTask.getState(), State.FINISHED);
	}
}

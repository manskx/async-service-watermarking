package com.manskx.async.watermark.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.manskx.async.watermark.Application;
import com.manskx.async.watermark.model.AscyncTask;
import com.manskx.async.watermark.model.Book;
import com.manskx.async.watermark.model.Content;
import com.manskx.async.watermark.model.Document;
import com.manskx.async.watermark.model.WaterMarkAscyncTask;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)

public class AsyncTaskDataRepoTest {
	@Autowired
	private AscyncTaskData ascyncTaskRepository;

	private int id1;

	@Before
	public void setUp() {
		Document document = new Book("mansy", "Ahmed", "topic", 23, Content.BOOK);
		AscyncTask ascyncTask = new WaterMarkAscyncTask(document);
		id1 = ascyncTaskRepository.insertAscyncTask(ascyncTask);
	}

	@Test
	public void testContainsValidBook() {
		AscyncTask ascyncTask = ascyncTaskRepository.getAscyncTaskByID(id1);
		assertNotEquals(ascyncTask, null);
	}

	@Test
	public void testNotContainsValidBook() {
		AscyncTask ascyncTask = ascyncTaskRepository.getAscyncTaskByID(2213213);
		assertEquals(ascyncTask, null);
	}
}

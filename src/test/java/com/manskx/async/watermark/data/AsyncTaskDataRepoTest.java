package com.manskx.async.watermark.data;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.manskx.async.watermark.Application;
import com.manskx.async.watermark.model.Book;
import com.manskx.async.watermark.model.Content;
import com.manskx.async.watermark.model.Document;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)

public class AsyncTaskDataRepoTest {
	@Autowired
	private AscyncTask ascyncTaskRepository;

	private int id1;

	@Before
	public void setUp() {

	}

}

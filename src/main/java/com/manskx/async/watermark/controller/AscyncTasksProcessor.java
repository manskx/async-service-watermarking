package com.manskx.async.watermark.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manskx.async.watermark.data.AsyncTaskData;
import com.manskx.async.watermark.model.*;

@Component
public class AscyncTasksProcessor {
	@Autowired
	AsyncTaskData ascyncTasksRepository;

	public State getTaskState(int taskId) throws Exception {
		if (ascyncTasksRepository.getAscyncTaskByID(taskId) == null)
			throw new Exception("invalid task Id");

		return ascyncTasksRepository.getAscyncTaskByID(taskId).getState();
	}

	public void startAscyncTask(int taskId) {
		ascyncTasksRepository.getAscyncTaskByID(taskId).Start();
	}

	// return task Id
	public int addwaterMarkAscyncTask(Document document) {
		AsyncTask waterMarkAscyncTask = new WaterMarkAscyncTask(document);
		int taskId = ascyncTasksRepository.insertAscyncTask(waterMarkAscyncTask);
		return taskId;
	}
}

package com.manskx.async.watermark.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.manskx.async.watermark.model.AsyncTask;
import com.manskx.async.watermark.utils.Numbers;

/**
 * This is very simple storing method. Key-Value HashMap
 * 
 * @author ahmedm
 *
 */
@Repository
public class AsyncTaskDataMemory implements AsyncTaskData {
	private Map<Integer, AsyncTask> tasks;

	public AsyncTaskDataMemory() {
		tasks = new ConcurrentHashMap<Integer, AsyncTask>();
	}

	@Override
	public AsyncTask getAscyncTaskByID(int id) {
		if (tasks.containsKey(id))
			return tasks.get(id);
		return null;
	}

	@Override
	public int insertAscyncTask(AsyncTask ascyncTask) {
		int id = getRandomId();
		ascyncTask.setId(id);
		tasks.put(id, ascyncTask);
		return id;
	}

	private int getRandomId() {
		int id = Numbers.randInt(1, 1000);
		while (tasks.containsKey(id)) {
			id = Numbers.randInt(1, 1000);
		}

		return id;
	}

}

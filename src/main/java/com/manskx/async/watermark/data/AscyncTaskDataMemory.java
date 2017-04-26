package com.manskx.async.watermark.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.manskx.async.watermark.utils.Numbers;

@Repository
public class AscyncTaskDataMemory implements AscyncTaskData {
	private Map<Integer, AscyncTask> tasks;

	public AscyncTaskDataMemory() {
		tasks = new ConcurrentHashMap<Integer, AscyncTask>();
	}

	@Override
	public AscyncTask getAscyncTaskByID(int id) {
		if (tasks.containsKey(id))
			return tasks.get(id);
		return null;
	}

	@Override
	public int insertAscyncTask(AscyncTask ascyncTask) {
		// TODO Auto-generated method stub
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

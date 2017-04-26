package com.manskx.async.watermark.data;

import com.manskx.async.watermark.model.AscyncTask;

public interface AscyncTaskData {
	AscyncTask getAscyncTaskByID(int id);

	int insertAscyncTask(AscyncTask ascyncTask);

}

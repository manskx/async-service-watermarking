package com.manskx.async.watermark.data;

public interface AscyncTaskData {
	AscyncTask getAscyncTaskByID(int id);

	int insertAscyncTask(AscyncTask ascyncTask);

}

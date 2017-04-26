package com.manskx.async.watermark.data;

import com.manskx.async.watermark.model.AsyncTask;

/**
 * 
 * @author ahmedm Interface for storing Async tasks. If you want to add your own
 *         storing method (EX: database , files ....) , just implement this
 *         interface.
 */
public interface AsyncTaskData {
	AsyncTask getAscyncTaskByID(int id);

	int insertAscyncTask(AsyncTask ascyncTask);

}

package com.manskx.async.watermark.model;

/**
 * This interface for general async tasks. If you have another asynchronous
 * tasks, just implement this interface
 * 
 * @author ahmedm
 *
 */
public interface AsyncTask {
	public void Start();

	public boolean isFinished();

	public State getState();

	public void setId(int id);
}

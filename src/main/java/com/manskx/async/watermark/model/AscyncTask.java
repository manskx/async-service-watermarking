package com.manskx.async.watermark.model;

public interface AscyncTask {
	public void Start();

	public boolean isFinished();

	public State getState();

	public void setId(int id);
}
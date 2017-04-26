package com.manskx.async.watermark.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.manskx.async.watermark.config.Configuration;

public class WaterMarkAscyncTask implements AsyncTask {

	private int id;
	private boolean finished;
	private int percentage;

	private Document document;
	private State state;

	public WaterMarkAscyncTask() {

	}

	public WaterMarkAscyncTask(Document document) {
		this.document = document;
		finished = false;
		percentage = 0;
		state = State.NOT_STARTED;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isFinished() {
		return finished;
	}

	public void setFinished(boolean finished) {
		this.finished = finished;
	}

	public int getPercentage() {
		return percentage;
	}

	public void setPercentage(int percentage) {
		this.percentage = percentage;
	}

	@Override
	public void Start() {
		Thread t1 = new Thread(new Runnable() {

			public void run() {
				try {
					state = State.PENDING;
					Thread.sleep(Configuration.WATERMARK_TIME);
					finished = true;
					state = State.FINISHED;
					document.markWatermarked();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		t1.start();

	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

}

package com.manskx.async.watermark.model;

public class Ticket {
	private int document_id;
	private int asunc_task_id;

	public Ticket(int document_id, int async_task_id) {
		this.document_id = document_id;
		this.asunc_task_id = async_task_id;
	}

	public int getDocument_id() {
		return document_id;
	}

	public void setDocument_id(int document_id) {
		this.document_id = document_id;
	}

	public int getAsunc_task_id() {
		return asunc_task_id;
	}

	public void setAsunc_task_id(int asunc_task_id) {
		this.asunc_task_id = asunc_task_id;
	}

}

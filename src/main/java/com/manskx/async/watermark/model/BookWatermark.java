package com.manskx.async.watermark.model;

public class BookWatermark extends Watermark {
	private String topic;

	public BookWatermark() {
	}

	public BookWatermark(Book book) {
		super(book);
		this.setTopic(book.getTopic());
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

}

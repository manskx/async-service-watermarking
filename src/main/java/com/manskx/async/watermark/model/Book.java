package com.manskx.async.watermark.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Book extends Document {
	private String topic;

	public Book() {
		super();
	}

	/**
	 * Jackson constructor.
	 * 
	 * @param title
	 * @param author
	 * @param topic
	 * @param fileId
	 * @param content
	 */
	public Book(@JsonProperty("title") String title, @JsonProperty("author") String author,
			@JsonProperty("topic") String topic, @JsonProperty("file_id") int fileId,
			@JsonProperty("content") Content content) {
		super(title, author, content, fileId);
		this.topic = topic;

	}

	/**
	 * This is key value constractor to be used for general document types.
	 * 
	 * @param properties
	 */
	public Book(Map<String, Object> properties) {
		super((String) properties.get("title"), (String) properties.get("author"),
				Content.valueOf((String) properties.get("content")), (Integer) properties.get("file_id"));

		this.topic = (String) properties.get("topic");
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	/**
	 * Watermarking process
	 * 
	 * NOTE: watermarking for document is not the same for journels
	 */
	@Override
	public void markWatermarked() {
		this.setWatermark(new BookWatermark(this));
	}
}

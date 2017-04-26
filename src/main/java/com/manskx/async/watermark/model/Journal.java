package com.manskx.async.watermark.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Journal extends Document {
	public Journal() {
		super();
	}

	public Journal(@JsonProperty("title") String title, @JsonProperty("author") String author,
			@JsonProperty("file_id") int fileId, @JsonProperty("content") Content content) {
		super(title, author, content, fileId);

	}

	/**
	 * This is key value constractor to be used for general document types.
	 * 
	 * @param properties
	 */
	public Journal(Map<String, Object> properties) {
		super((String) properties.get("title"), (String) properties.get("author"),
				Content.valueOf((String) properties.get("content")), (Integer) properties.get("file_id"));

	}

	/**
	 * Watermarking process
	 * 
	 * NOTE: watermarking for document is not the same for journals
	 */
	@Override
	public void markWatermarked() {
		this.setWatermark(new JournalWatermark(this));
	}

}

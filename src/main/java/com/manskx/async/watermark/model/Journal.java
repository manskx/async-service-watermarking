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

	public Journal(Map<String, Object> properties) {
		super((String) properties.get("title"), (String) properties.get("author"),
				Content.valueOf((String) properties.get("content")), (Integer) properties.get("file_id"));

	}

	@Override
	public void markWatermarked() {
		this.setWatermark(new JournalWatermark(this));
	}

}

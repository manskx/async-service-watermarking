package com.manskx.async.watermark.model;

import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;

public class DocumentWrapper {
	private Document document;

	@JsonCreator
	public DocumentWrapper(Map<String, Object> properties) throws Exception {
		Content content = null;
		try {
			content = Content.valueOf((String) properties.get("content"));
		} catch (Exception e) {
			throw new Exception("Unsupported content type");
		}
		switch (content) {
		case BOOK:
			this.document = new Book(properties);
			break;
		case JOURNAL:
			this.document = new Journal(properties);
			break;
		}
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public Document getDocument() {
		return document;
	}
}

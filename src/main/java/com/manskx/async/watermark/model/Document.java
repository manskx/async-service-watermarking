package com.manskx.async.watermark.model;

import com.fasterxml.jackson.annotation.JsonInclude;

public class Document {
	private int id;
	private String title;
	private int file_id;
	private Content content;
	private String author;
	@JsonInclude(JsonInclude.Include.NON_NULL)
	private Watermark watermark;

	public Document() {

	}

	public Document(String title, String author, Content content, int file_id) {
		this.title = title;
		this.author = author;
		this.content = content;
		this.file_id = file_id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getFile_id() {
		return file_id;
	}

	public void setFile_id(int file_id) {
		this.file_id = file_id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public Watermark getWatermark() {
		return watermark;
	}

	public void setWatermark(Watermark watermark) {
		this.watermark = watermark;
	}

}

package com.manskx.async.watermark.model;

/**
 * Base watermark object to be extended for future other watermark types
 * 
 * @author ahmedm
 *
 */
public class Watermark {
	private Content content;
	private String title;
	private String author;

	public Watermark() {

	}

	public Watermark(Document document) {
		this.content = document.getContent();
		this.title = document.getTitle();
		this.author = document.getAuthor();
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}

package com.manskx.async.watermark.data;

import com.manskx.async.watermark.model.Document;

public interface DocumentData {

	Document getDocumentByID(int id);

	int insertDocument(Document document);

}

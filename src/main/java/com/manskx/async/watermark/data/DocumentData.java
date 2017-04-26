package com.manskx.async.watermark.data;

import com.manskx.async.watermark.model.Document;

/**
 * 
 * @author ahmedm Interface for storing Documents. If you want to add your own
 *         storing method (EX: database , files ....) , just implement this
 *         interface.
 */
public interface DocumentData {

	Document getDocumentByID(int id);

	int insertDocument(Document document);

}

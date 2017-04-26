package com.manskx.async.watermark.data;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.stereotype.Repository;

import com.manskx.async.watermark.model.*;
import com.manskx.async.watermark.utils.Numbers;

/**
 * This is very simple storing method. Key-Value HashMap
 * 
 * @author ahmedm
 *
 */
@Repository
public class DocumentDataMemory implements DocumentData {

	private Map<Integer, Document> documents;

	public DocumentDataMemory() {
		documents = new ConcurrentHashMap<Integer, Document>();
	}

	@Override
	public Document getDocumentByID(int id) {
		if (documents.containsKey(id))
			return documents.get(id);
		return null;
	}

	@Override
	public int insertDocument(Document document) {
		// TODO Auto-generated method stub
		int id = getRandomId();
		document.setId(id);
		documents.put(id, document);
		return id;

	}

	private int getRandomId() {
		int id = Numbers.randInt(1, 1000);
		while (documents.containsKey(id)) {
			id = Numbers.randInt(1, 1000);
		}

		return id;
	}

}

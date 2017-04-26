package com.manskx.async.watermark.model;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DocumentWrapperTest {

	@Test
	public void TestDocumentWrapperValidJournal1() throws JsonParseException, JsonMappingException, IOException {
		// valid Journal
		String journal = "{\r\n\t\"title\":\"mansy\",\r\n\t\"file_id\":23,\r\n\t\"content\":\"JOURNAL\",\r\n\t\"author\":\"Ahmed\",\r\n\t\"topic\": \"topic\"\r\n}";
		assertEquals(new ObjectMapper().readValue(journal, DocumentWrapper.class).getDocument().getContent(),
				Content.JOURNAL);
	}

	@Test
	public void TestDocumentWrapperNotValidJournal1() throws JsonParseException, JsonMappingException, IOException {
		// not valid Journal
		String journal = "{\r\n\t\"title\":\"mansy\",\r\n\t\"file_id\":23,\r\n\t\"content\":\"BOOK\",\r\n\t\"author\":\"Ahmed\",\r\n\t\"topic\": \"topic\"\r\n}";
		assertNotEquals(new ObjectMapper().readValue(journal, DocumentWrapper.class).getDocument().getContent(),
				Content.JOURNAL);
	}

	@Test(expected = JsonMappingException.class)
	public void TestDocumentWrapperInvalidFormatJournal1()
			throws JsonParseException, JsonMappingException, IOException {
		// invalid Journal
		String journal = "{\r\n\t\"title\":\"mansy\",\r\n\t\"file_id\":23,\r\n\t\"content\":\"JOURNALxxxxxxxx\",\r\n\t\"author\":\"Ahmed\",\r\n\t\"topic\": \"topic\"\r\n}";
		assertEquals(new ObjectMapper().readValue(journal, DocumentWrapper.class).getDocument().getContent(),
				Content.JOURNAL);
	}

	@Test
	public void TestDocumentWrapperValidBook1() throws JsonParseException, JsonMappingException, IOException {
		// valid Journal
		String journal = "{\r\n\t\"title\":\"mansy\",\r\n\t\"file_id\":23,\r\n\t\"content\":\"BOOK\",\r\n\t\"author\":\"Ahmed\",\r\n\t\"topic\": \"topic\"\r\n}";
		assertEquals(new ObjectMapper().readValue(journal, DocumentWrapper.class).getDocument().getContent(),
				Content.BOOK);
	}

	@Test
	public void TestDocumentWrapperNotValidBook1() throws JsonParseException, JsonMappingException, IOException {
		// not valid Journal
		String journal = "{\r\n\t\"title\":\"mansy\",\r\n\t\"file_id\":23,\r\n\t\"content\":\"JOURNAL\",\r\n\t\"author\":\"Ahmed\",\r\n\t\"topic\": \"topic\"\r\n}";
		assertNotEquals(new ObjectMapper().readValue(journal, DocumentWrapper.class).getDocument().getContent(),
				Content.BOOK);
	}

	@Test(expected = JsonMappingException.class)
	public void TestDocumentWrapperInvalidFormatBook1() throws JsonParseException, JsonMappingException, IOException {
		// invalid Journal
		String journal = "{\r\n\t\"title\":\"mansy\",\r\n\t\"file_id\":23,\r\n\t\"content\":\"BOOKxxxxxxxx\",\r\n\t\"author\":\"Ahmed\",\r\n\t\"topic\": \"topic\"\r\n}";
		assertEquals(new ObjectMapper().readValue(journal, DocumentWrapper.class).getDocument().getContent(),
				Content.BOOK);
	}

}

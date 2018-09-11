# async-service-watermarking
asynchronous restful service for watermarking documents
Readme:
This application is built using [resteasy-spring-boot-paypal](https://github.com/paypal/resteasy-spring-boot). It is an example of asynchronous restful service for watermarking documents.


Assumptions:
- All data to be in memory.
- Every watermarking process is an asynchronous task running in the background.
- polling for task status (finished - pending .......)

How to run: 
- Application.java file from IDE.
- Or run this command

```
java -jar target/watermark-0.0.1-SNAPSHOT.jar

```


Usage examples:

	EX:

```
	Request: (POST) /watermark/watermarks/document
		{
			"title":"mansy",
			"file_id":23,
			"content":"BOOK",
			"author":"Ahmed",
			"topic": "topic"
		}

```

```
	Response:
		{
		  "document_id": 93,
		  "asunc_task_id": 817
		}

```

Contains:
- Sample API Documentations with examples (doc).
- eclipse project
- jar file (target/watermark-0.0.1-SNAPSHOT.jar)
- Some junit tescases

Future work:
	- Integerating Jwt token for Tickets

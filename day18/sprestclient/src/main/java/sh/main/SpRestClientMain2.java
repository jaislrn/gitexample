package sh.main;

import java.util.Set;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import sh.config.AppConfig;
import sh.entities.Book;

public class SpRestClientMain2 {
	public static final String BOOKS_URL1 = "http://localhost:8080/spshoprest/jtable/books";
	public static final String BOOKS_URL2 = "http://localhost:8080/spshoprest/rest/books";
	
	public static void main(String[] args) throws Exception {
		AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
	 	RestTemplate restTemplate = ctx.getBean(RestTemplate.class);

//	 	Set<HttpMethod> options = restTemplate.optionsForAllow(BOOKS_URL2);
//	 	System.out.println("Supported methods: " + options);
//	 	options = restTemplate.optionsForAllow(BOOKS_URL2+"/{id}", 11);
//	 	System.out.println("Supported methods: " + options);
	 	
//	 	Book nb = new Book(0, "Yugandhar", "Shivaji", "Novell", 734.34);
//	 	ResponseEntity<String> en = restTemplate.postForEntity(BOOKS_URL2+".json", nb, String.class);
//	 	System.out.println("Resp: " + en.getBody());
	 	
//	 	Book b = restTemplate.getForObject(BOOKS_URL2 + "/{id}", Book.class, 11);
//	 	System.out.println("Found: " + b);
//	 	
//	 	ResponseEntity<Book> resp = restTemplate.getForEntity(BOOKS_URL2 + "/{id}", Book.class, 11);
//	 	if(resp.getStatusCode() == HttpStatus.OK)
//	 		System.out.println("Success: " + resp.getBody());
//	 	else
//	 		System.out.println("Error: " + resp.getStatusCode());
	 	
	 	String json = restTemplate.getForObject(BOOKS_URL2 + "/{id}.json", String.class, 11);
	 	System.out.println("Found: " + json);
	 
	 	/*
	 	Book b = null;
	 	ObjectMapper objMapper = new ObjectMapper();
	 	try {
	 		b = objMapper.readValue(json, Book.class);
	 		System.out.println("Done 2: " + b);
	 	} catch (Exception e) {
			JsonNode node = objMapper.readTree(json);
			if(node.get("Result").asText().equalsIgnoreCase("OK")) {
				b = objMapper.treeToValue(node.get("Record"), Book.class);
				System.out.println("Done 1: " + b);
			} else {
				System.out.println("Error 1: " + node.get("Message").asText());
			}
		}
		*/

	 	/*
	 	Book b = null;
	 	ObjectMapper objMapper = new ObjectMapper();
	 	JsonNode node = objMapper.readTree(json);
	 	if(node.has("Error"))
	 		System.out.println("Error from JTable service: " + node.get("Message").asText());
	 	else if(node.has("Record")) {
	 		b = objMapper.treeToValue(node.get("Record"), Book.class);
			System.out.println("Record from jTable service: " + b);
	 	} else {
	 		b = objMapper.treeToValue(node, Book.class);
			System.out.println("Record from rest service: " + b);
	 	}
	 	*/
	
	 	// reactive programming pattern
	 	WebClient client = WebClient.create(BOOKS_URL2);
	 	Book b = client.get()
	 		.uri(ub -> ub.pathSegment("{id}").build(11))
	 		.header(HttpHeaders.CONTENT_TYPE, "application/json")
	 		.retrieve()
	 		.toEntity(Book.class)
	 		.block() // sync call
	 		.getBody();
	 	System.out.println("Found: " + b);
	}
}

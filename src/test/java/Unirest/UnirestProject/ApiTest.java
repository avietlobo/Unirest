package Unirest.UnirestProject;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ApiTest {
	
	@Test
	public void shouldReturnStatusOkay() throws UnirestException, IOException {
		String url="http://www.mocky.io/v2/5a9ce37b3100004f00ab5154";
		HttpResponse<JsonNode> jsonResponse=Unirest.get(url)
		.header("accept", "application/json")
		.queryString("apiKey", "123")
		.asJson();
		
		System.out.println("Headers => "+jsonResponse.getHeaders());
		System.out.println("Body => "+jsonResponse.getBody());
		System.out.println("Status text => "+jsonResponse.getStatusText());
		
		//Convert InputStream to String
		InputStream inputStream=jsonResponse.getRawBody();
		String string = IOUtils.toString(inputStream, StandardCharsets.UTF_8); 
		System.out.println("InputStream converted => "+string);
		
		JSONObject jsonObject=jsonResponse.getBody().getObject();
		String value=jsonObject.getString("hello");
		System.out.println("Displaying value using JsonObject =>"+value);
		
		Gson gson=new Gson();
		String responseJSONString = jsonResponse.getBody().toString();
		Pojo myObject = gson.fromJson(responseJSONString, Pojo.class);
		System.out.println("GSON "+myObject.getHello());
		
		//Assertions
		assertNotNull(jsonResponse.getBody());
		assertEquals(jsonResponse.getStatus(), 200);
		
		
	}
	
	@Test
	public void shouldReturnStatusAccepted() throws UnirestException {
	    Map<String, String> headers = new HashMap<>();
	    headers.put("accept", "application/json");
	    headers.put("Authorization", "Bearer 5a9ce37b3100004f00ab5154");

	    Map<String, Object> fields = new HashMap<>();
	    fields.put("name", "Sam Baeldung");
	    fields.put("id", "PSP123");

	    HttpResponse<JsonNode> jsonResponse 
	      = Unirest.put("http://www.mocky.io/v2/5a9ce7853100002a00ab515e")
	      .headers(headers).fields(fields)
	      .asJson();
	 
	    assertNotNull(jsonResponse.getBody().toString());
	    assertEquals(202, jsonResponse.getStatus());
	}

}

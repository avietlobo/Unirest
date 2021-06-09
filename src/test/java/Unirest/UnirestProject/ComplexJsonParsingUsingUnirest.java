package Unirest.UnirestProject;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ComplexJsonParsingUsingUnirest {
	
	String reponse="{\r\n"
			+ "    \"data\": {\r\n"
			+ "        \"id\": 2,\r\n"
			+ "        \"email\": \"janet.weaver@reqres.in\",\r\n"
			+ "        \"first_name\": \"Janet\",\r\n"
			+ "        \"last_name\": \"Weaver\",\r\n"
			+ "        \"avatar\": \"https://reqres.in/img/faces/2-image.jpg\"\r\n"
			+ "    },\r\n"
			+ "    \"support\": {\r\n"
			+ "        \"url\": \"https://reqres.in/#support-heading\",\r\n"
			+ "        \"text\": \"To keep ReqRes free, contributions towards server costs are appreciated!\"\r\n"
			+ "    }\r\n"
			+ "}";
	
	
	static {
        Unirest.setTimeouts(1000, 5000);

        Unirest.setObjectMapper(new ObjectMapper() {
            private Gson gson = new GsonBuilder().disableHtmlEscaping()
                    .create();

            @Override
            public <T> T readValue(String value, Class<T> valueType) {
                return gson.fromJson(value, valueType);
            }

            @Override
            public String writeValue(Object value) {
                return gson.toJson(value);
            }
        });
    }
	
	
	@Test
	public void shouldReturnStatusOkay() throws UnirestException, IOException {
		String url="https://reqres.in/api/users/2";
		HttpResponse<Root> jsonResponse=Unirest.get(url)
				.header("accept", "application/json")
				.queryString("apiKey", "123")
				.asObject(Root.class);
		
		
		
		System.out.println(jsonResponse.getBody().getData().getId());
		
		System.out.println();
	

}
}

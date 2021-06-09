package Unirest.UnirestProject;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;

public class ComplexjsonParsingUsingJObject {
	
	String reponse="{\r\n"
			+ "  \"success\": \"1\",\r\n"
			+ "  \"error_number\": \"\",\r\n"
			+ "  \"error_message\": \"\",\r\n"
			+ "  \"results\": [\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"name1\",\r\n"
			+ "      \"formatedName\": \"Name 1\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"testtesttest\",\r\n"
			+ "      \"formatedName\": \"Test Test Test\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"nametest2\",\r\n"
			+ "      \"formatedName\": \"Name Test 2\"\r\n"
			+ "    },\r\n"
			+ "    {\r\n"
			+ "      \"name\": \"nametest3\",\r\n"
			+ "      \"formatedName\": \"Name Test 3\"\r\n"
			+ "    }\r\n"
			+ "  ]\r\n"
			+ "}";
	
	@Test
	public void test() throws UnirestException {
		HttpResponse<JsonNode> request = Unirest.get("URL").header("X-Mashape Authorization", "").asJson();
		JSONObject responsejson = request.getBody().getObject();
		JSONArray results = responsejson.getJSONArray("results");
	}

}

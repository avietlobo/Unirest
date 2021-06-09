package Unirest.UnirestProject;

import org.junit.jupiter.api.Test;

import com.google.gson.Gson;

//Converting complex JSON using Gson

public class ComplexJsonParsing {
	
	String response="{ \r\n"
			+ "  \"accounting\" : [   \r\n"
			+ "                     { \"firstName\" : \"John\",  \r\n"
			+ "                       \"lastName\"  : \"Doe\",\r\n"
			+ "                       \"age\"       : 23 },\r\n"
			+ "\r\n"
			+ "                     { \"firstName\" : \"Mary\",  \r\n"
			+ "                       \"lastName\"  : \"Smith\",\r\n"
			+ "                        \"age\"      : 32 }\r\n"
			+ "                 ],                            \r\n"
			+ "  \"sales\"      : [ \r\n"
			+ "                     { \"firstName\" : \"Sally\", \r\n"
			+ "                       \"lastName\"  : \"Green\",\r\n"
			+ "                        \"age\"      : 27 },\r\n"
			+ "\r\n"
			+ "                     { \"firstName\" : \"Jim\",   \r\n"
			+ "                       \"lastName\"  : \"Galley\",\r\n"
			+ "                       \"age\"       : 41 }\r\n"
			+ "                 ] \r\n"
			+ "} ";
	
	
	
	@Test
	public void complexResponseParsing() {
		Gson gson=new Gson();
		ComplexPojo pojo = gson.fromJson(response, ComplexPojo.class);
		for(Accounting accounting:pojo.getAccounting()) {
			System.out.println(accounting.getFirstName());
			System.out.println(accounting.getLastName());
			System.out.println(accounting.getAge());
			System.out.println();
		}
	}

}

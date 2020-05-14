package com.sellerms;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class SellerApplicationTests {
	 @Autowired
	    private TestRestTemplate testRestTemplate;
	
    @Test
    public void getRequestAsreport() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/report/{123456}", String.class, 1);
        System.err.println(entity.getBody());
    }
    
    
	
    @Test
    public void getRequestAstock() {
        ResponseEntity<String> entity = testRestTemplate.getForEntity("/stock", String.class, 1);
        System.err.println(entity.getBody());
    }
    
	
	@Test
	public void postAsUpdatestock() {
        String jsonStr = "{\"itemid\":123456,\"password\":\"111111\",\"email\":\"Joshua Bloch@111\",\"Mobile\":11123339.0}";
        HttpHeaders headers = new HttpHeaders();

        //设置contentType
        headers.setContentType(MediaType.valueOf("application/json;UTF-8"));

        HttpEntity<String> entity = new HttpEntity<String>(jsonStr,headers);
        String result = testRestTemplate.postForObject("/updatestock", entity, String.class);
        System.err.println(result);
	}
}

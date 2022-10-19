package com.openbootcamp.demojpa;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.openbootcamp.demojpa.models.Laptop;
import com.openbootcamp.demojpa.service.LaptopPriceCalculator;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemojpaApplicationTests {

    private TestRestTemplate testRestTemplate;
	
    @Autowired
    private RestTemplateBuilder restTemplateBuilder;
    
    @LocalServerPort
    private int port;
	

	@BeforeEach
	void setup() {
		restTemplateBuilder=restTemplateBuilder.rootUri("http://localhost:"+ port);
		testRestTemplate=new TestRestTemplate(restTemplateBuilder);
	}
	

	  @Test
	    void calculatePriceTest() {
		  
				Laptop laptop= new Laptop(1L,"Hp","Intel core i5",8,899.90,true);
				LaptopPriceCalculator calculate=new LaptopPriceCalculator();
				double price=calculate.calculatePrice(laptop);
				System.out.println(price);
				assertTrue(price==907.89);
				
			}
	@Test
	void hello() {
		ResponseEntity<String> response=testRestTemplate.getForEntity("/hola",String.class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		assertEquals("Hola Mundo que tal vamos", response.getBody());
	}
	
	@Test
	void findAll() {
		ResponseEntity<Laptop[]> response=testRestTemplate.getForEntity("/api/laptops",Laptop[].class);
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(200, response.getStatusCodeValue());
		
		
	}
  @Test
  void finById() {
	   ResponseEntity<Laptop> response=testRestTemplate.getForEntity("/api/laptops/1",Laptop.class);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
		assertEquals(404, response.getStatusCodeValue());
  }
 @Test
  void create() {
	   HttpHeaders headers= new HttpHeaders();
	   headers.setContentType(MediaType.APPLICATION_JSON);
	   headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));	   
	   String json= """  
		   {
				   "marca":"huawei",
				   "procesador":"intel core i7",
				   "memoriaRam":"16",
				   "price":849.90,
				   "conexionBluetooth":"true"

				   }
	   		""";
  
    HttpEntity<String> request= new HttpEntity<>(json,headers);
    ResponseEntity<Laptop> response=testRestTemplate.exchange("/api/laptops",HttpMethod.GET, request,Laptop.class);
    Laptop result=response.getBody();
    assertEquals(HttpStatus.OK, response.getStatusCode());
	assertEquals(200, response.getStatusCodeValue());
  
} 

}

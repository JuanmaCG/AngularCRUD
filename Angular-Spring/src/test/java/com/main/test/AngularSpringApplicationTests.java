package com.main.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.annotation.Order;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.main.AngularSpringApplication;
import com.main.entity.Alumno;

//@RunWith(SpringRunner.class)
//@SpringBootTest(
////		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT,
////		classes = AngularSpringApplication.class
//)
//@AutoConfigureMockMvc
//@TestPropertySource(locations = "classpath:application.properties")
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AngularSpringApplicationTests {
	
//	 	@Autowired
//	    MockMvc mvc;
//	 	
//	 	
//	 	
//		@Test
//		@Ignore 
//		public void getAlumnosTest() throws Exception {
//			mvc.perform(MockMvcRequestBuilders
//					.get("/alumno")
//					.accept(MediaType.APPLICATION_JSON))
//					.andDo(print())
//					.andExpect(status().isOk())
//					.andExpect(MockMvcResultMatchers.jsonPath("$").exists())
//					.andExpect(MockMvcResultMatchers.jsonPath("$.[*].dni").isNotEmpty());
//					
//		}
//		
//		@Test
//		@Ignore
//		@Before
//		public void createAlumnoTest() throws Exception {
//		  mvc.perform( MockMvcRequestBuilders
//		      .post("/alumno")
//		      .content(asJsonString(new Alumno("idpeep", "lmao")))
//		      .contentType(MediaType.APPLICATION_JSON)
//		      .accept(MediaType.APPLICATION_JSON))
//		      .andExpect(status().isOk())
//		      .andExpect(MockMvcResultMatchers.jsonPath("$").exists());
//		}
//		
//		@Test
//		@Ignore
//		public void getAlumnoByDniTest() throws Exception {
//			mvc.perform(MockMvcRequestBuilders
//					.get("/alumno/{dni}", "lmao")
//					.accept(MediaType.APPLICATION_JSON))
//					.andDo(print())
//					.andExpect(status().isOk())
//					.andExpect(MockMvcResultMatchers.jsonPath("$.dni").value("lmao"));
//		}
//		
//		
//		
//		 
//		public static String asJsonString(final Object obj) {
//		    try {
//		        return new ObjectMapper().writeValueAsString(obj);
//		    } catch (Exception e) {
//		        throw new RuntimeException(e);
//		    }
//		}
//		
//		@Test
//		@Ignore
//
//		public void updateEmployeeAPI() throws Exception {
//		  mvc.perform( MockMvcRequestBuilders
//		      .put("/alumno/{dni}", "lmao")
//		      .content(asJsonString(new Alumno("PPPPPP", "lmao")))
//		      .contentType(MediaType.APPLICATION_JSON)
//		      .accept(MediaType.APPLICATION_JSON))
//		      .andExpect(status().isOk())
//		      .andExpect(MockMvcResultMatchers.jsonPath("$.idalumno").value("PPPPPP"))
//		      .andExpect(MockMvcResultMatchers.jsonPath("$.dni").value("lmao"));
//		}
//
//		
//		@Test
//		@Ignore
//		public void deleteEmployeeAPI() throws Exception {
//		  mvc.perform( MockMvcRequestBuilders.delete("/alumno/{dni}", "lmao") )
//		        .andExpect(status().isOk());
//		}
//		
		
		@Test
		public void d_seleniumDeleteTest() {
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:4200/#/listaPersona");
			

			driver.findElement(By.id("deletetest1")).sendKeys(Keys.ENTER);
			
			
		}
		
		@Test
		public void c_datos_atras_test() {
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:4200/#/listaPersona");
			
			driver.findElement(By.id("datostest1")).click();
			driver.findElement(By.id("atras")).click();
		}
		
		@Test
		public void a_crear_persona_test() {
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:4200/#/listaPersona");
			
			driver.findElement(By.id("creapersona")).click();
			driver.findElement(By.id("dni")).sendKeys("test1");
			driver.findElement(By.id("nombre")).sendKeys("test1");
			driver.findElement(By.id("apellido")).sendKeys("test1");
			driver.findElement(By.id("submit")).click();
			
			driver.findElement(By.id("listaPersona")).click();
			
		}
		
		@Test
		public void b_actualiza_persona_test() {
			WebDriver driver = new ChromeDriver();
			driver.get("http://localhost:4200/#/listaPersona");
			
			driver.findElement(By.id("datostest1")).click();
			
			driver.findElement(By.name("nombre")).clear();
			driver.findElement(By.name("nombre")).sendKeys("Juanmasooo");
			
			driver.findElement(By.name("apellido")).clear();
			driver.findElement(By.name("apellido")).sendKeys("Mordor");
			
			driver.findElement(By.id("actualizar")).click();
			driver.findElement(By.id("listaPersona")).click();
		}
		
		
		
		
		
		
}

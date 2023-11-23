package com.aa37.appsdeveloperblog.app.ws;

import java.nio.charset.Charset;

import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.aa37.appsdeveloperblog.app.ws.controller.UserController;
import com.aa37.appsdeveloperblog.app.ws.repository.UserRepository;

@RunWith(SpringRunner.class)
@WebMvcTest
@AutoConfigureMockMvc
public class UserControllerIntegrationTest {
	
	@MockBean
	private UserRepository userRepository;
	
	@Autowired
	UserController userController;
	
	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void whenPostRequestToUserAndValidUser_thenCorrectResponse() throws Exception {
		MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN,Charset.forName("UTF-8"));
		String user = "{\r\n"
				+ "    \"firstName\" : \"amit\",\r\n"
				+ "    \"lastName\" : \"pruthi\",\r\n"
				+ "    \"email\" : \"amitpru24@gmail.com\",\r\n"
				+ "    \"password\": \"Baba@1801\"\r\n"
				+ "}";
		mockMvc.perform(MockMvcRequestBuilders.post("/users)")
				.content(user)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.content()
						.contentType(textPlainUtf8));
	}
	
	@Test
	public void whenPostRequestToUserAndInValidUser_thenCorrectResponse() throws Exception {
		MediaType textPlainUtf8 = new MediaType(MediaType.TEXT_PLAIN,Charset.forName("UTF-8"));
		String user = "{\r\n"
				+ "    \"firstName\" : \"\",\r\n"
				+ "    \"lastName\" : \"pruthi\",\r\n"
				+ "    \"email\" : \"amitpru24@gmail.com\",\r\n"
				+ "    \"password\": \"Baba@1801\"\r\n"
				+ "}";
		mockMvc.perform(MockMvcRequestBuilders.post("/users)")
				.content(user)
				.contentType(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.status().isBadRequest())
				.andExpect(MockMvcResultMatchers.jsonPath("$.name", Is.is("Name is mandatory")))
				.andExpect(MockMvcResultMatchers.content()
						.contentType(MediaType.APPLICATION_JSON_UTF8));
	}

}

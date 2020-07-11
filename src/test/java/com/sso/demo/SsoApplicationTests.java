package com.sso.demo;

import com.sso.demo.controller.AuthController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
class SsoApplicationTests {

	@Autowired
	AuthController authController;

	@Test
	void contextLoads() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(authController)
				.build();
		MvcResult result = mockMvc.perform(get("/test").contentType(MediaType.APPLICATION_JSON).header("Authorization", "bearer dummyToken"))
				.andReturn();

		System.out.println(result.getResponse().getContentAsString());
	}

}

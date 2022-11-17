package com.au.asx.user.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;

import org.json.JSONException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.au.asx.user.Application;
import com.au.asx.user.exception.ExceptionAdvice;
import com.au.asx.user.model.UserDetailRequest;
import com.au.asx.user.service.UserService;
import com.fasterxml.jackson.databind.ObjectMapper;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserDetailsApiControllerIntegrationTest {
	
	@LocalServerPort
    private int port;

    TestRestTemplate restTemplate = new TestRestTemplate();

    HttpHeaders headers = new HttpHeaders();
    
    @Test
    public void testRetrieveStudentCourse() throws JSONException {

        HttpEntity<String> entity = new HttpEntity<>(null, headers);

        ResponseEntity<String> response = restTemplate.exchange(
                createURLWithPort("/userDetails/1"),
                HttpMethod.GET, entity, String.class);

        String expected = "{\"userId\":1,\"title\":\"MR\",\"firstName\":\"JOE\", \"lastName\":\"DON\", \"gender\":\"MALE\"}";

        JSONAssert.assertEquals(expected, response.getBody(), false);
    }

    private String createURLWithPort(String uri) {
        return "http://localhost:" + port + uri;
    }
	
    @Test
	public void updateUser() {

    	UserDetailRequest userDetailRequest = new UserDetailRequest();
    	userDetailRequest.setFirstName("raj");
    	userDetailRequest.setLastName("romm");

		HttpEntity<UserDetailRequest> entity = new HttpEntity<UserDetailRequest>(userDetailRequest, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/userDetails/2"),
				HttpMethod.POST, entity, String.class);

		boolean actual = response.getStatusCode().is2xxSuccessful();

		assertEquals(true, actual);

	}

}

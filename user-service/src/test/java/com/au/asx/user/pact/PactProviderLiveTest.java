package com.au.asx.user.pact;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestTemplate;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.web.context.ConfigurableWebApplicationContext;

import com.au.asx.user.Application;

import au.com.dius.pact.provider.junit.Provider;
import au.com.dius.pact.provider.junit.State;
import au.com.dius.pact.provider.junit.loader.PactFolder;
import au.com.dius.pact.provider.junit5.HttpTestTarget;
import au.com.dius.pact.provider.junit5.PactVerificationContext;
import au.com.dius.pact.provider.junit5.PactVerificationInvocationContextProvider;

@Provider("userservice_provider")
@PactFolder("target/pacts")
public class PactProviderLiveTest {
	
	private static ConfigurableWebApplicationContext application;

	@TestTemplate
	@ExtendWith(PactVerificationInvocationContextProvider.class)
	void pactVerificationTestTemplate(PactVerificationContext context) {
	    context.verifyInteraction();
	}

	@BeforeAll
	public static void start() {
	    application = (ConfigurableWebApplicationContext) SpringApplication.run(Application.class);
	}

	@BeforeEach
	void before(PactVerificationContext context) {
	    context.setTarget(new HttpTestTarget("localhost", 8000, ""));
	}
	
	@State("test GET")
	public void toGetState() { }

	@State("test POST")
	public void toPostState() { }
}
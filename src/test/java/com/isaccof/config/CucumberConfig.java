package com.isaccof.config;

import com.isaccof.DemoOpenApiSwaggerUiCodegenApplication;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpHeaders;
import org.springframework.test.context.ContextConfiguration;

@ContextConfiguration
@SpringBootTest(classes = DemoOpenApiSwaggerUiCodegenApplication.class, webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class CucumberConfig {

    @Autowired
    public TestRestTemplate testRestTemplate;

    @LocalServerPort
    public static final String PORT = "8084";

    public String staticURL = "http://localhost:";

    public HttpHeaders httpHeaders;

    @Before
    public void setUp() throws Exception {
        httpHeaders = new HttpHeaders();
    }
}

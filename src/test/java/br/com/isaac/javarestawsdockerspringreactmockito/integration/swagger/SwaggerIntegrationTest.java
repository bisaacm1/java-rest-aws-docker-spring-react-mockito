package br.com.isaac.javarestawsdockerspringreactmockito.integration.swagger;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import br.com.isaac.javarestawsdockerspringreactmockito.integration.AbstractIntegrationTest;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SwaggerIntegrationTest extends AbstractIntegrationTest {

	@Autowired
	private TestRestTemplate restTemplate;

	@DynamicPropertySource
	static void registerProperties(DynamicPropertyRegistry registry) {
		registry.add("server.port", () -> "0");
	}

	@Test
	public void shouldDisplaySwaggerUiPage() {
		var content = this.restTemplate.getForObject("/swagger-ui/index.html", String.class);
		assertTrue(content.contains("Swagger UI"));
	}
}

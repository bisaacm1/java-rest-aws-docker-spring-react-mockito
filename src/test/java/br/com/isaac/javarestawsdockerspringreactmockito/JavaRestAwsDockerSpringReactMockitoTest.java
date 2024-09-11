package br.com.isaac.javarestawsdockerspringreactmockito;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class JavaRestAwsDockerSpringReactMockitoTest {

	@InjectMocks
	private JavaRestAwsDockerSpringReactMockito application;

	@BeforeEach
	void setUp() {
		application = new JavaRestAwsDockerSpringReactMockito();
	}

	@Test
	void testApplicationContext() {
		assertNotNull(application);
	}
}

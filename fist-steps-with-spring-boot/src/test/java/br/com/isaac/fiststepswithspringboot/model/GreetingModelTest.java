package br.com.isaac.fiststepswithspringboot.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GreetingModelTest {

    @Test
    public void testGreetingModelConstructorAndGetters() {
        // Arrange
        long id = 1L;
        String content = "Hello";

        // Act
        GreetingModel greeting = new GreetingModel(id, content);

        // Assert
        Assertions.assertEquals(id, greeting.getId());
        Assertions.assertEquals(content, greeting.getContent());
    }
}

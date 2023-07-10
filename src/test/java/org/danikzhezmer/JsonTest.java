package org.danikzhezmer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.danikzhezmer.model.Book;
import org.junit.jupiter.api.Test;

public class JsonTest {

    @Test
    public void ObjectToJsonTest() throws JsonProcessingException {
        Book book = new Book("Harry Potter", "J. K. Rowling");
        ObjectMapper objectMapper = new ObjectMapper();
        String json = objectMapper.writeValueAsString(book);
        System.out.println(json);
    }

    @Test
    public void JsonToObjectTest() throws JsonProcessingException {
        String json = "{\"title\":\"Harry Potter\",\"author\":\"J. K. Rowling\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Book book = objectMapper.readValue(json, Book.class);
        System.out.println(book);
    }
}

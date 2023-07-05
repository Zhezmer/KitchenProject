package org.danikzhezmer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ValidatorTest {
    Validator validator = new Validator();

    @Test
    void validateGetFailsTest() {
        Exception ex = assertThrows(IllegalArgumentException.class, () -> validator.validate("get twenty"));
        assertEquals("id is not integer", ex.getMessage());
    }

    @Test
    void validateGetByIdTest() {
        assertDoesNotThrow(() -> validator.validate("get 23"));
    }

    @Test
    void validateGetAllTest() {
        assertDoesNotThrow(() -> validator.validate("get"));
    }

    @Test
    void validateDeleteTest(){
        assertDoesNotThrow(() -> validator.validate("delete 2"));
    }
    @Test
    void validateDeleteFailTest(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> validator.validate("delete twenty"));
        assertEquals("id is not integer", ex.getMessage());
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> validator.validate("delete"));
        assertEquals("wrong size", ex1.getMessage());
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> validator.validate("delet 2"));
        assertEquals("wrong command", ex2.getMessage());

    }
    @Test
    void validateUpdateTest(){
        assertDoesNotThrow(() -> validator.validate("update 2 frog"));
    }
    @Test
    void validateUpdateFailTest(){
        Exception ex = assertThrows(IllegalArgumentException.class, () -> validator.validate("update twenty values"));
        assertEquals("id is not integer", ex.getMessage());
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> validator.validate("update"));
        assertEquals("wrong size", ex1.getMessage());
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> validator.validate("upDate 2 frog"));
        assertEquals("wrong command", ex2.getMessage());

    }
    @Test
    void validateCreateTest(){
        assertDoesNotThrow(() -> validator.validate("create frog"));
    }
    @Test
    void validateCreateFailTest(){
        Exception ex1 = assertThrows(IllegalArgumentException.class, () -> validator.validate("create"));
        assertEquals("wrong size", ex1.getMessage());
        Exception ex2 = assertThrows(IllegalArgumentException.class, () -> validator.validate("Kreate frog"));
        assertEquals("wrong command", ex2.getMessage());

    }
}

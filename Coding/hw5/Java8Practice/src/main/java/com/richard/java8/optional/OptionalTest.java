package com.richard.java8.optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

/**
 * @Author zhuhaotian
 * @Date 2023/4/15
 */

public class OptionalTest {

    @Test
    public void testOf() {
        String value = "Hello, Optional!";

        Optional<String> optional = Optional.of(value);
        assertTrue(optional.isPresent());
        assertEquals(value, optional.get());
    }

    @Test
    public void testOfNullable() {
        String val = null;

        Optional<String> optional = Optional.ofNullable(val);
        assertFalse(optional.isPresent());
    }

    @Test
    public void testEmpty() {
        Optional<String> optional = Optional.empty();
        assertFalse(optional.isPresent());
    }

    @Test
    public void testIfPresent() {
        String value = "val";

        Optional<String> optional = Optional.ofNullable(value);
        assertTrue(optional.isPresent());
    }

    @Test
    public void testOrElse() {
        Optional<String> optional = Optional.empty();

        String res = optional.orElse("Default");
        assertEquals("Default", res);
    }

    @Test
    public void testOrElseGet() {
        Optional<String> optional = Optional.empty();

        String res = optional.orElseGet(() -> "Default");
        assertEquals("Default", res);
    }

    @Test
    public void testOrElseThrow() {
        Optional<String> optional = Optional.empty();

        assertThrows(NoSuchElementException.class, optional::orElseThrow);
    }

    @Test
    public void testFilter() {
        Optional<Integer> optional = Optional.of(42);
        Optional<Integer> filtered = optional.filter(value -> value % 2 == 0);
        assertTrue(filtered.isPresent());
        assertEquals(Optional.of(42), filtered);

        filtered = optional.filter(value -> value % 2 != 0);
        assertFalse(filtered.isPresent());
    }

    @Test
    public void testMap() {
        Optional<String> optional = Optional.of("Hello Optional!");
        Optional<Integer> mapped = optional.map(String::length);
        assertTrue(mapped.isPresent());
        assertEquals(Optional.of(15), mapped);
    }

}

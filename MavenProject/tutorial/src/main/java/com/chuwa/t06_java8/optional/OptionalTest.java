package com.chuwa.t06_java8.optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;

public class OptionalTest {
    @Test
    public void testOf() {
        String value = "hello";
        Optional<String> optional = Optional.of(value);
        assertTrue(optional.isPresent());
        assertEquals(value, optional.get());
    }

    @Test
    public void testOfNullable() {
        String value = null;
        Optional<String> optional = Optional.ofNullable(value);
        assertFalse(optional.isPresent());
    }

    @Test
    public void testEmpty() {
        Optional<String> optional = Optional.empty();
        assertFalse(optional.isPresent());
    }

    @Test
    public void testIfPresent() {
        Optional<String> optional = Optional.of("Hello, Optional!");
        optional.ifPresent(value -> assertEquals("Hello, Optional!", value));
    }

    @Test
    public void testOrElse() {
        Optional<String> optional = Optional.empty();
        String result = optional.orElse("Default");
        assertEquals("Default", result);
    }

    @Test(expected = NoSuchElementException.class)
    public void testOrElseThrow() {
        Optional<String> optional = Optional.empty();
        String value = optional.orElseThrow(NoSuchElementException::new);
    }

    @Test
    public void testFilter() {
        Optional<Integer> optional = Optional.of(42);
        Optional<Integer> filtered = optional.filter(value -> value % 2 == 0);
        assertTrue(filtered.isPresent());
        assertEquals(42, filtered.get().intValue());
        filtered = optional.filter(value -> value % 2 != 0);
        assertFalse(filtered.isPresent());
    }

    @Test
    public void testMap() {
        Optional<String> optional = Optional.of("12345");
        Optional<Integer> mapped = optional.map(String::length);
        assertTrue(mapped.isPresent());
        assertEquals(5, mapped.get().intValue());
    }


    @Test
    public void testFlatMap() {
        Optional<String> optional = Optional.of("abcde");
        Optional<Integer> flatMapped = optional.flatMap(value -> Optional.of(value.length()));
        assertTrue(flatMapped.isPresent());
        assertEquals(5, flatMapped.get().intValue());
    }
}

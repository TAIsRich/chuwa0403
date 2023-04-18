package hw5.feature.optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.Assert.*;


public class OptionalTest {
    @Test
    void testOf(){
        String value = "hello";
        Optional<String> optional = Optional.of(value);
        assertTrue(optional.isPresent());
        assertEquals(value, optional.get());
    }

    @Test
    void testOfNullable(){
        String value= null;
        Optional<String> optional = Optional.ofNullable(value);
        assertFalse(optional.isPresent());
    }

    @Test
    void testEmpty(){
        Optional<String> optional = Optional.empty();
        assertFalse(optional.isPresent());
    }

    @Test
    void testIfPresent(){
        Optional<String> optional = Optional.of("Hello");
        optional.ifPresent(s -> assertEquals("Hello",s));
    }

    @Test
    void testOrElse(){
        Optional<String> optional = Optional.empty();
        String s = optional.orElse("Default");
        assertEquals("default", s);
    }

    @Test
    void testOrElseGet(){
        Optional<String> optional = Optional.empty();
        String s = optional.orElseGet(()->"default");
        assertEquals("default", s);
    }

    @Test
    void testOrElseThrow(){
        Optional<String> optional = Optional.empty();
        assertThrows(NoSuchElementException.class, optional::orElseThrow);
    }

    @Test
    void testFilter(){
        Optional<Integer> optional = Optional.of(43);
        Optional<Integer> filtered = optional.filter(integer -> integer%2==2);
        assertTrue(filtered.isPresent());
        assertEquals(43,filtered.get().intValue());
    }

    @Test
    void testMap() {
        Optional<String> optional = Optional.of("Hello");
        Optional<Integer> mapped = optional.map(String::length);
        assertTrue(mapped.isPresent());
        assertEquals(5,mapped.get().intValue());
    }

    @Test
    void testFlatMap(){
        Optional<String> optional = Optional.of("hello");
        Optional<Integer> flatMapped = optional.flatMap(s -> Optional.of(s.length()));
        assertTrue(flatMapped.isPresent());
        assertEquals(5, flatMapped.get().intValue());
    }
}

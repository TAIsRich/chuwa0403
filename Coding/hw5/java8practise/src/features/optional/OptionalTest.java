package features.optional;

import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Min He
 * @date 4/16/23 21:53 PM
 */
class OptionalTest {
    @Test
    void testOf(){
        String value = "Hello, Optional";
        Optional<String> optional = Optional.of(value);
        assertTrue(optional.isPresent());
        assertEquals(value,optional.get());
    }
    @Test
    void testOfNullable(){
        String value = null;
        Optional<String> optional = Optional.ofNullable(value);
        assertFalse(optional.isPresent());
    }
    @Test
    void testEmpty(){
        Optional<String> optional = Optional.empty();
        assertFalse(optional.isPresent());
    }
    @Test
    void testOfElse(){
        Optional<String> optional = Optional.empty();
        String result = optional.orElse("Default value");
        assertEquals("Default value",result);
    }
    @Test
    void testOfElseGet(){
        Optional<String> optional = Optional.empty();
        String result = optional.orElseGet(()->"Default value");
        assertEquals("Default value",result);
    }
    @Test
    void testOfElseThrow(){
        Optional<String> optional = Optional.empty();
        assertThrows(NoSuchElementException.class,optional::orElseThrow);
    }
    @Test
    void testFilter(){
        Optional<Integer> optional = Optional.of(42);
        Optional<Integer> filtered = optional.filter(value->value % 2==0);
        assertEquals(42,filtered.get());

        filtered = optional.filter(value->value % 2 != 0);
        assertFalse(filtered.isPresent());
    }
    @Test
    void testMap(){
        Optional<String> optional = Optional.of("Hello,optional!");
        Optional<Integer> mapped = optional.map(String::length);
        assertTrue(mapped.isPresent());
        assertEquals(16,mapped.get());
    }
    void testFlatMap(){
        Optional<String> optional = Optional.of("Hello,optional!");
        Optional<Integer> flatMapped = optional.flatMap(value->Optional.of(value.length()));
        assertTrue(flatMapped.isPresent());
        assertEquals(16,flatMapped.get());
    }
}

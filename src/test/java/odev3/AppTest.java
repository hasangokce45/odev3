/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package odev3;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

class AppTest {
    @Test void appHasAGreeting() {
        App classUnderTest = new App();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
    @Test public void testFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertTrue(App.searchInteger(array, 4));
    }
    @Test public void testNotFound() {
        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        assertFalse(App.searchInteger(array, 5));
    }
    @Test public void testEmptyArray() {
        ArrayList<Integer> array = new ArrayList<>();
        assertFalse(App.searchInteger(array, 1));
    }
    @Test public void testNull() {
        assertFalse(App.searchInteger(null, 1));
    }
    @Test public void testStrFound() {
        ArrayList<String> array = new ArrayList<>(Arrays.asList("a","b","c","d","string","test"));
        assertTrue(App.searchString(array, "test"));
    }
    @Test public void testStrUpperFound() {
        ArrayList<String> array = new ArrayList<>(Arrays.asList("a","b","c","d","string","Test"));
        assertTrue(App.searchString(array, "tesT"));
    }
    @Test public void testStrNotFound() {
        ArrayList<String> array = new ArrayList<>(Arrays.asList("a","b","c","d","string","test"));
        assertFalse(App.searchString(array, "e"));
    }
    @Test public void testEmptyStrArray() {
        ArrayList<String> array = new ArrayList<>();
        assertFalse(App.searchString(array, "a"));
    }
    @Test public void testStrNull() {
        assertFalse(App.searchString(null, "a"));
    }
    @Test public void testCharFound() {
        ArrayList<Character> array = new ArrayList<>(Arrays.asList('a','b','c','d'));
        assertTrue(App.deleteChar(array, 'a'));
    }
    @Test public void testCharNotFound() {
        ArrayList<Character> array = new ArrayList<>(Arrays.asList('a','b','c','d'));
        assertFalse(App.deleteChar(array, 'e'));
    }
    @Test public void testEmptyCharArray() {
        ArrayList<Character> array = new ArrayList<>();
        assertFalse(App.deleteChar(array, 'a'));
    }
    @Test public void testCharNull() {
        assertFalse(App.deleteChar(null, 'a'));
    }
}

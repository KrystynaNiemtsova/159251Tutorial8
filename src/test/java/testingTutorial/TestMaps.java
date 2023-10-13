package testingTutorial;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TestMaps {
    private HashMap<Lecturer, String> hashMap = null;
    private IdentityHashMap<Lecturer, String> idMap = null;
    private Lecturer lecturer1;
    private Lecturer lecturer2;
    private Lecturer lecturer3;
    private Lecturer lecturer4;
    @Before public void setUp() {
        lecturer1 = new Lecturer(1, "Tim", "McGill");
        lecturer2 = new Lecturer(2, "Tom", "McGill");
        lecturer3 = new Lecturer(2, "Tom", "Heart");
        lecturer4 = new Lecturer(2, "Tom", "McGill");
        hashMap = new HashMap<>();
        hashMap.put(lecturer1, "Timmy");
        hashMap.put(lecturer2, "Jimothan");
        idMap = new IdentityHashMap<>();
        idMap.put(lecturer1, "Timmy");
        idMap.put(lecturer2, "Jimothan");
    }
    @Test
    public void idMapLookup() {
        assertEquals(lecturer2, lecturer3);
        assertNotEquals(lecturer2.hashCode(), lecturer3.hashCode());
        assertEquals(lecturer2, lecturer4);
        assertEquals(lecturer2.hashCode(), lecturer4.hashCode());
        assertEquals("Jimothan", idMap.get(lecturer2));
        assertNotEquals("Jimothan", idMap.get(lecturer3));
        assertEquals("Jimothan", idMap.get(lecturer4));
    }
    @Test
    public void hashMapLookup() {
        assertEquals(lecturer2, lecturer3);
        assertNotEquals(lecturer2.hashCode(), lecturer3.hashCode());
        assertEquals(lecturer2, lecturer4);
        assertEquals(lecturer2.hashCode(), lecturer4.hashCode());
        assertEquals("Jimothan", hashMap.get(lecturer2));
        assertNotEquals("Jimothan", hashMap.get(lecturer3));
        assertEquals("Jimothan", hashMap.get(lecturer4));
    }
}
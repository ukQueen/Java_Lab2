package com.project;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.util.*;

public class MultiValueMapTest {

    private MultiValueMap<String, String> map;

    @Before
    public void setUp() {
        map = new MultiValueMap<>();
    }

    @Test
    public void testPutAndGet() {
        Collection<String> values = new ArrayList<>();
        values.add("Value1");
        values.add("Value2");

        map.put("Key1", values);

        Collection<String> result = map.get("Key1");
        assertNotNull(result);
        assertEquals(2, result.size());
        assertTrue(result.contains("Value1"));
        assertTrue(result.contains("Value2"));
    }

    @Test
    public void testPutMultipleValuesForSameKey() {
        map.put("Key1", new ArrayList<>(Arrays.asList("Value1")));
        map.put("Key1", new ArrayList<>(Arrays.asList("Value2")));

        Collection<String> result = map.get("Key1");

        assertNotNull(result);
        assertEquals(1, result.size());
        assertTrue(result.contains("Value2"));
    }

    @Test
    public void testContainsKey() {
        Collection<String> values = new ArrayList<>();
        values.add("Value1");

        map.put("Key1", values);

        assertTrue(map.containsKey("Key1"));
        assertFalse(map.containsKey("Key2"));
    }

    @Test
    public void testContainsValue() {
        Collection<String> values = new ArrayList<>();
        values.add("Value1");

        map.put("Key1", values);

        assertTrue(map.containsValue("Value1"));
        assertFalse(map.containsValue("Value2"));
    }

    @Test
    public void testRemove() {
        Collection<String> values = new ArrayList<>();
        values.add("Value1");

        map.put("Key1", values);

        Collection<String> removed = map.remove("Key1");

        assertNotNull(removed);
        assertTrue(removed.contains("Value1"));
        assertNull(map.get("Key1"));
    }

    @Test
    public void testSize() {
        Collection<String> values1 = new ArrayList<>();
        values1.add("Value1");

        Collection<String> values2 = new ArrayList<>();
        values2.add("Value2");

        map.put("Key1", values1);
        map.put("Key2", values2);

        assertEquals(2, map.size());
    }

    @Test
    public void testClear() {
        Collection<String> values = new ArrayList<>();
        values.add("Value1");

        map.put("Key1", values);

        map.clear();

        assertTrue(map.isEmpty());
    }

    @Test
    public void testKeySet() {
        Collection<String> values = new ArrayList<>();
        values.add("Value1");

        map.put("Key1", values);
        map.put("Key2", values);

        Set<String> keys = map.keySet();

        assertTrue(keys.contains("Key1"));
        assertTrue(keys.contains("Key2"));
    }

    @Test
    public void testIterator() {
        Collection<String> values = new ArrayList<>();
        values.add("Value1");

        map.put("Key1", values);

        Iterator<String> iterator = map.iterator();

        assertTrue(iterator.hasNext());
        assertEquals("Value1", iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testPutAll() {
        Map<String, Collection<String>> otherMap = new HashMap<>();
        Collection<String> values1 = new ArrayList<>();
        values1.add("Value1");
        otherMap.put("Key1", values1);

        map.putAll(otherMap);

        Collection<String> result = map.get("Key1");
        assertNotNull(result);
        assertTrue(result.contains("Value1"));
    }
}

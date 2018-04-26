package me.nettee.algorithm.search;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.util.*;

public class SimpleBSTTest {

    private static final int N = 10;

    private static Map<Integer, String> map = new HashMap<>();
    private SimpleBST<Integer, String> simpleBST = new SimpleBST<>();

    @BeforeClass
    public static void setupMap() {
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            int k = random.nextInt(100);
            String v = RandomStringUtils.random(3);
            map.put(k, v);
        }
    }

    @Test
    public void testGet() {
        Set<Map.Entry<Integer, String>> entries = map.entrySet();

        int s = 0;
        for (Map.Entry<Integer, String> entry : entries) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            simpleBST.put(key, value);
            s++;
            Assert.assertEquals(s, simpleBST.size());
        }

        for (Map.Entry<Integer, String> entry : entries) {
            Integer key = entry.getKey();
            Assert.assertTrue(simpleBST.contains(key));
            String expected = entry.getValue();
            String v = simpleBST.get(key);
            Assert.assertNotNull(v);
            Assert.assertEquals(expected, v);
        }

        int k;
        Random random = new Random();
        while (true) {
            k = random.nextInt(100);
            if (!map.containsKey(k)) {
                break;
            }
        }

        String v = simpleBST.get(k);
        Assert.assertNull(v);
    }
}

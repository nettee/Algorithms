package me.nettee.algorithm.search;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SimpleBSTTest {

    private static final int N = 10;

    private SimpleBST simpleBST = new SimpleBST();

    @Test
    public void testBST() {
        Map<Integer, Integer> items = new HashMap<>();
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            int k = random.nextInt();
            int v = random.nextInt();
            System.out.printf("put <%d, %d>\n", k, v);
            items.put(k, v);
            simpleBST.put(k, v);
        }

        Set<Integer> keys = items.keySet();
        for (Integer key : keys) {
            Assert.assertEquals(items.get(key), simpleBST.get(key));
        }
    }
}

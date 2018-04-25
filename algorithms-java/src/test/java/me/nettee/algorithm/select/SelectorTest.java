package me.nettee.algorithm.select;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;

@RunWith(Parameterized.class)
public class SelectorTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new QuickSelector()},
        });
    }

    private static final int N = 10;

    private Selector selector;

    public SelectorTest(Selector selector) {
        this.selector = selector;
    }

    @Test
    public void testSelect() {
        Integer[] a = new Integer[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt(100);
        }
        int rank = random.nextInt(N) + 1;

        Integer[] b = Arrays.copyOf(a, a.length);
        Arrays.sort(b);
        Integer expected = b[rank-1];

        Comparable e = selector.select(a, rank);
        Assert.assertEquals(expected, e);
    }


}

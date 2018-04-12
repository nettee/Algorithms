package me.nettee.algorithm.sorting;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class SorterTest {

    @Parameterized.Parameters(name = "{0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][] {
                {new SelectionSorter()},
                {new InsertionSorter()},
                {new BubbleSorter()},
        });
    }

    private static final int N = 10;

    private Sorter sorter;

    public SorterTest(Sorter sorter) {
        this.sorter = sorter;
    }

    @Test
    public void testSort() {
        Integer[] a = new Integer[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt(100);
        }
        show(a);
        sorter.sort(a);
        assertTrue(isSorted(a));
        show(a);
    }

    private void show(Comparable[] a) {
        String s = Arrays.stream(a)
                .map(i -> i.toString())
                .collect(Collectors.joining(" "));
        System.out.println(s);
    }

    public boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

    private boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

}

package me.nettee.algorithm.sorting;

import org.junit.Test;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

import static org.junit.Assert.assertTrue;

public class SorterTest {

    private static final int N = 10;

    private Sorter sorter = new SelectionSorter();

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

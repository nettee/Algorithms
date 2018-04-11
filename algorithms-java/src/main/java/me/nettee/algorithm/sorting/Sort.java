package me.nettee.algorithm.sorting;

import org.apache.commons.lang3.Validate;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Collectors;

public class Sort {

    public static final int N = 10;

    public static void main(String[] args) {
        Integer[] a = new Integer[N];
        Random random = new Random();
        for (int i = 0; i < N; i++) {
            a[i] = random.nextInt(100);
        }
        show(a);
        sort(a);
        Validate.isTrue(isSorted(a));
        show(a);
    }

    public static void sort(Comparable[] a) {
        int N = a.length;
        // Invariant: after i iterations, a[0..i) is the minimum i elements and sorted.
        // In the i-th iteration, the i-th smallest element is moved to place a[i].
        // The i-th smallest element is never touched after the i-th iteration.
        for (int i = 0; i < N; i++) {
            // Find the minimum in a[i+1..N), and exchange a[i] with it.
            int min = i;
            for (int j = i + 1; j < N; j++) {
                if (less(a[j], a[min])) {
                    min = j;
                }
            }
            exchange(a, i, min);
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        String s = Arrays.stream(a)
                .map(i -> i.toString())
                .collect(Collectors.joining(" "));
        System.out.println(s);
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i-1])) {
                return false;
            }
        }
        return true;
    }

}

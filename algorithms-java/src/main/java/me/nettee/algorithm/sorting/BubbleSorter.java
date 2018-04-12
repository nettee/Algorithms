package me.nettee.algorithm.sorting;

public class BubbleSorter extends Sorter {

    @Override
    void sort(Comparable[] a) {
        int N = a.length;
        // Invariant: after each iteration, a[i-1..N) are the largest elements, sorted.
        // In each iteration, the largest element in a[0..i) is bubbled to a[i-1]
        for (int i = N; i > 0; i--) {
            // Bubble the largest element int a[0..i) to a[i-1]
            for (int j = 1; j < i; j++) {
                if (less(a[j], a[j-1])) {
                    exchange(a, j, j-1);
                }
            }
        }
    }
}

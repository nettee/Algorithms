package me.nettee.algorithm.sorting;

public class SelectionSorter implements Sorter {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        // Invariant: after i iterations, a[0..i) is the minimum i elements and sorted.
        // In the i-th iteration, the i-th smallest element is moved to place a[i].
        // The i-th smallest element is never touched after the i-th iteration.
        for (int i = 0; i < N; i++) {
            // Move the minimum in a[i+1..N) to a[i].
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
}

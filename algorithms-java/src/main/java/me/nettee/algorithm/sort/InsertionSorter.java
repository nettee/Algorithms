package me.nettee.algorithm.sort;

public class InsertionSorter extends Sorter {

    @Override
    public void sort(Comparable[] a) {
        int N = a.length;
        // Invariant: after the i-th iteration, a[0..i] is sorted.
        // In the i-th iteration, a[i] is inserted into a[0..i)
        // a[i] is never touched before the i-th iteration.
        for (int i = 1; i < N; i++) {
            // Insert a[i] into a[0..i), and keep a[0..i] sorted.
            Comparable t = a[i];
            int j = i;
            while (j > 0 && less(t, a[j-1])) {
                a[j] = a[j-1];
                j--;
            }
            a[j] = t;
        }
    }
}

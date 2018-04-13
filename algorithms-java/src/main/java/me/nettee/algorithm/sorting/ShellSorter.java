package me.nettee.algorithm.sorting;

public class ShellSorter extends Sorter {

    @Override
    void sort(Comparable[] a) {
        int N = a.length;

        // Init h to the largest gap number (no larger than N / 3)
        // Use gap sequences 1, 4, 13, 40, 121, 364, 1093, ...
        // There are many other gap sequences
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        // After each iteration, a is h-sorted, i.e., every h-th element
        // gives a sorted list.
        // After the last iteration (h = 1), the list will be entirely sorted.
        while (h >= 1) {
            // Use insertion sort to h-sort the list.
            for (int i = h; i < N; i++) {
                // Insert a[i] into a[i-h], a[i-2h], a[i-3h] ...
                Comparable t = a[i];
                int j = i;
                while (j >= h && less(t, a[j-h])) {
                    a[j] = a[j-h];
                    j -= h;
                }
                a[j] = t;
            }
            h /= 3;
        }
    }
}

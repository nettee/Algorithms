package me.nettee.algorithm.sorting;

public class ShellSorter extends Sorter {

    @Override
    void sort(Comparable[] a) {
        int N = a.length;
        // Init h to a largest shell number (no larger than N / 3)
        int h = 1;
        while (h < N / 3) {
            h = 3 * h + 1;
        }

        while (h >= 1) {
            // Local insertion sort
            for (int i = h; i < N; i++) {
                // Insert a[i] into a[i-h], a[i-2h], a[i-3h] ...
                for (int j = i; j >= h && less(a[j], a[j-h]); j -= h) {
                    exchange(a, j, j-h);
                }
            }
            h /= 3;
        }
    }
}

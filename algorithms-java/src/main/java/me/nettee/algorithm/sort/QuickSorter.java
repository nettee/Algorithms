package me.nettee.algorithm.sort;

public class QuickSorter extends Sorter {

    @Override
    void sort(Comparable[] a) {
        int N = a.length;
        sort(a, 0, N-1);
    }

    private void sort(Comparable[] a, int low, int high) {
        if (low >= high) {
            return;
        }

        int v = partition(a, low, high);
        sort(a, low, v-1);
        sort(a, v+1, high);
    }

    private int partition(Comparable[] a, int low, int high) {

        // Select the pivot.
        int v = low;
        Comparable pivot = a[v];

        // Move the pivot to last.
        exchange(a, v, high);

        // Partition.
        int i = low;
        int j = high - 1;
        while (true) {
            // Find a pair of (i, j) such that a[i] > pivot > a[j]
            while (i <= high && less(a[i], pivot)) {
                i++;
            }
            while (j >= low && less(pivot, a[j])) {
                j--;
            }
            if (i >= j) {
                break;
            }
            exchange(a, i, j);
        }

        // Move the pivot to the partition place a[i].
        exchange(a, i, high);

        return i;
    }
}

package me.nettee.algorithm.select;

public class QuickSelector extends Selector {

    @Override
    Comparable select(Comparable[] a, int rank) {
        int N = a.length;
        return select(a, 0, N-1, rank);
    }

    private Comparable select(Comparable[] a, int low, int high, int rank) {

        int v = partition(a, low, high);

        int m = v - low + 1; // Rank of a[v]
        if (rank < m) {
            return select(a, low, v-1, rank);
        } else if (rank > m) {
            return select(a, v+1, high, rank - m);
        } else {
            return a[v];
        }
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

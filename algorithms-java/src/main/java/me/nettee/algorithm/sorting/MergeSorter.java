package me.nettee.algorithm.sorting;

import com.google.common.base.Preconditions;

public class MergeSorter extends Sorter {

    private Comparable[] aux;

    @Override
    void sort(Comparable[] a) {
        int N = a.length;
        aux = new Comparable[N];

        sort(a, 0, N-1);
    }

    private void sort(Comparable[] a, int low, int high) {
        Preconditions.checkState(low <= high, "Illegal index range a[%d..%d]", low, high);
        if (low >= high) {
            return;
        }

        int mid = low + (high - low) / 2;

        sort(a, low, mid);
        sort(a, mid+1, high);

        merge(a, low, mid, high);
    }

    private void merge(Comparable[] a, int low, int mid, int high) {
        // Precondition: a[low, mid], a[mid+1, high] are sorted.

        // Copy a[low..high] to aux[low..high].
        System.arraycopy(a, low, aux, low, high + 1 - low);

        // Copy aux[low..mid] and aux[mid+1..high] to a[low..high].
        int i = low;
        int j = mid + 1;
        // Loop condition is very important!
        for (int k = low; k <= high; k++) {
            if (i > mid) {
                a[k] = aux[j];
                j++;
            } else if (j > high) {
                a[k] = aux[i];
                i++;
            } else {
                if (less(aux[i], aux[j])) {
                    a[k] = aux[i];
                    i++;
                } else {
                    a[k] = aux[j];
                    j++;
                }
            }
        }
    }
}

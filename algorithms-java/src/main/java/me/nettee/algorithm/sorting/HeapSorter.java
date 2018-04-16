package me.nettee.algorithm.sorting;

import java.util.PriorityQueue;

public class HeapSorter extends Sorter {

    @Override
    void sort(Comparable[] a) {
        int N = a.length;

        PriorityQueue<Comparable> heap = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            heap.add(a[i]);
        }

        for (int i = 0; i < N; i++) {
            a[i] = heap.remove();
        }
    }
}

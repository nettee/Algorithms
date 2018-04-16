package me.nettee.algorithm.sorting;

import java.util.PriorityQueue;

public class HeapSorter extends Sorter {

    public interface Heap<E extends Comparable> {
        void add(E e);
        E remove();
    }

    static class DefaultHeap implements Heap<Comparable> {

        private final PriorityQueue<Comparable> heap = new PriorityQueue<>();

        @Override
        public void add(Comparable e) {
            heap.add(e);
        }

        @Override
        public Comparable remove() {
            return heap.remove();
        }
    }

    private Heap<Comparable> heap;

    public HeapSorter() {
        setHeap(new DefaultHeap());
    }

    void setHeap(Heap<Comparable> heap) {
        this.heap = heap;
    }

    @Override
    void sort(Comparable[] a) {
        int N = a.length;

        for (int i = 0; i < N; i++) {
            heap.add(a[i]);
        }

        for (int i = 0; i < N; i++) {
            a[i] = heap.remove();
        }
    }
}

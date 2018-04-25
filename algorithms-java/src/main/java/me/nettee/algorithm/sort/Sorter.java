package me.nettee.algorithm.sort;

public abstract class Sorter {

    abstract void sort(Comparable[] a);

    boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    void exchange(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}

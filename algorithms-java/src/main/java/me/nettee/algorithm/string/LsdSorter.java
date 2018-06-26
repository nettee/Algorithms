package me.nettee.algorithm.string;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LsdSorter extends StringSorter {

    private final int W;

    public LsdSorter(int W) {
        this.W = W;
    }


    @Override
    void sort(String[] a) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];

        for (int d = W - 1; d >= 0; d--) {
            // Sort the d-th character by key-indexed count.
            // Consider the d-th character of each string:

            int[] count = new int[R+1];

            for (int i = 0; i < N; i++) {
                char c = a[i].charAt(d);
                count[c+1]++;
            }
            // count[r+1] means the number of strings whose d-th character
            // has value r.

            for (int r = 0; r < R; r++) {
                count[r+1] += count[r];
            }
            // count[i] = sum(count[0..i])
            // count[r+1] means the number of strings whose d-th character
            // has value no larger than r.

            // Invariant: count[r] is the inserting position of the next
            // string whose d-th character has value r.
            for (int i = 0; i < N; i++) {
                char c = a[i].charAt(d);
                aux[count[c]] = a[i];
                count[c]++;
            }

            // Write back.
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }

            System.out.printf("Sort %d:  %s\n", d, String.join(", ", a));
        }
    }

    public static void main(String[] args) {

        List<String> l = new ArrayList<>();

        String filename = "data/string/lsd.txt";
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                l.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        String[] a = l.toArray(new String[l.size()]);
        System.out.println("Origin:  " + String.join(", ", a));
        int W = a[0].length();

        LsdSorter sorter = new LsdSorter(W);
        sorter.sort(a);
        System.out.println("The end: " + String.join(", ", a));
    }

}

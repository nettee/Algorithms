package me.nettee.algorithm.string;

import me.nettee.algorithm.sort.InsertionSorter;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MsdSorter extends StringSorter {

    private int R = 256;
    private String[] aux;
    private InsertionSorter insertionSorter;

    // Consider "end-of-string" as a special character, which is less than
    // any normal characters.
    private int charAt(String s, int d) {
        if (d < s.length()) {
            return s.charAt(d);
        } else {
            return -1;
        }
    }

    @Override
    void sort(String[] a) {
        int N = a.length;
        aux = new String[N];
        insertionSorter = new InsertionSorter();
        sort(a, 0, N-1, 0);
    }

    private void sort(String[] a, int low, int high, int d) {
        if (high <= low) {
            return;
        }

        System.out.printf("sort(a, %d, %d, %d)\n", low, high, d);

        int[] count = new int[R+2];
        for (int i = low; i <= high; i++) {
            int r = charAt(a[i], d);
            count[r+2]++;
        }
        // After loop: count[r+2] is the number of strings whose d-th character
        // has value r.
        // This holds when r = -1: count[1] means the number of strings whose
        // length is d, i.e., the d-th character is end-of-string (value -1).

        // count[i] = sum(count[0..i])
        for (int r = 0; r < R+1; r++) {
            count[r+1] += count[r];
        }
        // After loop: count[r+2] means the number of strings whose d-th
        // character has value no larger than r.
        // This holds for r = -1: count[1] means the number of strings whose
        // length is d, i.e., the d-th character is no larger than -1.

        // Invariant: count[r+1] is the inserting position of the next string
        // whose d-th character has value r.
        // This holds for r = -1.
        for (int i = low; i <= high; i++) {
            int r = charAt(a[i], d);
            aux[count[r+1]] = a[i];
            count[r+1]++;
        }
        // After loop: for i in [0,R], count[i] increases to the origin value
        // of count[i+1].
        // Now count[r+1] means the number of strings whose d-th character has
        // value no larger than r.
        // This holds for r = -1.

        // Write back.
        for (int i = low; i <= high; i++) {
            a[i] = aux[i-low];
        }

        for (int r = 0; r < R; r++) {
            // Recursively sort strings whose d-th character has value r.
            // Note: the strings whose length is d will not sort recursively.
            sort(a, low + count[r], low + count[r+1] - 1, d+1);
        }
    }

    public static void main(String[] args) {

        List<String> l = new ArrayList<>();

        String filename = "data/string/msd.txt";
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

        MsdSorter sorter = new MsdSorter();
        sorter.sort(a);
        System.out.println("The end: " + String.join(", ", a));
    }
}

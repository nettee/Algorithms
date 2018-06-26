package me.nettee.algorithm.string;

import java.util.HashMap;
import java.util.Map;

public class Alphabet {

    private final char[] a;
    private final Map<Character, Integer> m = new HashMap<>();
    private final int r;
    private final int logR;

    public Alphabet(String s) {
        a = s.toCharArray();
        for (int i = 0; i < a.length; i++) {
            m.put(a[i], i);
        }
        r = a.length;
        int logR = 0;
        int n = 1;
        while (n < a.length) {
            n *= 2;
            logR++;
        }
        this.logR = logR;
    }

    public char toChar(int index) {
        return a[index];
    }

    public int toIndex(char c) {
        return m.get(c);
    }

    public boolean contains(char c) {
        return m.containsKey(c);
    }

    public int R() {
        return r;
    }

    public int lgR() {
        return logR;
    }

    public int[] toIndices(String s) {
        int[] indices = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            indices[i] = toIndex(s.charAt(i));
        }
        return indices;
    }

    public String toChars(int[] indices) {
        char[] chars = new char[indices.length];
        for (int i = 0; i < indices.length; i++) {
            chars[i] = toChar(indices[i]);
        }
        return new String(chars);
    }

}

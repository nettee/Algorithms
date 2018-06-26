package me.nettee.algorithm.string;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class AlphabetTest {

    @Parameters(name = "{index}: {0}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"BINARY", 2, 1, "01"},
                {"DNA", 4, 2, "ACTG"},
                {"OCTAL", 8, 3, "01234567"},
                {"DECIMAL", 10, 4, "0123456789"},
                {"HEXDECIMAL", 16, 4, "0123456789ABCDEF"},
                {"PROTEIN", 20, 5, "ACDEFGHIKLMNPQRSTVWY"},
                {"LOWERCASE", 26, 5, "abcdefghijklmnopqrstuvwxyz"},
                {"UPPERCASE", 26, 5, "ABCDEFGHIJKLMNOPQRSTUVWXYZ"},
                {"BASE64", 64, 6, "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/"},
        });
    }

    private String name;
    private int r;
    private int logR;
    private String charSet;

    public AlphabetTest(String name, int r, int logR, String charSet) {
        this.name = name;
        this.r = r;
        this.logR = logR;
        this.charSet = charSet;
    }

    @Test
    public void testAlphabet() {
        Alphabet alphabet = new Alphabet(charSet);
        assertEquals(r, alphabet.R());
        assertEquals(logR, alphabet.lgR());
    }
}

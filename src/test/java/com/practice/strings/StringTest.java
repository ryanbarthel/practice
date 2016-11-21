package com.practice.strings;


import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.TreeMap;

/**
 * Created by rbarthel on 9/8/16.
 */
public class StringTest {

    @Test
    public void testReverse() {
        StringStuff ss = new StringStuff();
        Assert.assertEquals(ss.reverse("banana"), "ananab");
        Assert.assertEquals(ss.reverse("apple"), "elppa");
    }

    @Test
    public void testReverseRecursion() {
        StringStuff ss = new StringStuff();
        Assert.assertEquals(ss.reverseRecursively(0, 5,"banana".toCharArray()), "ananab");
        Assert.assertEquals(ss.reverseRecursively(0,4,"apple".toCharArray()), "elppa");
    }

    @Test
    public void testUniqueness() {
        StringStuff ss = new StringStuff();
        Assert.assertTrue(ss.hasUniqueCharacters("abcdefgh"));
        Assert.assertFalse(ss.hasUniqueCharacters("abcddef"));
    }

    @Test
    public void testUniquenessWithoutDataStructures() {
        StringStuff ss = new StringStuff();
        Assert.assertTrue(ss.hasUniqueCharactersInPlace("abcdefgh"));
        Assert.assertFalse(ss.hasUniqueCharactersInPlace("abcddef"));
    }

    @Test
    public void testAnagram() {
        StringStuff ss = new StringStuff();
        Assert.assertTrue(ss.isAnagram("cinema", "iceman"));
        Assert.assertTrue(ss.isAnagram("aaccbb", "abcabc"));
        Assert.assertFalse(ss.isAnagram("abcd", "abcde"));
        Assert.assertFalse(ss.isAnagram("abcd", "abce"));
    }

    @Test
    public void testCompression() {
        StringStuff ss = new StringStuff();
        Assert.assertEquals(ss.compress("aaabbbccdaa"), "a3b3c2d1a2");
    }

    @Test
    public void testDuplicates() {
        StringStuff ss = new StringStuff();
        Assert.assertEquals(ss.getDuplicateLetters("Momma"),"m");

        Assert.assertEquals(ss.getDuplicateLetters("AAAaaaa"),"Aa");
    }

    @Test
    public void testInitials() {
        StringStuff ss = new StringStuff();
        Assert.assertEquals(ss.getIntials("Read The Fucking Manual"), "RTFM");
    }

    @Test
    public void testMinimalModify() {
        StringStuff ss = new StringStuff();
        Assert.assertEquals(ss.minimalModify("aba"), 1);
        Assert.assertEquals(ss.minimalModify("abam"), 1);
        Assert.assertEquals(ss.minimalModify("aa"), 0);
        Assert.assertEquals(ss.minimalModify("a"), 1);
        Assert.assertEquals(ss.minimalModify("abbcd"), 3);
        Assert.assertEquals(ss.minimalModify("repeatstring"), 6);
        Assert.assertEquals(ss.minimalModify("aaabbbaaaccc"), 3);
    }

    @Test
    public void testReverseExcludingSpecial() {
        StringStuff ss = new StringStuff();
        String test = "Ab,c,de!$";
        String test2 = "a!!!b.c.d,e'f,ghi";
        Assert.assertFalse(Character.isLetterOrDigit('!'));
        Assert.assertFalse(Character.isLetterOrDigit(','));
        Assert.assertEquals(ss.reverseRecursivelyExcludingSpecialCharacters(0, 8, test.toCharArray()), "ed,c,bA!$");
        Assert.assertEquals(ss.reverseRecursivelyExcludingSpecialCharacters(0, test2.length()-1, test2.toCharArray()), "i!!!h.g.f,e'd,cba");
    }

    @Test
    public void roman() {
        TreeMap<Integer, String> tm = new TreeMap<>();

    }

}

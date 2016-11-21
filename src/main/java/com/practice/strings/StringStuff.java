package com.practice.strings;


import java.util.*;

/**
 * Created by rbarthel on 9/8/16.
 */
public class StringStuff {



    public String reverse(String input) {
        char[] array = input.toCharArray();
        for (int forward = 0, backward = input.length() -1; forward <= backward; forward++, backward--) {
            char temp = array[forward];
            array[forward] = array[backward];
            array[backward] = temp;
        }
        return new String(array);
    }


    public String reverseRecursively(int start, int end, char[] input) {
        System.out.println(start + " " + end + " " + new String(input));
        if (start >= end) {
            return new String(input);
        }

        char temp = input[start];
        input[start] = input[end];
        input[end] = temp;

        return reverseRecursively(start + 1, end -1, input);


    }

    public String reverseRecursivelyExcludingSpecialCharacters(int start, int end, char[] input) {
        System.out.println(start + " " + end + " " + new String(input));
        if (start >= end) {
            return new String(input);
        }
        if(!Character.isLetterOrDigit(input[start])  || !Character.isLetterOrDigit(input[end])) {
            if(!Character.isLetterOrDigit(input[start])) {
                return reverseRecursivelyExcludingSpecialCharacters(start + 1, end, input);
            } else {
                return reverseRecursivelyExcludingSpecialCharacters(start, end-1, input);
            }
        } else {
            char temp = input[start];
            input[start] = input[end];
            input[end] = temp;
        }

        return reverseRecursivelyExcludingSpecialCharacters(start + 1, end -1, input);


    }

    public boolean hasUniqueCharacters(String input) {
        if (input.length() > 256) {
            return false;
        }
        input.contains(String.valueOf(input.charAt(0)));
        boolean[] boolArray = new boolean[256];
        for (int i = 0; i< input.length(); i++) {
            int c = input.charAt(i);
            if (boolArray[c]) {
                return false;
            } else {
                boolArray[c] = true;
            }
        }
        return true;
    }

    public boolean hasUniqueCharactersInPlace(String input) {
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length; i++) {
            char c = array[i];
            for (int j = i +1; j < array.length; j++) {
                if (array[j] == c) {
                    return false;
                }
            }
        }

         return true;
    }

    public boolean isAnagram(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        char[] temp1 = s1.toCharArray();
        char[] temp2 = s2.toCharArray();
        Arrays.sort(temp1);
        Arrays.sort(temp2);
        String sorted1 = new String(temp1);
        String sorted2 = new String(temp2);
        return sorted1.equals(sorted2);
    }

    public String compress(String input) {
        StringBuilder sb = new StringBuilder();
        char[] array = input.toCharArray();
        int count = 1;
        char last = array[0];
        for (int i = 1; i < array.length; i++) {
            char c = array[i];
            if (c == last) {
                count++;
            } else {
                sb.append(last);
                sb.append(count);
                last = c;
                count =1;
            }
        }
        sb.append(last);
        sb.append(count);
        String retval = sb.toString();
        if (retval.length() > input.length()) {
            return input;
        } else {
            return retval;
        }
    }

    public String getDuplicateLetters(String input) {
        if (input == null || input.isEmpty()) {
            return "";
        }
        Set<Character> retval = new HashSet<>();
        Map<Character, Object> map = new HashMap<>();
        for (char c: input.toCharArray()) {

            if (map.get(c) != null) {
                retval.add(c);
            } else {
                map.put(c, new Object());
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Character c : retval) {
            sb.append(c);
        }
        return sb.toString();

    }

    public String getIntials(String name) {
        String[] array = name.split(" ");
        String retval = "";
        for (String str : array) {
            retval += str.toCharArray()[0];
        }
        return retval;
    }

    public int minimalModify(String s) {
        return modify(s, 0);
    }

    private int modify(String s, int count) {
        int len = s.length();
        if (len == 0) {
            return count;
        }
        int middle = len %2 ==0? len/2: len/2 +1;
        String s1 = s.substring(0, middle);
        String s2 = s.substring(middle);
        if (len % 2 == 0 && s1.equals(s2)) {
            System.out.println(s1 + " " +s2);
            return count;
        }
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();
       // Arrays.sort(arr1);
        //Arrays.sort(arr2);
        int max = arr1.length >= arr2.length? arr1.length: arr2.length;
        for (int i = 0; i < max; i++) {
            if (i > arr1.length - 1) {
                return modify(new String(arr1) + arr2[i]+ new String(arr2), count +1);
            } else if (i > arr2.length - 1) {
                return modify(new String(arr2) + arr1[i]+ new String(arr1), count +1);
            }
            if (arr1[i] == arr2[i]) {
                continue;
            } else {
                arr2[i] = arr1[i];
                return modify(new String(arr1) + new String(arr2), count +1);
            }
        }
        return 0;
    }


}

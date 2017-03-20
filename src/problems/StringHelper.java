package com.github.ancabanca.interviewprep.problems;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class StringHelper {

    // alphabetSize = 255 for ASCII, 65535 for Unicode etc.
    // Uses a HashSet as an additional data structure.
    public static boolean hasAllUniqueCharacters1(String s, int alphabetSize) {
        if(s.length() > alphabetSize)
            return false;

        Set<Character> set = new HashSet<Character>();
        for(int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if(set.contains(c))
                return false;
            set.add(c);
        }

        return true;
    }

    // It first sorts the string characters. --> time O(n logn)
    // Doesn't use additional data structure --> space O(1)
    //  (actually sort is merge sort, so it's not explicit, but there is additional space used)
    // Actually, it convert the String to a char[]. which takes O(n) space.
    // So space complexity is, no matter what, O(n).
    public static boolean hasAllUniqueCharacters2(String s, int alphabetSize) {
        if(s.length() > alphabetSize)
            return false;
        char[] characters = s.toCharArray();
        Arrays.sort(characters);

        for(int i = 0; i < characters.length-1; i++)
            if(characters[i] == characters[i+1])
                return false;

        return true;
    }
}
package com.dev.string;

import java.util.HashSet;
import java.util.Set;

/**
 * Created on 10/01/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
public class StringSolution {

    //Longest Substring Without Repeating Characters
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int l = 0, maxLength = 0;
        for (int r = 0; r < s.length(); r++) {
            while (set.contains(s.charAt(r))) {
                set.remove(s.charAt(l));
                l++;
            }
            set.add(s.charAt(r));
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }


}

package com.dev.slidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created on 07/02/2025
 * Project -  DsaPracticeProject
 * Author - Devesh Kumar
 */
public class SlidingWindowSolutions {

    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {

        int maxLength = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] charArr = new int[255];
            int length = 0;
            for (int k = i; k < s.length(); k++) {
                if (charArr[s.charAt(k)] == 1) break;
                length = k - i + 1;
                maxLength = Math.max(maxLength, length);

                charArr[s.charAt(k)] = 1;
            }
        }
        return maxLength;

    }

    /**
     * Given a string s, find the length of the longest substring without repeating characters.
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring1(String s) {
        int maxLength = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap<>();

        for (int r = 0; r < s.length(); r++) {
            if (map.containsKey(s.charAt(r))) {
                l = Math.max(map.get(s.charAt(r)) + 1, l);
            }
            map.put(s.charAt(r), r);
            maxLength = Math.max(maxLength, r - l + 1);
        }
        return maxLength;
    }

    /**
     * Here is a solution to find the maximum number of consecutive ones in a
     * binary array by flipping at most k zeroes using the sliding window
     * technique:
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0;
        int maxLength = 0;
        int zeroCount = 0;

        while (right < nums.length) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
            right++;
        }

        return maxLength;
    }

    /**
     * Here is an optimized solution to find the maximum number
     * of consecutive ones in a binary array by flipping at most k zeroes
     * without using an inner while loop
     *
     * @param nums
     * @param k
     * @return
     */
    public int longestOnes1(int[] nums, int k) {
        int left = 0, right = 0;
        int maxLength = 0;
        int zeroCount = 0;

        for (right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            if (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }

    /**
     * Here is a Java solution to find the maximum number of fruits you can
     * pick for k baskets from a given array using the sliding window technique:
     * @param fruits
     * @param k
     * @return
     */
    public int maxFruits(int[] fruits, int k) {
        int left = 0, right = 0;
        int maxFruits = 0;
        Map<Integer, Integer> basket = new HashMap<>();

        while (right < fruits.length) {
            basket.put(fruits[right], basket.getOrDefault(fruits[right], 0) + 1);

            while (basket.size() > k) {
                basket.put(fruits[left], basket.get(fruits[left]) - 1);
                if (basket.get(fruits[left]) == 0) {
                    basket.remove(fruits[left]);
                }
                left++;
            }

            maxFruits = Math.max(maxFruits, right - left + 1);
            right++;
        }

        return maxFruits;
    }

    public static int lengthOfShortestSubstring(String s) {
        if (s == null || s.isEmpty()) return 0;

        Set<Character> uniqueChars = new HashSet<>();
        for (char c : s.toCharArray()) {
            uniqueChars.add(c);
        }

        int requiredUniqueCount = uniqueChars.size();
        Map<Character, Integer> windowCounts = new HashMap<>();
        int left = 0, right = 0, formed = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);

            if (uniqueChars.contains(c) && windowCounts.get(c).intValue() == 1) {
                formed++;
            }

            while (left <= right && formed == requiredUniqueCount) {
                c = s.charAt(left);
                minLength = Math.min(minLength, right - left + 1);

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (uniqueChars.contains(c) && windowCounts.get(c).intValue() == 0) {
                    formed--;
                }
                left++;
            }
            right++;
        }

        return minLength == Integer.MAX_VALUE ? 0 : minLength;
    }

}


import java.util.*;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> freq = new HashMap<>();

        for (String word : words) {
            freq.put(word, freq.getOrDefault(word, 0) + 1);
        }

        int length = 0;
        boolean hasCenter = false;

        for (String word : freq.keySet()) {
            int count = freq.get(word);

            // Case 1: Self-reversing words, e.g. "cc"
            if (word.charAt(0) == word.charAt(1)) {
                length += (count / 2) * 4;

                if (count % 2 == 1) {
                    hasCenter = true;
                }
            }
            // Case 2: Different reverse words, e.g. "ab" and "ba"
            else {
                String rev = reverse(word);

                if (freq.containsKey(rev)) {
                    int pairs = Math.min(count, freq.get(rev));
                    length += pairs * 2;
                }
            }
        }

        // Each distinct reverse pair was counted twice.
        // Correct the double counting.
        // (See the improved version below for avoiding this directly.)
        return length + (hasCenter ? 2 : 0);
    }

    private String reverse(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

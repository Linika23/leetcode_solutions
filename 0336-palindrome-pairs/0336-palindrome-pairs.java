
import java.util.*;

class Solution {
    public List<List<Integer>> palindromePairs(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < words.length; i++) {
            map.put(words[i], i);
        }

        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            int n = word.length();

            for (int cut = 0; cut <= n; cut++) {
                String prefix = word.substring(0, cut);
                String suffix = word.substring(cut);

                // Case 1: Prefix is a palindrome.
                // Need reverse(suffix) before word.
                if (isPalindrome(prefix)) {
                    String revSuffix =
                        new StringBuilder(suffix).reverse().toString();

                    if (map.containsKey(revSuffix)) {
                        int j = map.get(revSuffix);

                        if (j != i) {
                            result.add(Arrays.asList(j, i));
                        }
                    }
                }

                // Case 2: Suffix is a palindrome.
                // Need reverse(prefix) after word.
                // cut < n prevents duplicate pairs at the empty suffix.
                if (cut < n && isPalindrome(suffix)) {
                    String revPrefix =
                        new StringBuilder(prefix).reverse().toString();

                    if (map.containsKey(revPrefix)) {
                        int j = map.get(revPrefix);

                        if (j != i) {
                            result.add(Arrays.asList(i, j));
                        }
                    }
                }
            }
        }

        // Remove duplicate pairs, if any.
        Set<List<Integer>> unique = new LinkedHashSet<>(result);
        return new ArrayList<>(unique);
    }

    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }

        return true;
    }
}

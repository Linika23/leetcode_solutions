class Solution {
    public String reorganizeString(String s) {

        // Count frequency of each character
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        // Max heap: {character, frequency}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> b[1] - a[1]
        );

        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder ans = new StringBuilder();

        // Previous character that we cannot immediately reuse
        int[] prev = null;

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            ans.append((char) (curr[0] + 'a'));
            curr[1]--;

            // Put previous character back because it can now be used
            if (prev != null && prev[1] > 0) {
                pq.offer(prev);
            }

            // Current character becomes previous
            prev = curr;
        }

        // If we couldn't use all characters
        if (ans.length() != s.length()) {
            return "";
        }

        return ans.toString();
    }
}
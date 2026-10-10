class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();

        for (char x : tasks) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        int maxFreq = 0;
        int maxCount = 0;

        for (int freq : map.values()) {
            if (freq > maxFreq) {
                maxFreq = freq;
                maxCount = 1;
            } else if (freq == maxFreq) {
                maxCount++;
            }
        }

        int total = tasks.length;

        return Math.max(
            total,
            (maxFreq - 1) * (n + 1) + maxCount
        );
    }
}
class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        // sort by nums2 descending
        Arrays.sort(pairs, (a, b) -> b[1] - a[1]);

        PriorityQueue<Integer> pq = new PriorityQueue<>(); // min-heap of nums1
        long sum = 0, ans = 0;

        for (int[] p : pairs) {
            pq.offer(p[0]);
            sum += p[0];

            if (pq.size() > k) {
                sum -= pq.poll();
            }
            if (pq.size() == k) {
                ans = Math.max(ans, sum * p[1]);
            }
        }
        return ans;
    }
}
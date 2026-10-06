class Solution {
    public List<List<Integer>> kSmallestPairs(
            int[] nums1, int[] nums2, int k) {

        List<List<Integer>> pairs = new ArrayList<>();

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(
                nums1[a.get(0)] + nums2[a.get(1)],
                nums1[b.get(0)] + nums2[b.get(1)]
            )
        );

        // Initially add first pair from each row
        for (int i = 0; i < Math.min(k, nums1.length); i++) {
            pq.add(Arrays.asList(i, 0));
        }

        while (!pq.isEmpty() && pairs.size() < k) {

            List<Integer> curr = pq.poll();

            int i = curr.get(0);
            int j = curr.get(1);

            pairs.add(Arrays.asList(nums1[i], nums2[j]));

            // Move to next element in the same row
            if (j + 1 < nums2.length) {
                pq.add(Arrays.asList(i, j + 1));
            }
        }

        return pairs;
    }
}
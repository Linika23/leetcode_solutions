class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> mp = new HashMap<>();
        for (int n : nums) {
            mp.put(n, mp.getOrDefault(n, 0) + 1);
        }

        // min-heap: least frequent element is at the top
        PriorityQueue<Map.Entry<Integer, Integer>> pq =
            new PriorityQueue<>((a, b) -> a.getValue() - b.getValue());

        for (Map.Entry<Integer, Integer> e : mp.entrySet()) {
            pq.offer(e);
            if (pq.size() > k) {
                pq.poll(); // remove the least frequent of the k+1
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll().getKey();
        }
        return result;
    }
}
class Solution {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int n = quality.length;

        double[][] workers = new double[n][2];
        for (int i = 0; i < n; i++) {
            workers[i][0] = (double) wage[i] / quality[i]; // ratio
            workers[i][1] = quality[i];
        }

        // sort by ratio ascending
        Arrays.sort(workers, (a, b) -> Double.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder()); // max-heap
        int qualitySum = 0;
        double ans = Double.MAX_VALUE;

        for (double[] w : workers) {
            int q = (int) w[1];
            pq.offer(q);
            qualitySum += q;

            if (pq.size() > k) {
                qualitySum -= pq.poll(); // drop the largest quality
            }
            if (pq.size() == k) {
                ans = Math.min(ans, qualitySum * w[0]);
            }
        }
        return ans;
    }
}
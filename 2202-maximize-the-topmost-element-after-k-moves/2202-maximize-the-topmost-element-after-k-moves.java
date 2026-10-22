class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;

        if (n == 1) {
            return k % 2 == 0 ? nums[0] : -1;
        }

        if (k == 0) {
            return nums[0];
        }

        int ans = -1;

        for (int i = 0; i < Math.min(k - 1, n); i++) {
            ans = Math.max(ans, nums[i]);
        }

        if (k < n) {
            ans = Math.max(ans, nums[k]);
        }

        return ans;
    }
}
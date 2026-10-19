class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count=0;
        int totalCost=0;
        for (int i = 0; i < costs.length; i++) {
            if (totalCost + costs[i] <= coins) {
                totalCost += costs[i];
                count++;
            } else {
                break;
            }
        }
        return count;
        
    }
}
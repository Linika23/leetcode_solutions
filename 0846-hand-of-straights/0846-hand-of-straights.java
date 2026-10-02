class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        if (hand.length % groupSize != 0) {
            return false;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Store frequency + values in min heap
        for (int card : hand) {
            pq.add(card);
            freq.put(card, freq.getOrDefault(card, 0) + 1);
        }

        while (!pq.isEmpty()) {

            int first = pq.peek();

            for (int i = 0; i < groupSize; i++) {

                int card = first + i;

                if (freq.getOrDefault(card, 0) == 0) {
                    return false;
                }

                freq.put(card, freq.get(card) - 1);

                
                    pq.remove(card);
                
            }
        }

        return true;
    }
}
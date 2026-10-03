

class Solution {
    public String frequencySort(String s) {

        // 1. Count frequency of each character
        Map<Character, Integer> mp = new HashMap<>();
        for (char ch : s.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        // 2. Max heap: entry with highest frequency on top
        PriorityQueue<Map.Entry<Character, Integer>> pq =
            new PriorityQueue<>((a, b) -> Integer.compare(b.getValue(), a.getValue()));

        // 3. Fill heap from map
        pq.addAll(mp.entrySet());

        // 4. Build result
        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Map.Entry<Character, Integer> temp = pq.poll();   // top + pop in one step
            for (int i = 0; i < temp.getValue(); i++) {
                result.append(temp.getKey());
            }
        }
        return result.toString();
    }
}
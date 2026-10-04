class Solution {
    public int lastStoneWeight(int[] stones) {
        List<Integer> list = new ArrayList<>();
        for (int s : stones) list.add(s);

        while (list.size() > 1) {
            list.sort(Collections.reverseOrder());
            int y = list.get(0);      // heaviest
            int x = list.get(1);      // second heaviest

            list.remove(0);           // remove both by index
            list.remove(0);

            if (x != y) {
                list.add(y - x);      // put the leftover back
            }
        }

        if (list.size() == 0) {
            return 0;
        }
        return list.get(0);
    }
}
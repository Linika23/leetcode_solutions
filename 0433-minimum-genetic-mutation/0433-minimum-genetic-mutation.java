class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> valid = new HashSet<>(Arrays.asList(bank));
        if (!valid.contains(endGene)) return -1;

        char[] letters = {'A', 'C', 'G', 'T'};
        Queue<String> q = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int level = 0;

        q.offer(startGene);
        visited.add(startGene);

        while (!q.isEmpty()) {
            int n = q.size();

            for (int i = 0; i < n; i++) {
                String curStr = q.poll();
                if (curStr.equals(endGene)) return level;

                char[] cur = curStr.toCharArray();
                for (int j = 0; j < cur.length; j++) {
                    char original = cur[j];
                    for (char ch : letters) {
                        if (ch == original) continue;

                        cur[j] = ch;
                        String next = new String(cur);
                        if (valid.contains(next) && visited.add(next)) {
                            q.offer(next);
                        }
                    }
                    cur[j] = original; // restore
                }
            }
            level++;
        }
        return -1;
    }
}
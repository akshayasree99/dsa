class Solution {
    int[][] ms = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    public int maximumSafenessFactor(List<List<Integer>> g) {
        int n = g.size();

        int[][] v = new int[n][n];
        for (int[] r : v) Arrays.fill(r, -1);
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (g.get(i).get(j) == 1) {
                    v[i][j] = 0;
                    q.add(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] c = q.poll();
            for (int[] m : ms) {
                int nr = c[0] + m[0], nc = c[1] + m[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && v[nr][nc] == -1) {
                    v[nr][nc] = v[c[0]][c[1]] + 1;
                    q.add(new int[]{nr, nc});
                }
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[2] - a[2]);
        pq.add(new int[]{0, 0, v[0][0]});
        boolean[][] vis = new boolean[n][n];
        vis[0][0] = true;

        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            if (c[0] == n - 1 && c[1] == n - 1) return c[2];

            for (int[] m : ms) {
                int nr = c[0] + m[0], nc = c[1] + m[1];
                if (nr >= 0 && nc >= 0 && nr < n && nc < n && !vis[nr][nc]) {
                    vis[nr][nc] = true;
                    pq.add(new int[]{nr, nc, Math.min(c[2], v[nr][nc])});
                }
            }
        }
        return 0;
    }
}
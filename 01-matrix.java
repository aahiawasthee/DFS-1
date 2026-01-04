//TC: O(mXn)
//SC: O(m*n) for the queue

class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int dist = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] curr = q.poll();
                for (int[] dir : dirs) {
                    int nr = dir[0] + curr[0];
                    int nc = dir[1] + curr[1];

                    //bounds check
                    if (nr >= 0 && nc >= 0 && nr < m && nc < n && mat[nr][nc] == -1) {
                        q.add(new int[]{nr,nc}); // this is to process the next level in bfs
                        mat[nr][nc] = dist + 1;
                    }
                }
            }
            dist++;
        }
        return mat;
    }
}
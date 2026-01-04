//TC:O(m*n)
//SC:O(m*n) for the queue
 
class Solution {
    int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int originalCol = image[sr][sc];
        if (originalCol == color)
            return image;
        dfs(image, sr, sc, color, originalCol);
        return image;
    }

    private void dfs(int[][] image, int sr, int sc, int color, int originalCol) {
        //base
        if (sr < 0 || sc < 0 || sr >= image.length || sc >= image[0].length || image[sr][sc] != originalCol)
            return;

        //logic
        image[sr][sc] = color;
        for (int[] dir : dirs) {
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            dfs(image, nr, nc, color, originalCol);
        }

    }
}
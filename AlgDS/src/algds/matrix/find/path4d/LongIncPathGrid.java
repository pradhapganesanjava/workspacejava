package algds.matrix.find.path4d;

import java.util.Arrays;

/*

329. Longest Increasing Path in a Matrix

Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

Input: nums = 
[
  [9,9,4],
  [6,6,8],
  [2,1,1]
] 
Output: 4 
Explanation: The longest increasing path is [1, 2, 6, 9].

Example 2:

Input: nums = 
[
  [3,4,5],
  [3,2,6],
  [2,2,1]
] 
Output: 4 
Explanation: The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.


 */
public class LongIncPathGrid {

	public static void main(String[] args) {

	}

}

class LongIncPathGrid_Solution {
    public int longestIncreasingPath(int[][] matrix) {
        return bf(matrix);
    }
    private int bf(int[][] grid){
        if(grid == null || grid.length == 0) return 0;
        int[][] visit = new int[grid.length][grid[0].length];
        for(int r=0; r<visit.length; r++){
            Arrays.fill(visit[r],-1);
        }
        int mx = 0;
        for(int r=0; r<grid.length; r++){
            for(int c=0; c<grid[0].length; c++){
                
                if(visit[r][c]==-1){
                    int tmx = explore(grid, r, c, visit, -1);
                    mx = Math.max(mx, tmx);
                }else{
                    mx = Math.max(mx, visit[r][c]);
                }
                
            }
        }
        return mx;
    }
    private int explore(int[][] grid, int r, int c, int[][] visit, int pre){
        if(isInvalid(grid, r, c, pre)){
            return 0;
        }
        if(visit[r][c]!=-1){
            return visit[r][c];
        }
        visit[r][c] = 0;
        int up = explore(grid, r-1, c, visit, grid[r][c])+1;
        int dw = explore(grid, r+1, c, visit, grid[r][c])+1;
        int lf = explore(grid, r, c-1, visit, grid[r][c])+1;
        int rt = explore(grid, r, c+1, visit, grid[r][c])+1;
        visit[r][c] = Math.max(Math.max(up, dw), Math.max(lf,rt));
        return visit[r][c];
    }
    private boolean isInvalid(int[][] grid, int r, int c, int pre){
        return r>=grid.length || r<0||c>=grid[0].length||c<0 || grid[r][c]<=pre;
    }
}

//Topological Sort Based Solution
//An Alternative Solution
class ongIncPathGrid_Topological_Solution {
 private static final int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
 private int m, n;
 public int longestIncreasingPath(int[][] grid) {
     int m = grid.length;
     if (m == 0) return 0;
     int n = grid[0].length;
     // padding the matrix with zero as boundaries
     // assuming all positive integer, otherwise use INT_MIN as boundaries
     int[][] matrix = new int[m + 2][n + 2];
     for (int i = 0; i < m; ++i)
         System.arraycopy(grid[i], 0, matrix[i + 1], 1, n);

     // calculate outdegrees
     int[][] outdegree = new int[m + 2][n + 2];
     for (int i = 1; i <= m; ++i)
         for (int j = 1; j <= n; ++j)
             for (int[] d: dir)
                 if (matrix[i][j] < matrix[i + d[0]][j + d[1]])
                     outdegree[i][j]++;

     // find leaves who have zero out degree as the initial level
     n += 2;
     m += 2;
     List<int[]> leaves = new ArrayList<>();
     for (int i = 1; i < m - 1; ++i)
         for (int j = 1; j < n - 1; ++j)
             if (outdegree[i][j] == 0) leaves.add(new int[]{i, j});

     // remove leaves level by level in topological order
     int height = 0;
     while (!leaves.isEmpty()) {
         height++;
         List<int[]> newLeaves = new ArrayList<>();
         for (int[] node : leaves) {
             for (int[] d:dir) {
                 int x = node[0] + d[0], y = node[1] + d[1];
                 if (matrix[node[0]][node[1]] > matrix[x][y])
                     if (--outdegree[x][y] == 0)
                         newLeaves.add(new int[]{x, y});
             }
         }
         leaves = newLeaves;
     }
     return height;
 }
}
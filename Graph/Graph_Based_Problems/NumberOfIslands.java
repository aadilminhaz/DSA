package Graph.Graph_Based_Problems;

public class NumberOfIslands {

        public boolean isValidPath(char[][] grid, int i, int j) {
            if (i >= 0 && i<grid.length && j >=0 && j < grid[0].length) {
                return true;
            } 
            return false;
        }
    
        public void travelTheIsland(char[][] grid, int i, int j, boolean[][] visited) {
    
            if (isValidPath(grid, i, j) && visited[i][j] == false && grid[i][j] == '1') {
                visited[i][j] = true;
                //call dfs on every node and mark the land visited
                travelTheIsland(grid, i, j-1, visited); //travel left
                travelTheIsland(grid, i-1, j, visited); //travel up
                travelTheIsland(grid, i, j+1, visited); //travel right
                travelTheIsland(grid, i+1, j, visited); //travel down    
            }        
    
        }
    
        public int numIslands(char[][] grid) {
            
            int row = grid.length;
            if (row == 0) {
                return -1;
            }
            int col = grid[0].length;
    
            boolean[][] visited = new boolean[row][col];
            int numOfIslands = 0;
    
            for (int i=0; i<row; i++) {
                for (int j=0; j<col; j++) {
    
                    // if found land, and it is not visited
                    if (grid[i][j] == '1' && visited[i][j] == false) {
                        numOfIslands++;
                        
                        //mark each land cell in the island as visited
                        travelTheIsland(grid, i, j, visited);
                    }
    
                }
            }
            return numOfIslands;
    
        }
    
    
}

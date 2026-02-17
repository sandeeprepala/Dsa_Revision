class Pair{
    int row;
    int col;
    int time;
    Pair(int row,int col,int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}
public class lc994 {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] vis = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        int result = 0;
        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==2){
                    q.offer(new Pair(i,j,0));
                }
            }
        }
        while(!q.isEmpty()){
            Pair pr = q.poll();
            int row = pr.row;
            int col = pr.col;
            int tm = pr.time;
            result = Math.max(result,tm);
            vis[row][col] = 1;
            for(int i=0;i<4;i++){
                int nRow = row+dir[i][0];
                int nCol = col+dir[i][1];
                if(nRow>=0 && nRow<m && nCol>=0 && nCol<n && vis[nRow][nCol]==0 && grid[nRow][nCol]==1){
                    grid[nRow][nCol] = 2;
                    q.offer(new Pair(nRow,nCol,tm+1));
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1) return -1;
            }
        }
        return result;
    }
}

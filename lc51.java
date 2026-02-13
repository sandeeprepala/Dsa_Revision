import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc51 {
    public List<List<String>> solveNQueens(int n) {
        // Main Function
        List<List<String>> res = new ArrayList<>();
        int[][] vis = new int[n][n];
        for(int[] row:vis){
            Arrays.fill(row,-1);
        }
        helper(0,0,vis,res);
        return res;
    }
    public void helper(int row,int col,int[][]vis,List<List<String>>res){
        // Recursion Function
        if(row>=vis.length){
            // Base Case
            List<String> lis = new ArrayList<>();
            for(int i=0;i<vis.length;i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<vis.length;j++){
                    if(vis[i][j]==-1){
                        sb.append('.');
                    }else{
                        sb.append('Q');
                    }
                }
                lis.add(sb.toString());
            }
            res.add(lis);
            return;
        }
        for(int i=0;i<vis.length;i++){
            if(isSafe(row,i,vis)){
                vis[row][i] = 1;
                helper(row+1,0,vis,res);
                // Backtrack
                vis[row][i] = -1;
            }
        }
    }
    public boolean isSafe(int row,int col,int[][]vis){
        // isSafe() Function to check whether queen can be placed or not
        //Row Check
        for(int i=0;i<row;i++){
            if(i!=row && vis[i][col]==1) return false;
        }
        //Col Check
        for(int i=0;i<col;i++){
            if(i!=col && vis[row][i]==1) return false;
        }
        //Diagonal Checks
        int i = row - 1, j = col - 1;
        while (i >= 0 && j >= 0) {
            if (vis[i][j] == 1) return false;
            i--;
            j--;
        }
        i = row - 1;
        j = col + 1;
        while (i >= 0 && j < vis.length) {
            if (vis[i][j] == 1) return false;
            i--;
            j++;
        }

        return true;
    }
}

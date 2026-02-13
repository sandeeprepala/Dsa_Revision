public class gfg_rat_in_a_maze {
    public ArrayList<String> ratInMaze(int[][] maze) {
        // code here
        ArrayList<String> res = new ArrayList<>();
        int[][] vis = new int[maze.length][maze.length];
        StringBuilder sb = new StringBuilder();
        helper(0,0,maze,res,sb,vis);
        Collections.sort(res);
        return res;
    }
    public void helper(int row,int col,int[][]maze,ArrayList<String>res,StringBuilder sb,int[][]vis){
        if(row==maze.length-1 && col==maze.length-1){
            res.add(sb.toString());
            return;
        }
        
        int[][] dir = {{1,0,1},{0,1,2},{-1,0,3},{0,-1,4}}; //R,D,L,U
        for(int i=0;i<4;i++){
            int nRow = row+dir[i][1];
            int nCol = col+dir[i][0];
            int di = dir[i][2];
            char ch = 'R';
            if(di==1) ch = 'R';
            else if(di==2) ch = 'D';
            else if(di==3) ch = 'L';
            else ch = 'U';
            if(nRow>=0 && nRow<maze.length && nCol>=0 && nCol<maze.length
            && vis[nRow][nCol]==0 && maze[nRow][nCol]==1){
                sb.append(ch);
                vis[row][col] = 1;
                helper(nRow,nCol,maze,res,sb,vis);
                sb.deleteCharAt(sb.length()-1);
                vis[row][col] = 0;
            }
        }
        
    }
}

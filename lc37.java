public class lc37 {
    public void solveSudoku(char[][] board) {
        int[][] vis = new int[board.length][board.length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board.length;j++){
                if(board[i][j]!='.'){
                    vis[i][j] = 1;
                }
            }
        }
        helper(board,0,0,vis);
    }
    public boolean helper(char[][] board,int row,int col,int[][]vis){
        if(row==9){
            return true;
        }
        if(vis[row][col]!=1){
            for(int i=1;i<=9;i++){
                char ch = (char) (i+'0');
                if(isSafe(board,row,col,ch)){
                    board[row][col] = ch;
                    if(col<board.length-1){
                        if(helper(board,row,col+1,vis)) return true;
                    }else{
                        if(helper(board,row+1,0,vis)) return true;
                    }
                    board[row][col] = '.';
                }
            }
        }else{
            if(col<board.length-1){
                if(helper(board,row,col+1,vis)) return true;
            }else{
                if(helper(board,row+1,0,vis)) return true;
            }
        }
        return false;
    }
    public boolean isSafe(char[][]board,int row,int col,char ch){
        for(int i=0;i<9;i++){
            if(board[i][col]==ch) return false;
        }
        for(int i=0;i<9;i++){
            if(board[row][i]==ch) return false;
        }
        int rowBlock = row/3;
        int rowOffest = row%3;
        int colBlock = col/3;
        int colOffset = col%3;
        int starti = rowBlock*3;
        int startj = colBlock*3;
        for(int i=starti;i<starti+3;i++){
            for(int j=startj;j<startj+3;j++){
                if(board[i][j]==ch) return false;
            }
        } 
        return true;
    }
}

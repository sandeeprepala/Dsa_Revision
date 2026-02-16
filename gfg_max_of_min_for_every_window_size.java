import java.util.ArrayList;
import java.util.Stack;

class gfg_max_of_min_for_every_window_size{
    public ArrayList<Integer> maxOfMins(int[] heights) {
        // code here
        // Finding next and prev smaller elements 
        int[] prev = new int[heights.length];
        int[] next = new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            if(stack.isEmpty()){
                prev[i] = 0;
                stack.push(i);
            }
            else{
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    prev[i] = i;
                }else{
                    prev[i] = i-stack.peek()-1;
                }
                stack.push(i);
            }
        }
        while(!stack.isEmpty()){
            stack.pop();
        }
        for(int i=heights.length-1;i>=0;i--){
            if(stack.isEmpty()){
                next[i] = 0;
                stack.push(i);
            }else{
                while(!stack.isEmpty() && heights[stack.peek()]>=heights[i]){
                    stack.pop();
                }
                if(stack.isEmpty()){
                    next[i] = heights.length-i-1;
                }else{
                    next[i] = stack.peek()-i-1;
                }
                stack.push(i);
            }
        }
        int n = heights.length;
        int[] ans = new int[heights.length];

        for (int i = 0; i < n; i++) {
            int len = prev[i] + next[i] + 1;
            ans[len - 1] = Math.max(ans[len - 1], heights[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            ans[i] = Math.max(ans[i], ans[i + 1]);
        }

        ArrayList<Integer> res = new ArrayList<>();
        for (int x : ans) res.add(x);

        return res;    
    }
}
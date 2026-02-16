import java.util.Stack;

public class lc84 {
    public int largestRectangleArea(int[] heights) {
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
        int res = 0;
        for(int i=0;i<heights.length;i++){
            System.out.print(prev[i]+" ");
            res = Math.max(res,(prev[i]+next[i]+1)*heights[i]);
        }
        return res;
    }
}

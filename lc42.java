import java.util.Stack;

public class lc42 {
    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();
        int res = 0;
        for(int i=0;i<height.length;i++){
            while(!stack.isEmpty() && height[stack.peek()]<height[i]){
                int bottom = stack.pop();
                if(stack.isEmpty()) break;
                int left = stack.peek();
                int dis = i-left-1;
                int minHeight = Math.min(height[stack.peek()],height[i]);
                int reqHeight = minHeight-height[bottom];
                res += dis*reqHeight;
            }
            stack.push(i);
        }
        return res;
    }
}

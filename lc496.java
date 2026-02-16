import java.util.HashMap;
import java.util.Stack;

public class lc496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] res = new int[nums1.length];
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=nums2.length-1;i>=0;i--){
            if(stack.isEmpty()){
                stack.push(nums2[i]);
                map.put(nums2[i],-1);
            }
            else if(!stack.isEmpty() && stack.peek()<nums2[i]){
                while(!stack.isEmpty() && stack.peek()<nums2[i]){
                    stack.pop();
                }
                int num = -1;
                if(!stack.isEmpty()) num = stack.peek();
                map.put(nums2[i],num);
                stack.push(nums2[i]);
            }else{
                map.put(nums2[i],stack.peek());
                stack.push(nums2[i]);
            }
        }
        for(int i=0;i<nums1.length;i++){
            res[i] = map.get(nums1[i]);
        }
        return res;
    }
}

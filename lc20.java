import java.util.Stack;

public class lc20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(' || ch=='[' || ch=='{'){
                stack.push(ch);
                continue;
            }
            if(ch==')'){
                if(!stack.isEmpty() && stack.peek()=='('){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }if(ch==']'){
                if(!stack.isEmpty() && stack.peek()=='['){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }if(ch=='}'){
                if(!stack.isEmpty() && stack.peek()=='{'){
                    stack.pop();
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(!stack.isEmpty()) return false;
        return true;
    }
}

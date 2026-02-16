class gfg_sort_stack{
    public void sortStack(Stack<Integer> st) {
        // code here
        if(!st.isEmpty()){
            int ele = st.pop();
            sortStack(st);
            helper(st,ele);
        }   
    }
    public void helper(Stack<Integer>st,int ele){
        Stack<Integer> stack = new Stack<>();
        if(st.isEmpty()) st.push(ele);
        else{
            while(!st.isEmpty() && st.peek()>ele){
                stack.push(st.pop());
            }
            st.push(ele);
            while(!stack.isEmpty()){
                st.push(stack.pop());
            }   
        }
    }
}
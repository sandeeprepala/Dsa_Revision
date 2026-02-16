class gfg_next_greater_element{
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            if(stack.isEmpty()){
                res.add(-1);
                stack.push(arr[i]);
            }else{
                while(!stack.isEmpty() && stack.peek()>=arr[i]){
                    stack.pop();
                }
                if(!stack.isEmpty()) res.add(stack.peek());
                else res.add(-1);
                stack.push(arr[i]);
            }
        }
        Collections.reverse(res);
        return res;
    }
}
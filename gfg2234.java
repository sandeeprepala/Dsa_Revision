public class gfg2234 {
    public ArrayList<Integer> subsetSums(int[] arr) {
        // code here
        ArrayList<Integer> res = new ArrayList<>();
        helper(arr.length-1,arr,res,0);
        return res;
    }
    public void helper(int ind,int[] arr,ArrayList<Integer>res,int val){
        if(ind<0){
            res.add(val);
            return;
        }
        helper(ind-1,arr,res,val);
        helper(ind-1,arr,res,val+arr[ind]);
    } 
}

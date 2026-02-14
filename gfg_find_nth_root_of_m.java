class gfg_find_nth_root_of_m{
    public int nthRoot(int n, int m) {
        // code here
        int i=0,j=m;
        while(i<=j){
            int mid = i+(j-i)/2;
            int num = (int) Math.pow(mid,n);
            if(num==m){
                return mid;
            }else if(num<m){
                i = mid+1;
            }else{
                j = mid-1;
            }
        }
        return -1;
    }
}
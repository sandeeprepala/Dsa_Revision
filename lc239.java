import java.util.PriorityQueue;

class Pair{
    int value;
    int ind;
    Pair(int value,int ind){
        this.value = value;
        this.ind = ind;
    }
}
public class lc239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->b.value-a.value);
        int[] res = new int[nums.length-k+1];
        for(int i=0;i<k;i++){
            Pair cur = new Pair(nums[i],i);
            pq.offer(cur);
        }
        res[0] = pq.peek().value;
        int cnt = 1;
        for(int i=k;i<nums.length;i++){
            while(!pq.isEmpty() && pq.peek().ind<=i-k){
                pq.poll();
            }
            Pair cur = new Pair(nums[i],i);
            pq.offer(cur);
            res[cnt] = pq.peek().value;
            cnt++;
        }
        return res;
    }   
}

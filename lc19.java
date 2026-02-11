public class lc19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        int len = 0;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        int req = len-n+1;
        ListNode prev = null;
        ListNode cur = head;
        int num = 0;
        while(num<req-1 && cur!=null){
            num++;
            prev = cur;
            cur = cur.next;
        }
        if(cur==null){
            prev.next = null;
        }else if(prev!=null){
            prev.next = cur.next;
            cur.next = null;
        }else{
            return cur.next;
        }
        return head;
    }
}

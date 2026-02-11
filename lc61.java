public class lc61 {
    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        ListNode temp = head;
        ListNode prev = null;
        while(temp!=null){
            len++;
            prev = temp;
            temp = temp.next;
        }
        if(prev!=null) prev.next = head;
        if(len==0) return head;
        int kk = k%len;
        ListNode h1 = head;
        int counter = 0;
        int num = len-kk-1;
        while(h1!=null && counter<num){
            h1 = h1.next;
            counter++;
        }
        head = h1.next;
        h1.next = null;
        return head;
    }
}

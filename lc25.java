public class lc25 {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode res = new ListNode(0);
        res.next = helper(head,k);
        return res.next;
    }
    public ListNode helper(ListNode head,int k){
        ListNode temp = head;
        for(int i=0;i<k;i++){
            if(temp  == null) return head;
            temp = temp.next;
        }

        ListNode prev = null;
        ListNode cur = head;
        ListNode tempNode = null;
        int counter = 0;
        while(counter<k && cur!=null){
            tempNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNode;
            counter++;
        }
        
        head.next = helper(cur,k);
        return prev;
    }
}

public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

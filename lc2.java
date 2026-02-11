public class lc2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = 0;
        int num2 = 0;
        ListNode res = new ListNode(0);
        ListNode head = res;
        int carry = 0;
        while(l1!=null && l2!=null){
            int value = l1.val+l2.val+carry;
            carry = value/10;
            int actualval = value%10;
            res.next = new ListNode(actualval);
            l1 = l1.next;
            l2 = l2.next;
            res = res.next;
        }
        while(l1!=null){
            int value = l1.val+carry;
            carry = value/10;
            res.next = new ListNode(value%10);
            l1 = l1.next;
            res = res.next;
        }
        while(l2!=null){
            int value = l2.val+carry;
            carry = value/10;
            res.next = new ListNode(value%10);
            l2 = l2.next;
            res = res.next;
        }
        if(carry>0){
            res.next = new ListNode(carry);
        }
        return head.next;
    }
}

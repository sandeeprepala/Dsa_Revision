import java.util.*;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        boolean flag = false;
        ListNode hA = headA;
        ListNode hB = headB;
        while(hA!=null){
            set.add(hA);
            hA = hA.next;
        }
        while(hB!=null){
            if(set.contains(hB)) flag = true;
            hB = hB.next;
        }
        if(!flag) return null;
        hA = headA;
        hB = headB;
        while(true){
            if(hA == null) hA = headA;
            if(hB == null) hB = headB;
            if(hA == hB) return hA;
            hA = hA.next;
            hB = hB.next;
        }
    }
}

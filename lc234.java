import java.util.Stack;

public class lc234 {
    public boolean isPalindrome(ListNode head) {
        Stack<Integer> stack = new Stack<>();
        int len = 0;
        ListNode temp = head;
        while(temp!=null){
            len++;
            temp = temp.next;
        }
        int firstHalf = len/2;
        int counter = 0;
        while(head!=null && counter<firstHalf){
            stack.push(head.val);
            head = head.next;
            counter++;
        }
        if(len%2!=0) head = head.next;
        while(head!=null){
            if(head.val!=stack.peek()) return false;
            stack.pop();
            head = head.next;
        }
        if(stack.size()!=0 || head!=null) return false;
        return true;
    }
}

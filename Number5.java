import java.util.ArrayList;
import java.util.LinkedList;

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class Number5 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        LinkedList<ListNode> list = new LinkedList<ListNode>();
        ListNode p = listNode;
       	while(p != null) {
       		list.addFirst(p);
       		p = p.next;
       	}
       	ArrayList<Integer> ret = new ArrayList<Integer>();
       	p = list.pollFirst();
       	while(p  != null) {
       		ret.add(p.val);
       		p = list.pollFirst();
        }
        return ret;
    }

    public static void main(String[] args) {
    	ListNode a = new ListNode(1);
    	ListNode b = new ListNode(2);
    	ListNode c = new ListNode(3);
    	ListNode d = new ListNode(4);
    	a.next = b;
    	b.next = c;
    	c.next = d;
    	d.next = null;
    	System.out.println((new Number5()).printListFromTailToHead(d));
    	//System.out.println((new Number5()).printListFromTailToHead(a));
    }
}
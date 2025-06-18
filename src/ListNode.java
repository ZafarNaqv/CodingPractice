public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    
    @Override
    public String toString() {
          StringBuilder sb = new StringBuilder();
        ListNode temp = this;
        while(temp.next != null) {
            sb.append(temp.val).append(" ");
            temp = temp.next;
        }
    
        sb.append(temp.val);
        
        return sb.toString().trim();
    }
}
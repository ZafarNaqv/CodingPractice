public class MergeLists {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1, new ListNode(2,new ListNode(4)));
        ListNode list2 = new ListNode(1, new ListNode(3,new ListNode(4)));
        System.out.println(mergeTwoLists(list1,list2));
    }
    
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 ==null && list2 == null) return null;
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        ListNode list1Head = list1;
        ListNode list2Head = list2;
        ListNode result = new ListNode(-1);
        ListNode temp  = result;

        while(list1Head != null && list2Head != null) {
            if(list1Head.val < list2Head.val) {
                temp.next = list1Head;
                list1Head = list1Head.next;
            }else{
                temp.next = list2Head;
               list2Head = list2Head.next;
            }
            temp = temp.next;
        }
        
        if(list1Head != null) {
            temp.next = list1Head;
        }
        if(list2Head != null) {
            temp.next = list2Head;
        }
        return result.next;
    }
}
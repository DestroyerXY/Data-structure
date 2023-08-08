public class ListNode {
    int val;
    ListNode next;
    
    ListNode(int val) {
        this.val = val;
    }
    
    public static void main(String[] args) {
        LinkedListReverse reverse = new LinkedListReverse();
        
        // Создание и заполнение списка
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        
        head.next = second;
        second.next = third;
        third.next = fourth;
        
        // Вывод исходного списка
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
        
        System.out.println();
        
        // Разворот списка
        ListNode reversedHead = reverse.reverse(head);
        
        // Вывод развернутого списка
        current = reversedHead;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
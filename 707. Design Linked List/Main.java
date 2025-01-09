class MyLinkedList {
    private Node head;
    class Node{
        int val ;
        Node next ;
        Node(int val){
            this.val = val ;
        }
        Node(){}
    }

    public MyLinkedList() {
        this.head = new Node() ;        
    }
    
    public int get(int index) {
        int init = -1 ;
        Node curr = head;
        while( init < index && curr != null){
            curr = curr.next ;
            init += 1 ;
        }
        if(curr != null){
            return curr.val ;
        }
        return -1 ;
    }
    
    public void addAtHead(int val) {
        if(head.next != null){
            Node temp = head.next;
            head.next = new Node(val);
            head.next.next = temp ;
        }
        else{
            head.next = new Node(val);
        }
    }
    
    public void addAtTail(int val) {
        Node curr = head;
        while(curr.next != null){
            curr = curr.next ;
        }
        curr.next = new Node(val);
    }
    
    public void addAtIndex(int index, int val) {
        int init = -1 ;
        Node curr = head ;
        while(init < index-1 && curr != null){
            curr = curr.next;
            init += 1 ;
        }
        if(curr != null){
            Node temp = curr.next;
            curr.next = new Node(val);
            curr.next.next = temp ;
        }

    }
    
    public void deleteAtIndex(int index) {
        int init = -1;
        Node curr = head;
        while(init < index-1 && curr != null){
            curr = curr.next;
            init += 1 ;
        }
        if(curr != null){
            Node temp = curr.next;
            if(temp != null){
                curr.next = temp.next ;
            }
        }        
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */

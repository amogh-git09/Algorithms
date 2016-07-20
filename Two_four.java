public class Two_four{
  public static Node partition(Node head, int x){
    Node p = head;
    Node next = null, last = null, lesser = null, greater = null;

    while(p != null){
      next = p.next;
      if(p.data < x){
        if(lesser == null){
          lesser = p;
          lesser.next = null;
        } else {
          lesser.appendNodeToTail(p);
        }
        last = p;
      } else {
        if(greater == null){
          greater = p;
          greater.next = null;
        } else {
          greater.appendNodeToTail(p);
        }
      }
      p = next;
    }

    last.next = greater;
    return lesser;
  }

  public static void main(String[] args){
    Node head = new Node(3);
    head.appendToTail(5);
    head.appendToTail(1);
    head.appendToTail(2);
    head.appendToTail(2);
    head.printList();
    head = partition(head, 3);
    head.printList();
  }
}

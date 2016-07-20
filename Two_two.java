public class Two_two{
  public static Node findKthFromLast(Node head, int k){
    if(head == null)
      return null;

    int n = 1;
    Node last = head;
    while(last.next != null){
      last = last.next;
      n++;
    }

    if(k >= n)
      return null;

    Node p = head;
    for(int i=0; i<n-k-1; i++){
      p = p.next;
    }
    return p;
  }

  public Node findKthFromLast2(Node head, int k, IntWrapper i){
    if(head == null)
      return null;

    Node node = findKthFromLast2(head.next, k, i);
    i.value++;
    if(i.value == k)
      return head;
    return node;
  }

  public static void main(String[] args){
    Node head = new Node(3);
    head.appendToTail(5);
    head.appendToTail(5);
    head.appendToTail(3);
    head.appendToTail(4);
    head.appendToTail(1);
    head.printList();
    System.out.println("");
    // findKthFromLast(head, Integer.parseInt(args[0])).print();
    Two_two solver = new Two_two();
    IntWrapper wrap = new IntWrapper();
    solver.findKthFromLast2(head, Integer.parseInt(args[0]), wrap).print();
  }
}

class IntWrapper{
  int value = -1;
}

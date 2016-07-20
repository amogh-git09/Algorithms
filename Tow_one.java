import java.util.HashMap;

public class Two_one{
  public static void delDups(Node head){
    HashMap table = new HashMap<Integer, Boolean>();
    Node prev = null;
    n = head;
    while(n != null){
      if(table.containsKey(n.data))
        prev.next = n.next;
      else{
        prev = n;
        table.put(n.data, true);
      }
      n = n.next;
    }
  }

  public static void main(String[] args){
    Node head = new Node(5);
    head.appendToTail(3);
    head.appendToTail(4);
    head.appendToTail(5);
    head.appendToTail(2);
    head.appendToTail(5);
    head.print();
    System.out.println();
    delDups(head);
    head.print();
    System.out.println();
  }
}

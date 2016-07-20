public class LinkedListInsertionSort {
  public static void main(String[] args){
    MyLinkedList list = new MyLinkedList();
    list.insertVal(5);
    list.insertVal(2);
    list.insertVal(3);
    list.insertVal(1);
    list.insertVal(4);
    list.print();
    list = sort(list);
    list.print();
  }

  public static MyLinkedList sort(MyLinkedList list){
    MyLinkedList sortedList = new MyLinkedList();
    Node p = list.head;

    while(p != null){
      p = p.next;
      Node n = list.remove();

      if(sortedList.head == null){
        sortedList.insertNode(n);
      } else {
        Node pos = findPos(sortedList.head, n.val);

        if(pos.val < n.val){
          sortedList.insertNodeAfter(n, pos);
        } else{
          sortedList.insertNodeBefore(n, pos);
        }
      }

      sortedList.print();
    }

    return sortedList;
  }

  private static Node findPos(Node start, int val){
    Node p = start;
    while(p.val < val && p.next != null){
      p = p.next;
    }

    return p;
  }
}

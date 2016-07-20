public class LinkedListTest{
  public static void main(String[] args){
    MyLinkedList<Integer> list = new MyLinkedList<Integer>();
    list.insertVal(5);
    list.print();
    list.insertVal(10);
    list.print();
    Node<Integer> n1 = new Node<Integer>(6);
    Node<Integer> n2 = new Node<Integer>(7);
    list.insertNode(n1);
    list.insertNode(n2);
    list.print();
    list.insertValAfter(3, n1);
    list.print();
    list.remove().print();
    System.out.println("");
    list.print();
  }
}

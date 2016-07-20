public class MyLinkedList<T>{
  public Node<T> head;

  public MyLinkedList(){
    head = null;
  }

  public void insertVal(T val){
    Node<T> n = new Node<T>(val);
    insertNode(n);
  }

  public void insertNode(Node<T> n){
    if(head == null){
      head = n;
      return;
    }

    n.next = this.head;
    head = n;
  }

  public void insertValBefore(T val, Node<T> pos){
    Node<T> n = new Node<T>(val);
    insertNodeBefore(n, pos);
  }

  public void insertValAfter(T val, Node<T> pos){
    Node<T> n = new Node<T>(val);
    insertNodeAfter(n, pos);
  }

  public void insertNodeBefore(Node<T> n, Node<T> pos){
    Node<T> p = head;

    if(pos == head){
      insertNode(n);
      return;
    }

    //check if Pos is in the list
    while(p.next != pos && p != null){
      p = p.next;
    }

    if(p == null)
      return;

    n.next = p.next;
    p.next = n;
  }

  public void insertNodeAfter(Node<T> n, Node<T> pos){
    if(pos.next == null){
      n.next = null;
      pos.next = n;
    } else{
      insertNodeBefore(n, pos.next);
    }
  }

  public Node<T> remove(){
    if(head == null)
      return null;

    Node<T> n = head;
    head = head.next;
    n.next = null;
    return n;
  }

  public void print(){
    Node<T> p = head;
    while(p != null){
      System.out.printf(p.val.toString() + " -> ");
      p = p.next;
    }
    System.out.println("NULL");
  }
}

class Node<T>{
  public T val;
  public Node<T> next;

  public Node(T val){
    this.val = val;
  }

  public void print(){
    System.out.printf(val.toString());
  }
}

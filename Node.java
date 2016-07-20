public class Node{
  int data;
  Node next;

  public Node(int d){
    data = d;
    next = null;
  }

  public void appendToTail(int d){
    Node end = new Node(d);
    appendNodeToTail(end);
  }

  public void appendNodeToTail(Node p){
    Node n = this;
    while(n.next != null)
      n = n.next;
    n.next = p;
    p.next = null;
  }

  public Node appendBefore(int d){
    Node end = new Node(d);
    return appendNodeBefore(end);
  }

  public int size(){
    Node n = this;
    int count = 0;
    while(n != null){
      count++;
      n = n.next;
    }
    return count;
  }

  public Node appendNodeBefore(Node p){
    p.next = this;
    return p;
  }

  Node deleteNode(Node head, int d){
    Node n = head;

    if(n.data == d){
      head = head.next;
      n.next = null;
      return head;
    }

    while(n.next != null){
      if(n.next.data == d){
        n.next = n.next.next;
        return head;
      }
      n = n.next;
    }
    return head;
  }

  public void deleteLastNode(){
    if(this.next == null)
      return;

    Node n = this.next;
    while(n.next.next != null)
      n = n.next;
    n.next = null;
  }

  public Node reverseList(){
    Node n = new Node(this.data);
    Node p = this.next;
    while(p != null){
      n = n.appendBefore(p.data);
      p = p.next;
    }
    return n;
  }

  public Node getLastNode(){
    Node n = this;
    while(n.next != null){
      n = n.next;
    }
    return n;
  }

  public void print(){
    System.out.println(this.data);
  }

  public void printList(){
    Node n = this;
    while(n != null){
      System.out.printf("%d -> ", n.data);
      n = n.next;
    }
    System.out.printf("NULL\n");
  }
}

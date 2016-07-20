public class Two_six{
  public static Node checkCirle2(Node head){
    Node sr = head.next;
    Node fr = sr.next;

    while(sr != fr){
      sr = sr.next;
      fr = fr.next.next;
    }
    sr = head;
    while(sr != fr){
      sr = sr.next;
      fr = fr.next;
    }
    return sr;
  }

  public static Node checkCirle(Node head){
    Node n = head;
    while(n != null){
      Boolean flag = search(head, n, n.next);
      if(flag == true)
        return n.next;
      n = n.next;
    }
    return null;
  }

  public static Boolean search(Node start, Node end, Node node){
    Node n = start;
    while(n != end){
      if(n == node)
        return true;
      n = n.next;
    }
    return n == node;
  }

  public static void main(String[] args){
    Node cir = new Node(5);
    Node corrupt = new Node(3);
    cir.next = corrupt;
    cir.appendToTail(1);
    cir.appendToTail(6);
    Node last = cir.getLastNode();
    last.next = cir;

    System.out.printf("corrupt at: %d\n", checkCirle2(cir).data);
  }
}

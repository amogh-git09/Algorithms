public class Two_five {
  public static Node sum(Node head1, Node head2){
    Node p1 = head1, p2 = head2, sum = null;
    int n1, n2, s=0, c=0;
    while (!(p1 == null && p2 == null)){
      if(p1 != null)
        n1 = p1.data;
      else
        n1 = 0;
      if(p2 != null)
        n2 = p2.data;
      else
        n2 = 0;
      s = (n1 + n2 + c)%10;
      c = (n1 + n2 + c)/10;
      if(sum == null)
        sum = new Node(s);
      else
        sum.appendToTail(s);

      if(p1 != null)
        p1 = p1.next;
      if(p2 != null)
        p2 = p2.next;
    }

    if(c != 0)
      sum.appendToTail(1);
    return sum;
  }

  public static void correctPadding(PaddingHelper ph){
    int n1 = ph.head1.size();
    int n2 = ph.head2.size();

    if(n1 < n2){
      for(int i=0; i<(n2-n1); i++){
        ph.head1 = ph.head1.appendBefore(0);
      }
    } else {
        for(int i=0; i<(n1-n2); i++){
          ph.head2 = ph.head2.appendBefore(0);
        }
    }
  }

  public static int sumRec(Node head1, Node head2, SumHelper sh){
    int s=0, c=0;
    if(head1 == null || head2 == null)
      return 0;

    c = sumRec(head1.next, head2.next, sh);
    s = (head1.data + head2.data + c)%10;
    c = (head1.data + head2.data + c)/10;

    sh.sum = sh.sum.appendBefore(s);

    return c;
  }

  public static Node sum2(Node head1, Node head2){
    PaddingHelper ph = new PaddingHelper(head1, head2);
    correctPadding(ph);
    head1 = ph.head1;
    head2 = ph.head2;

    Node sum = new Node(-1);
    SumHelper sh = new SumHelper(sum, 0);
    sh.c = sumRec(head1, head2, sh);
    sum = sh.sum;

    if(sh.c != 0)
      sum = sum.appendBefore(1);

    sum.deleteLastNode();
    return sum;
  }

  public static void main(String[] args){
    Node head1 = new Node(6);
    head1.appendToTail(1);
    head1.appendToTail(7);
    Node head2 = new Node(2);
    head2.appendToTail(9);
    head2.appendToTail(5);
    head1.printList();
    head2.printList();
    Node sum = sum2(head1, head2);
    sum.printList();
  }
}

class PaddingHelper{
  Node head1;
  Node head2;

  public PaddingHelper(Node h1, Node h2){
    head1 = h1;
    head2 = h2;
  }
}

class SumHelper{
  Node sum;
  int c;

  public SumHelper(Node s, int c){
    this.sum = s;
    this.c = c;
  }
}

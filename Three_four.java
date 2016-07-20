public class Three_four{
  public static void hanoi(HanoiStack a, HanoiStack b, HanoiStack c, int n) throws Exception{
    if(n <= 0)
      return;

    hanoi(a, c, b, n-1);
    int t = a.pop();
    c.push(t);
    hanoi(b, a, c, n-1);
  }

  public static void main(String[] args){
    HanoiStack a = new HanoiStack();
    HanoiStack b = new HanoiStack();
    HanoiStack c = new HanoiStack();

    try{
      a.push(5);
      a.push(4);
      a.push(3);
      a.push(2);
      a.push(1);
      hanoi(a, b, c, 5);
      System.out.println(c.pop());
      System.out.println(c.pop());
      System.out.println(c.pop());
    } catch(Exception e){
      System.out.println(e.getMessage());
      return;
    }
  }
}

class HanoiStack{
  HanoiNode top;

  public HanoiStack(){
    top = null;
  }

  void push(int val) throws Exception{
    HanoiNode t = new HanoiNode(val);
    if(top == null){
      top = t;
      return;
    }

    if(top.data <= val)
      throw new Exception("value bigger than top");

    t.next = top;
    top = t;
  }

  int pop() throws Exception{
    if(top == null)
      throw new Exception("underflow!");

    int item = top.data;
    top = top.next;
    return item;
  }
}

class HanoiNode{
  int data;
  HanoiNode next;

  public HanoiNode(int d){
    next = null;
    data = d;
  }
}

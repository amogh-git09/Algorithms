public class Three_two{
  MinNode top;

  void push(int val){
    MinNode t = new MinNode(val);
    if(top == null){
      top = t;
      t.min = val;
      return;
    }

    if(top.min > val)
      t.min = val;
    else
      t.min = top.min;

    t.next = top;
    top = t;
  }

  Integer pop(){
    if(top == null)
      return null;
    int item = top.data;
    top = top.next;
    return item;
  }

  Integer min(){
    if(top == null)
      return null;

    return top.min;
  }

  public static void main(String[] args){
    Three_two stack = new Three_two();
    stack.push(5);
    stack.push(2);
    stack.push(3);
    stack.push(8);
    stack.push(1);
    System.out.println(stack.min());
  }
}

class MinNode{
  int data;
  int min;
  MinNode next;

  public MinNode(int data){
    this.data = data;
  }
}

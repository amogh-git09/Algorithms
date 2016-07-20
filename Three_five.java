public class Three_five{
  public static void main(String[] args){
    MyQueue q = new MyQueue();
    q.enqueue(1);
    q.enqueue(2);
    q.enqueue(3);
    q.enqueue(4);
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
    System.out.println(q.dequeue());
  }
}

class MyQueue{
  Stack stack1, stack2;

  public MyQueue(){
    stack1 = new Stack();
    stack2 = new Stack();
  }

  void enqueue(int val){
    stack1.push(val);
  }

  int dequeue(){
    pour(stack1, stack2);
    int item = stack2.pop();
    pour(stack2, stack1);
    return item;
  }

  private void pour(Stack stack1, Stack stack2){
    while(stack1.top != null){
      int t = stack1.pop();
      stack2.push(t);
    }
  }
}

class Stack{
  Node top;

  public Stack(){
    top = null;
  }

  void push(int val){
    Node t = new Node(val);
    if(top == null){
      top = t;
      return;
    }

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
}

class Node{
  int data;
  Node next;

  public Node(int d){
    next = null;
    data = d;
  }
}

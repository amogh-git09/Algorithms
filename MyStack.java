public class MyStack<T>{
  StackNode<T> top, bottom;
  int noOfElem;

  void push(T item){
    StackNode<T> t = new StackNode<T>(item);
    t.next = top;
    top = t;
    if(bottom == null)
      bottom = t;
    noOfElem++;
  }

  T pop(){
    if(top == null)
      return null;

    T item = top.data;
    top = top.next;
    if(top == null)
      bottom = null;
    noOfElem--;
    return item;
  }

  StackNode<T> popNode(){
    if(top == null)
      return null;

    StackNode<T> n = top;
    top = top.next;
    n.next = null;
    noOfElem--;
    return n;
  }

  StackNode<T> peekNode(){
    if(top == null)
      return null;

    return top;
  }

  boolean isEmpty(){
    return noOfElem <= 0;
  }

  T peek(){
    if(top == null)
      return null;

    return top.data;
  }

  public static void main(String[] args){
    MyStack<Integer> stack = new MyStack<Integer>();
    stack.push(1);
    stack.push(2);
    stack.push(3);
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }
}

class StackNode<T>{
  T data;
  StackNode<T> next;

  public StackNode(T item){
    data = item;
  }
}

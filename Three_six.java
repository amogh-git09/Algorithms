public class Three_six{
  public static void main(String[] args){
    Stack stack = new Stack();
    stack.push(3);
    stack.push(4);
    stack.push(1);
    stack.push(5);
    stack.push(2);

    stack = sort2(stack);

    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());
  }

  static void sort(Stack prim){
    Stack aux = new Stack();
    int size = 0;
    while(prim.top != null){
      int t = prim.pop();
      aux.push(t);
      size++;
    }
    while(aux.top != null){
      int t = aux.pop();
      prim.push(t);
    }

    sort(prim, aux, size);
  }

  static Stack sort2(Stack prim){
    Stack aux = new Stack();
    while(prim.top != null){
      int t = prim.pop();
      while(aux.top != null && aux.peek() > t){
        prim.push(aux.pop());
      }
      aux.push(t);
    }
    return aux;
  }

  static void sort(Stack prim, Stack aux, int size){
    if(size <= 0)
      return;

    int min = Integer.MAX_VALUE, cnt = 1;

    for(int i=0; i<size; i++){
      int t = prim.pop();
      aux.push(t);
      if(min > t){
        min = t;
        cnt = 1;
      } else if(min == t){
        cnt++;
      }
    }

    for(int i=0; i<cnt; i++){
      prim.push(min);
    }

    while(aux.top != null){
      int t = aux.pop();
      if(t != min)
        prim.push(t);
    }

    sort(prim, aux, size-1);
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

  Integer peek(){
    if(top != null)
      return top.data;
    return null;
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

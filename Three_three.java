import java.util.ArrayList;

public class Three_three{
  public static void main(String[] args){
    SetOfStacks setOfStacks = new SetOfStacks(3);
    setOfStacks.push(5);
    setOfStacks.push(2);
    setOfStacks.push(3);
    setOfStacks.push(7);
    setOfStacks.push(1);
    setOfStacks.push(5);
    setOfStacks.push(9);
    System.out.println("stackCount = " + setOfStacks.stackCount());
    System.out.println(setOfStacks.popAtIndex(0));
    System.out.println("stackCount = " + setOfStacks.stackCount());
    System.out.println(setOfStacks.popAtIndex(1));
    // System.out.println(setOfStacks.pop());
    // System.out.println(setOfStacks.pop());
    // System.out.println(setOfStacks.pop());
    // System.out.println(setOfStacks.pop());
    // System.out.println(setOfStacks.pop());
  }
}

class SetOfStacks{
  ArrayList<Stack> stacks;
  int capacity;

  public int stackCount(){
    return stacks.size();
  }

  public SetOfStacks(int cap){
    stacks = new ArrayList<Stack>();
    capacity = cap;
  }

  void push(int val){
    Stack last = getLastStack();
    if(last == null || last.isFull()){
      last = new Stack(capacity);
      stacks.add(last);
    }

    last.push(val);
  }

  Integer pop(){
    Stack last = getLastStack();
    if(last == null)
      return null;

    Integer item = last.pop();
    if(last.size == 0)
      stacks.remove(stacks.size()-1);

    return item;
  }

  Integer popAtIndex(int index){
    if(index >= stacks.size())
      return null;
    Stack stack = stacks.get(index);
    int item = stack.pop();
    leftShift(index);
    return item;
  }

  void leftShift(int index){
    if(index >= stacks.size()-1){
      return;
    }

    Stack stack = stacks.get(index+1);
    int v = stack.removeFromBot();
    if(stack.size == 0){
      stacks.remove(stacks.size()-1);
    }
    stacks.get(index).push(v);
    leftShift(index+1);
  }

  Stack getLastStack(){
    if(stacks.size() == 0)
      return null;
    return stacks.get(stacks.size() - 1);
  }
}

class Stack{
  Node top, bot;
  int capacity, size;

  public Stack(int capacity){
    top = bot = null;
    size = 0;
    this.capacity = capacity;
  }

  boolean isFull(){
    return size >= capacity;
  }

  boolean push(int val){
    if(isFull())
      return false;

    Node t = new Node(val);
    if(top == null){
      top = bot = t;
      size++;
      return true;
    }

    join(t, top);
    top = t;
    size++;
    return true;
  }

  Integer pop(){
    if(top == null)
      return null;
    int item = top.data;
    top = top.below;

    if(top == null)
      bot = null;
    else
      top.above = null;

    size--;
    return item;
  }

  Integer removeFromBot(){
    if(bot == null)
      return null;
    int item = bot.data;
    bot = bot.above;

    if(bot == null)
      top = null;
    else
      bot.below = null;

    size--;
    return item;
  }

  private void join(Node above, Node below){
    if(above != null) above.below = below;
    if(below != null) below.above = above;
  }


}

class Node{
  int data;
  Node above, below;

  public Node(int data){
    this.data = data;
  }
}

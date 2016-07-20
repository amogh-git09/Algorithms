public class StackTest{
  public static void main(String[] args){
    MyStack<String> stack = new MyStack<String>();
    stack.push("hello");
    stack.push("world");
    stack.print();
    try {
      System.out.println(stack.pop());
      System.out.println(stack.pop());
      System.out.println(stack.pop());
    } catch(StackEmptyException e){
      System.out.println("Exception: " + e);
    }
  }
}

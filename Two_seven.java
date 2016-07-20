import java.util.Stack;

public class Two_seven{
  public static Boolean checkPalindrome(Node head){
    Node reverse = head.reverseList();
    Node n1 = head;
    Node n2 = reverse;

    while(n1 != null){
      if(n1.data != n2.data)
        return false;
      n1 = n1.next;
      n2 = n2.next;
    }
    return true;
  }

  public static Boolean checkPalindrome2(Node head){
    Node slow = head;
    Node fast = head;
    Stack<Integer> stack = new Stack<Integer>();

    while(fast != null && fast.next != null){
      stack.push(slow.data);
      slow = slow.next;
      fast = fast.next.next;
    }

    if(fast != null)
      slow = slow.next;

    while(slow != null){
      if(slow.data != stack.pop())
        return false;
      slow = slow.next;
    }
    return true;
  }

  public static void main(String[] args){
    Node head1 = new Node(1);
    head1.appendToTail(2);
    head1.appendToTail(3);
    head1.appendToTail(2);
    head1.appendToTail(3);
    head1.printList();
    System.out.println(checkPalindrome2(head1));
  }
}

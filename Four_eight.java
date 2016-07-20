import java.util.LinkedList;
public class Four_eight{
  public static Boolean matchTrees(BinarySearchTreeNode a, BinarySearchTreeNode b){
    if(a == null && b == null)
      return true;
    if(a == null || b == null)
      return false;
    if(a.key != b.key)
      return false;
    return matchTrees(a.left, b.left) && matchTrees(a.right, b.right);
  }

  public static Boolean isSubTree(BinarySearchTreeNode a, BinarySearchTreeNode b){
    LinkedList<BinarySearchTreeNode> queue = new LinkedList<BinarySearchTreeNode>();
    queue.add(a);
    while(!queue.isEmpty()){
      BinarySearchTreeNode n = queue.remove();
      if(n.key == b.key)
        if(matchTrees(n, b))
          return true;
      if(n.left != null)
        queue.add(n.left);
      if(n.right != null)
        queue.add(n.right);
    }

    return false;
  }

  public static void main(String[] args){
    BinarySearchTreeNode one = new BinarySearchTreeNode(1);
    BinarySearchTreeNode two = new BinarySearchTreeNode(2);
    BinarySearchTreeNode three = new BinarySearchTreeNode(3);
    BinarySearchTreeNode four = new BinarySearchTreeNode(4);
    BinarySearchTreeNode five = new BinarySearchTreeNode(5);
    BinarySearchTreeNode six = new BinarySearchTreeNode(6);
    BinarySearchTreeNode seven = new BinarySearchTreeNode(7);
    BinarySearchTreeNode eight = new BinarySearchTreeNode(8);

    one.left = two;
    one.right = three;
    two.left = four;
    two.right = five;
    three.left = six;
    five.left = seven;
    seven.left = eight;

    BinarySearchTreeNode three2 = new BinarySearchTreeNode(3);
    BinarySearchTreeNode six2 = new BinarySearchTreeNode(6);

    three2.left = six2;

    System.out.println(BinarySearchTreeNode.InOrderFootPrint(one));
    System.out.println(BinarySearchTreeNode.InOrderFootPrint(three2));
    System.out.println(isSubTree(one, three2));
  }
}

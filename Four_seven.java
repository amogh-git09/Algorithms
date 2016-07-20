public class Four_seven{
  public static TwoNodes correctDepth(BinarySearchTreeNode a, BinarySearchTreeNode b){
    if(a.depth() == b.depth()){
      return new TwoNodes(a,b);
    }
    if(a.depth() > b.depth())
      return correctDepth(a.parent, b);
    else
      return correctDepth(a, b.parent);
  }

  public static BinarySearchTreeNode fca(BinarySearchTreeNode a, BinarySearchTreeNode b){
    TwoNodes nodes = correctDepth(a, b);
    a = nodes.a;
    b = nodes.b;

    while(a != b){
      a = a.parent;
      b = b.parent;
    }
    return a;
  }

  public static BinarySearchTreeNode fca(BinarySearchTreeNode root, BinarySearchTreeNode a, BinarySearchTreeNode b){
    Boolean aLeft = false, bLeft = false;
    if(BinarySearchTreeNode.findNode(root.left, a)) aLeft = true;
    if(BinarySearchTreeNode.findNode(root.left, b)) bLeft = true;
    if(aLeft && bLeft)
      return fca(root.left, a, b);
    if(!aLeft && !bLeft)
      return fca(root.right, a, b);
    return root;
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
    two.parent = one;
    one.right = three;
    three.parent = one;
    two.left = four;
    four.parent = two;
    two.right = five;
    five.parent = two;
    three.left = six;
    six.parent = three;
    five.left = seven;
    seven.parent = five;
    seven.left = eight;
    eight.parent = seven;

    System.out.println(BinarySearchTreeNode.InOrderFootPrint(one));
    System.out.println(BinarySearchTreeNode.PreOrderFootPrint(one));
    System.out.println(BinarySearchTreeNode.PostOrderFootPrint(one));
    System.out.printf("%d\n", fca(one, eight, six).key);
  }
}

class TwoNodes{
  BinarySearchTreeNode a;
  BinarySearchTreeNode b;

  public TwoNodes(BinarySearchTreeNode a, BinarySearchTreeNode b){
    this.a = a;
    this.b = b;
  }

  public TwoNodes(){
    a = null;
    b = null;
  }
}

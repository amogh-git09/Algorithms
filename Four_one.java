public class Four_one{
  public static Boolean isBalanced(BinarySearchTreeNode root){
    return Math.abs((root.left.height() - root.right.height())) <= 1;
  }

  public static void main(String[] args){
    BinarySearchTreeNode bst = new BinarySearchTreeNode(4);
    bst.insert(2);
    bst.insert(1);
    bst.insert(3);
    bst.insert(5);
    bst.insert(6);
    bst.printTree();
    System.out.println(isBalanced(bst));
  }
}

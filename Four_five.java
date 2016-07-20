public class Four_five{
  public static Boolean checkBst(BinarySearchTreeNode root, int min, int max){
    if(root == null)
      return true;

    if(!(root.key >= min && root.key < max))
      return false;

    return checkBst(root.left, min, root.key)
        && checkBst(root.right, root.key, max);
  }

  public static Boolean checkBst(BinarySearchTreeNode root){
    return checkBst(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public static void main(String[] args){
    int[] a = {1,2,3,4,5,6,7,8,9,10};
    BinarySearchTreeNode correct = Four_three.bstGen2(a, 0, a.length-1);
    System.out.println(checkBst(correct));

    BinarySearchTreeNode eight = new BinarySearchTreeNode(8);
    BinarySearchTreeNode four = new BinarySearchTreeNode(4);
    BinarySearchTreeNode six = new BinarySearchTreeNode(6);
    BinarySearchTreeNode seven = new BinarySearchTreeNode(7);
    BinarySearchTreeNode nine = new BinarySearchTreeNode(9);
    BinarySearchTreeNode ten = new BinarySearchTreeNode(10);
    BinarySearchTreeNode eleven = new BinarySearchTreeNode(11);
    BinarySearchTreeNode thirteen = new BinarySearchTreeNode(13);
    BinarySearchTreeNode one = new BinarySearchTreeNode(1);

    six.left = four;
    six.right = eleven;
    four.left = one;
    eleven.left = ten;
    eleven.right = thirteen;
    ten.left = nine;
    nine.left = seven;
    seven.right = eight;

    System.out.println(checkBst(eight));

    BinarySearchTreeNode twenty = new BinarySearchTreeNode(20);
    BinarySearchTreeNode thirty = new BinarySearchTreeNode(30);
    BinarySearchTreeNode twentyfive = new BinarySearchTreeNode(25);
    BinarySearchTreeNode ten2 = new BinarySearchTreeNode(10);

    twenty.left = ten2;
    ten2.right = twentyfive;
    twenty.right = thirty;
    System.out.println(checkBst(twenty));
  }
}

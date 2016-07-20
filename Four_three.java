public class Four_three{
  public static BinarySearchTreeNode bstGen(int[] a, int l, int r, BinarySearchTreeNode root){
    if(l > r)
      return null;

    int m = (l + r)/2;
    if(root == null)
      root = new BinarySearchTreeNode(a[m]);
    else
      root.insert(a[m]);

    bstGen(a, l, m-1, root);
    bstGen(a, m+1, r, root);
    return root;
  }

  public static BinarySearchTreeNode getBst(int[] a){
    BinarySearchTreeNode bst = null;
    bst = bstGen(a, 0, a.length-1, bst);
    return bst;
  }

  public static BinarySearchTreeNode bstGen2(int[] a, int l, int r){
    if(l>r)
      return null;

    int m = (l+r)/2;
    BinarySearchTreeNode root = new BinarySearchTreeNode(a[m]);
    root.left = bstGen2(a, l, m-1);
    root.right = bstGen2(a, m+1, r);
    return root;
  }

  public static void main(String[] args){
    int[] a = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15};
    // BinarySearchTreeNode bst = getBst(a);
    BinarySearchTreeNode bst = bstGen2(a,0,a.length-1);
    bst.printTree();
    System.out.println("height = " + bst.height());
  }
}

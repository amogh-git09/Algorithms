import java.util.LinkedList;
public class BinarySearchTreeNode{
  int key;
  BinarySearchTreeNode left, right, parent;

  public BinarySearchTreeNode(int key){
    this.key = key;
    left = right = parent = null;
  }

  public void insert(int val){
    if(val <= this.key){
      if(this.left == null)
        this.left = new BinarySearchTreeNode(val);
      else
        this.left.insert(val);
    } else {
      if(this.right == null)
        this.right = new BinarySearchTreeNode(val);
      else
        this.right.insert(val);
    }
  }

  public static String InOrderFootPrint(BinarySearchTreeNode root){
    if(root == null)
      return "-1";

    return (InOrderFootPrint(root.left) + " " +
        root.key + " " +
        InOrderFootPrint(root.right)).trim();
  }

  public static String PreOrderFootPrint(BinarySearchTreeNode root){
    if(root == null)
      return "-1";

    return (root.key + " " +
        PreOrderFootPrint(root.left) + " " +
        PreOrderFootPrint(root.right)).trim();
  }

  public static String PostOrderFootPrint(BinarySearchTreeNode root){
    if(root == null)
      return "-1";

    return (PostOrderFootPrint(root.left) + " " +
        PostOrderFootPrint(root.right) + " " +
        root.key).trim();
  }

  //true if a is a descendent of root
  public static Boolean findNode(BinarySearchTreeNode root, BinarySearchTreeNode a){
    if(root == null)
      return false;
    if(root == a)
      return true;
    return findNode(root.left, a) || findNode(root.right, a);
  }

  public int depth(){
    if(this.parent == null)
      return 0;
    return this.parent.depth() + 1;
  }

  public void printTree(){
    LinkedList<BinarySearchTreeNode> queue = new LinkedList<BinarySearchTreeNode>();
    queue.add(this);

    while(!queue.isEmpty()){
      BinarySearchTreeNode node = queue.remove();
      System.out.printf("%d  ", node.key);
      if(node.left != null) queue.add(node.left);
      if(node.right != null) queue.add(node.right);
    }
    System.out.println("");
  }

  public void dfs(){
    System.out.printf("%d  ", this.key);
    if(this.left != null)
      this.left.dfs();
    if(this.right != null)
      this.right.dfs();
  }

  public int height(){
    if(left == null && right == null)
      return 0;
    if(right == null)
      return left.height() + 1;
    if(left == null)
      return right.height() + 1;
    return Math.max(left.height(), right.height())+1;
  }
}

// public class BinarySearchTree{
//   BinaryTreeNode root;
//
//   public BinarySearchTree(){
//     root = null;
//   }
//   public BinarySearchTree(int key){
//     root = new BinaryTreeNode(key);
//   }
//
//   public void insert(int val){
//     if(val <= root.)
//   }
// }

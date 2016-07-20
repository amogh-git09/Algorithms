public class BinarySearchTreeNode{
  int key;
  TreeNode left, right;

  public BinaryTreeNode(int key){
    this.key = key;
    left = right = null;
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

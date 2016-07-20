import java.util.LinkedList;
import java.util.ArrayList;
public class Four_four{
  public static void genLists(
    ArrayList<LinkedList<BinarySearchTreeNode>> lists,
    BinarySearchTreeNode root, int depth){
    if(root == null)
      return;

    if(lists.size()-1 < depth)
      lists.add(new LinkedList<BinarySearchTreeNode>());

    lists.get(depth).add(root);
    genLists(lists, root.left, depth+1);
    genLists(lists, root.right, depth+1);
  }

  public static void main(String[] args){
    BinarySearchTreeNode eight = new BinarySearchTreeNode(8);
    BinarySearchTreeNode four = new BinarySearchTreeNode(4);
    BinarySearchTreeNode six = new BinarySearchTreeNode(6);
    BinarySearchTreeNode seven = new BinarySearchTreeNode(7);
    BinarySearchTreeNode nine = new BinarySearchTreeNode(9);
    BinarySearchTreeNode ten = new BinarySearchTreeNode(10);
    BinarySearchTreeNode eleven = new BinarySearchTreeNode(11);
    BinarySearchTreeNode thirteen = new BinarySearchTreeNode(13);
    BinarySearchTreeNode one = new BinarySearchTreeNode(1);

    eight.left = four;
    eight.right = one;
    four.left = six;
    four.right = seven;
    six.left = nine;
    six.right = ten;
    seven.right = eleven;
    eleven.left = thirteen;

    ArrayList<LinkedList<BinarySearchTreeNode>> lists =
      new ArrayList<LinkedList<BinarySearchTreeNode>>();
    genLists(lists, eight, 0);

    int depth = 0;
    for(LinkedList<BinarySearchTreeNode> list: lists){
      System.out.printf("Depth %d: ", depth);
      for(BinarySearchTreeNode node : list){
        System.out.printf("%d -> ", node.key);
      }
      System.out.println("NULL");
      depth++;
    }
  }
}

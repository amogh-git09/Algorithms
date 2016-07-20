import java.util.ArrayList;
import java.util.LinkedList;
public class GraphNode{
  int key;
  ArrayList<GraphNode> adjacent;
  Boolean visited;

  public GraphNode(int key){
    this.key = key;
    this.adjacent = new ArrayList<GraphNode>();
    visited = false;
  }

  public void addNeighborNode(GraphNode n){
    this.adjacent.add(n);
  }
}

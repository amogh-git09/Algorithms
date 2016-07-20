import java.util.ArrayList;
import java.util.LinkedList;
public class Graph{
  int nextNode;
  ArrayList<GraphNode> nodes;

  public Graph(){
    nextNode = 0;
    nodes = new ArrayList<GraphNode>();
  }

  public int addVertex(){
    nodes.add(new GraphNode(nextNode));
    return nextNode++;
  }

  public void addEdge(int a, int b){
    if(a >= nextNode || b >= nextNode){
      return;
    }

    nodes.get(a).addNeighborNode(nodes.get(b));
  }

  public Boolean edgeExists(int a, int b){
    return nodes.get(a).adjacent.contains(nodes.get(b));
  }

  public Boolean routeExists(int a, int b){
    LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
    queue.add(nodes.get(a));

    for(GraphNode n : nodes){
      n.visited = false;
    }

    while(!queue.isEmpty()){
      GraphNode node = queue.remove();
      if(node.visited == true)
        continue;

      if(node == nodes.get(b))
        return true;

      for(GraphNode n : node.adjacent){
        queue.add(n);
      }
      node.visited = true;
    }

    return false;
  }
}

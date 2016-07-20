import java.util.LinkedList;
public class Four_two{
  public static Boolean routeExists(GraphNode a, GraphNode b){
    LinkedList<GraphNode> queue = new LinkedList<GraphNode>();
    queue.add(a);
    while(!queue.isEmpty()){
      GraphNode node = queue.remove();
      if(node.visited == false && node == b){
        return true;
      }

      for(GraphNode tmp : node.adjacent){
        queue.add(tmp);
      }
    }

    return false;
  }

  public static void main(String[] args){
    Graph graph = new Graph();
    for(int i=0; i<5; i++)
      graph.addVertex();

    graph.addEdge(0, 1);
    graph.addEdge(0, 2);
    graph.addEdge(2, 4);
    graph.addEdge(1, 3);
    graph.addEdge(4, 3);
    System.out.println(graph.routeExists(0, 4));
  }
}

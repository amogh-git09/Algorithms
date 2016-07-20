import java.io.FileNotFoundException;
import java.lang.NullPointerException;
import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;

public class Dijkstra{
  public static void main(String[] args){
    // DijkstraGraph graph = new DijkstraGraph();
    // DijkstraNode n1 = new DijkstraNode();
    // DijkstraNode n2 = new DijkstraNode();
    // DijkstraNode n3 = new DijkstraNode();
    // DijkstraNode n4 = new DijkstraNode();
    // DijkstraNode n5 = new DijkstraNode();
    // DijkstraNode n6 = new DijkstraNode();
    // DijkstraNode n7 = new DijkstraNode();
    //
    // n1.addEdge(new Edge(n2, 5));
    // n2.addEdge(new Edge(n3, 9));
    // n2.addEdge(new Edge(n4, 6));
    // n3.addEdge(new Edge(n5, 4));
    // n3.addEdge(new Edge(n6, 6));
    // n4.addEdge(new Edge(n6, 6));
    // n4.addEdge(new Edge(n7, 8));
    //
    // graph.addNode(n1);
    // graph.addNode(n2);
    // graph.addNode(n3);
    // graph.addNode(n4);
    // graph.addNode(n5);
    // graph.addNode(n6);
    // graph.addNode(n7);

    TriangleReader reader = new TriangleReader();
    DijkstraGraph graph = reader.readTriangle("test.txt");
    System.out.println(dijkstra(graph));
  }

  static void init(ArrayList<DijkstraNode> nodes){
    for(DijkstraNode n : nodes){
      n.val = 0;
    }
  }

  public static int dijkstra(DijkstraGraph graph){
    init(graph.nodes);
    LinkedList<DijkstraNode> queue = new LinkedList<DijkstraNode>();
    queue.add(graph.nodes.get(0));
    while(!queue.isEmpty()){
      DijkstraNode n = queue.remove();
      if(n.visited)
        continue;
      for(Edge e : n.edges){
        if(e.end.val < (n.val + e.weight))
          e.end.val = n.val + e.weight;
        queue.add(e.end);
      }
      n.visited = true;
    }

    return greatestLeaf(graph);
  }

  static int greatestLeaf(DijkstraGraph graph){
    int max = 0;
    for(DijkstraNode n : graph.nodes){
      if((n.edges.size() == 0) && (max < n.val))
        max = n.val;
    }

    return max;
  }
}

class DijkstraNode{
  int val;
  LinkedList<Edge> edges;
  boolean visited;

  public DijkstraNode(){
    val = 0;
    edges = new LinkedList<Edge>();
    visited = false;
  }

  public DijkstraNode(int val){
    this.val = val;
    edges = new LinkedList<Edge>();
    visited = false;
  }

  public void addEdge(Edge e){
    edges.add(e);
  }
}

class Edge{
  DijkstraNode end;
  int weight;

  public Edge(DijkstraNode end, int weight){
    this.end = end;
    this.weight = weight;
  }
}

class DijkstraGraph{
  ArrayList<DijkstraNode> nodes;

  public DijkstraGraph(){
    nodes = new ArrayList<DijkstraNode>();
  }

  public void addNode(DijkstraNode n){
    nodes.add(n);
  }

  public DijkstraNode addNewNode(){
    DijkstraNode n = new DijkstraNode();
    addNode(n);
    return n;
  }
}

class TriangleReader{
  public DijkstraGraph readTriangle(String fileName){
    try{
      Scanner sc = new Scanner(new File(fileName)).useDelimiter("\n");
      DijkstraGraph graph = new DijkstraGraph();
      DijkstraNode zeroNode = graph.addNewNode();
      int nodeCount = 0;
      int line = 1;

      while(sc.hasNext()){
        String[] list = sc.next().split(" ");

        //skip if line not valid
        if(list.length != line){
          System.out.println("Warning: Line " + line + " not valid, skipping");
          continue;
        }

        DijkstraNode newNode = graph.addNewNode();
        boolean flag = true;
        int i = 0;
        int j = nodeCount - line + 2;

        if(line == 1){
          zeroNode.addEdge(new Edge(newNode, Integer.parseInt(list[0])));
        } else {
          for(int k=0; k<(line-1)*2; k++){
            graph.nodes.get(j).addEdge(new Edge(newNode, Integer.parseInt(list[i])));

            if(flag){
              i++;
              newNode = graph.addNewNode();
            } else {
              j++;
            }

            flag = !flag;
          }
        }

        nodeCount += line;
        line++;
      }

      return graph;
    } catch(NullPointerException e){
      return null;
    } catch(FileNotFoundException e){
      return null;
    }
  }
}

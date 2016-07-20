import java.util.HashMap;
import java.util.ArrayList;
import java.awt.Point;
public class Seven_six{
  public static void main(String[] args){
    Point[] points = {new Point(1,1),
                      new Point(2,2),
                      new Point(3,3),
                      new Point(1,4),
                      new Point(1,5),
                      new Point(1,6),
                     };
    System.out.println(maxPointLine(points));
  }

  static Line maxPointLine(Point[] points){
    HashMap<Double, ArrayList<Line>> lineTable = new HashMap<Double, ArrayList<Line>>();
    Line bestLine = null;
    int bestCount = 0;

    for(int i=0; i<points.length; i++){
      for(int j=i+1; j<points.length; j++){
        Line line = new Line(points[i], points[j]);
        insertIntoTable(lineTable, line);
        int count = countEquivLines(lineTable, line);
        if(count > bestCount){
          bestCount = count;
          bestLine = line;
        }
      }
    }
    return bestLine;
  }

  static void insertIntoTable(HashMap<Double, ArrayList<Line>> lineTable, Line line){
    Double key = Line.floorToNearestEpsilon(line.slope);
    if(lineTable.containsKey(key)){
      lineTable.get(key).add(line);
    } else {
      ArrayList<Line> lines = new ArrayList<Line>();
      lines.add(line);
      lineTable.put(key, lines);
    }
  }

  static int countEquivLines(HashMap<Double, ArrayList<Line>> lineTable, Line line){
    Double key = Line.floorToNearestEpsilon(line.slope);
    Double epsilon = Line.epsilon;
    return countEquivalentLines(lineTable.get(key), line) +
        countEquivalentLines(lineTable.get(key+epsilon), line) +
        countEquivalentLines(lineTable.get(key-epsilon), line);
  }

  static int countEquivalentLines(ArrayList<Line> list, Line line){
    if(list == null)
      return 0;

    int cnt = 0;
    for(Line l: list){
      if(line.equals(l))
        cnt++;
    }
    return cnt;
  }
}

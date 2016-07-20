import java.awt.Point;
public class Seven_five{
  public static void main(String[] args){
    Square s1 = new Square(0, 0, 2);
    Square s2 = new Square(10, 0.5, 1);
    System.out.println(sameCut(s1, s2));
    System.out.println(( (double)( (int)(0.495869584/0.0001)) )*0.0001);
  }

  static boolean sameCut(Square s1, Square s2){
    //horizontal
    Line l1 = new Line(s1.x, s1.y + s1.side/2, s1.x + s1.side, s1.y + s1.side/2);
    Line l2 = new Line(s2.x, s2.y + s2.side/2, s2.x + s2.side, s2.y + s2.side/2);
    if(l1.equals(l2))
      return true;

    //vertical
    l1 = new Line(s1.x + s1.side/2, s1.y, s1.x + s1.side/2, s1.y + s1.side);
    l2 = new Line(s2.x + s2.side/2, s2.y, s2.x + s2.side/2, s2.y + s2.side);
    if(l1.equals(l2))
      return true;

    //diagonal 1
    l1 = new Line(s1.x, s1.y, s1.x + s1.side, s1.y + s1.side);
    l2 = new Line(s2.x, s2.y, s2.x + s2.side, s2.y + s2.side);
    if(l1.equals(l2))
      return true;

    //diagonal 1
    l1 = new Line(s1.x, s1.y + s1.y + s1.side, s1.x + s1.side, s1.y);
    l2 = new Line(s2.x, s2.y + s2.y + s2.side, s2.x + s2.side, s2.y);
    if(l1.equals(l2))
      return true;

    return false;
  }
}

class Line{
  double slope;
  double yIntercept;
  double xIntercept;
  boolean vertical;
  static final double epsilon = 0.0001;

  public Line(Point a, Point b){
    this(a.x, a.y, b.x, b.y);
  }

  public Line(double x1, double y1, double x2, double y2){
    if(x2-x1 == 0){
      vertical = true;
      xIntercept = x1;
    } else {
      slope = Math.abs((y2-y1)/(x2-x1));
      yIntercept = (y1-y2)*x1/(x2-x1) + y1;
    }
  }

  public boolean equals(Line line2){
    if(vertical){
      if(!line2.vertical)
        return false;

      return Math.abs(xIntercept - line2.xIntercept) < epsilon;
    }

    return (Math.abs(slope - line2.slope) < epsilon) && (Math.abs(yIntercept - line2.yIntercept) < epsilon);
  }

  public static double floorToNearestEpsilon(Double d){
    int r = (int) (d/epsilon);
    return ((double) r)*epsilon;
  }

  public String toString(){
    if(vertical){
      return "Vertical, slope: " + slope;
    } else {
      return "slope: " + slope + ", yIntercept: " + yIntercept;
    }
  }
}

class Square{
  double x, y;
  double side;

  public Square(double x, double y, double s){
    this.x = x;
    this.y = y;
    this.side = s;
  }
}

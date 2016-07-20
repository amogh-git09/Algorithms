class Solution {
    static final long LIMIT = 2147483647;

    public int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
        // write your code in Java SE 8
        boolean intersect = pointInside(K, L, M, N, P, Q) ||
                            pointInside(K, L, M, N, R, Q) ||
                            pointInside(K, L, M, N, R, S) ||
                            pointInside(K, L, M, N, P, S);

        boolean secondInFirst =    pointInside(K, L, M, N, P, Q) &&
                                   pointInside(K, L, M, N, R, Q) &&
                                   pointInside(K, L, M, N, R, S) &&
                                   pointInside(K, L, M, N, P, S);

        boolean firstInSecond =    pointInside(P, Q, R, S, K, L) &&
                                   pointInside(P, Q, R, S, M, L) &&
                                   pointInside(P, Q, R, S, M, N) &&
                                   pointInside(P, Q, R, S, K, N);

        if(secondInFirst){
          long area = getArea(K, L, M, N);
          return normalize(area);
        } else if(firstInSecond){
          long area = getArea(P, Q, R, S);
          return normalize(area);
        } else if(intersect){
          if(pointInside(K, L, M, N, R, S) && pointInside(P, Q, R, S, K, L)){
            return normalize(getArea(K, L, M, N) + getArea(P, Q, R, S) - getArea(K, L, R, S));
          }
          if(pointInside(K, L, M, N, P, S) && pointInside(P, Q, R, S, M, L)){
            return normalize(getArea(K, L, M, N) + getArea(P, Q, R, S) - getArea(P, L, M, S));
          }
          if(pointInside(K, L, M, N, P, Q) && pointInside(P, Q, R, S, M, N)){
            return normalize(getArea(K, L, M, N) + getArea(P, Q, R, S) - getArea(P, Q, M, N));
          }
          if(pointInside(K, L, M, N, R, Q) && pointInside(P, Q, R, S, K, N)){
            return normalize(getArea(K, L, M, N) + getArea(P, Q, R, S) - getArea(K, Q, R, N));
          }

          if(pointInside(K, L, M, N, P, S) && pointInside(K, L, M, N, R, S)){
            return normalize(getArea(K, L, M, N) + getArea(P, Q, R, S) - getArea(P, L, R, S));
          }
          if(pointInside(K, L, M, N, P, Q) && pointInside(K, L, M, N, P, S)){
            return normalize(getArea(K, L, M, N) + getArea(P, Q, R, S) - getArea(P, Q, M, S));
          }
          if(pointInside(K, L, M, N, P, Q) && pointInside(K, L, M, N, R, Q)){
            return normalize(getArea(K, L, M, N) + getArea(P, Q, R, S) - getArea(P, Q, R, N));
          }
          if(pointInside(K, L, M, N, R, Q) && pointInside(K, L, M, N, R, S)){
            return normalize(getArea(K, L, M, N) + getArea(P, Q, R, S) - getArea(K, Q, R, S));
          }

          if(pointInside(P, Q, R, S, K, N) && pointInside(P, Q, R, S, M, N)){
            return normalize(getArea(K, L, M, N) + getArea(P, Q, R, S) - getArea(K, Q, M, N));
          }
          if(pointInside(P, Q, R, S, K, L) && pointInside(P, Q, R, S, K, N)){
            return normalize(getArea(K, L, M, N) + getArea(P, Q, R, S) - getArea(K, L, R, N));
          }
          if(pointInside(P, Q, R, S, K, L) && pointInside(P, Q, R, S, M, L)){
            return normalize(getArea(K, L, M, N) + getArea(P, Q, R, S) - getArea(K, L, M, S));
          }
          if(pointInside(P, Q, R, S, M, L) && pointInside(P, Q, R, S, M, N)){
            return normalize(getArea(K, L, M, N) + getArea(P, Q, R, S) - getArea(P, L, M, N));
          }
        }

        return normalize(getArea(P, Q, R, S) + normalize(getArea(K, L, M, N)));
    }

    private int normalize(long area){
      if(area > LIMIT)
        return -1;
      else
        return (int) area;
    }

    private boolean pointInside (int x1, int y1, int x2, int y2, int x, int y){
      return (x1 < x && x < x2) && (y1 < y && y < y2);
    }

    private long getArea(int x1, int y1, int x2, int y2){
      int len = x2 - x1;
      int bre = y2 - y1;
      long area = len*bre;
      return area;
    }
}

public class Rakuten {
  public static void main(String[] args){
    Solution s = new Solution();
    s.solution(0, 0, 5, 5, 1, 1, 2, 2);
  }
}

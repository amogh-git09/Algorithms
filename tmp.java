publi// you can also use imports, for example:
// import java.util.*;

// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");

class Solution {
    public int solution(int K, int L, int M, int N, int P, int Q, int R, int S) {
        // write your code in Java SE 8
        boolean intersect = doesIntersect(K, L, M, N, P, Q) ||
                            doesIntersect(K, L, M, N, R, Q) ||
                            doesIntersect(K, L, M, N, R, S) ||
                            doesIntersect(K, L, M, N, P, S);
        System.out.println(intersect)
    }

    private static boolean doesIntersect (int x1, int y1, int x2, int y2, int x, int y){
      return (x1 < x && x < x2) && (y1 < y && y < y2);
    }
}

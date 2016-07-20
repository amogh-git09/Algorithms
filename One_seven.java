import java.util.ArrayList;

public class One_seven{
  public static void zeroSetter(int[][] A, int m, int n){
    ArrayList<Integer> rows = new ArrayList<Integer>();
    ArrayList<Integer> cols = new ArrayList<Integer>();

    mark(A, m, n, rows, cols);

    for(int i=0; i<rows.size(); i++){
      int row = rows.get(i);

      //set row to zero
      for(int j=0; j<n; j++)
        A[row][j] = 0;
    }

    for(int i=0; i<cols.size(); i++){
      int col = cols.get(i);

      //set row to zero
      for(int j=0; j<m; j++)
        A[j][col] = 0;
    }
  }

  public static void mark(int[][] A, int m, int n, ArrayList<Integer> rows, ArrayList<Integer> cols){
    for(int i=0; i<m; i++){
      for(int j=0; j<n; j++){
        if(A[i][j] == 0){
          if(!rows.contains(i))
            rows.add(i);
          if(!cols.contains(j))
            cols.add(j);
        }
      }
    }
  }

  public static void main(String[] args){
    int[][] img = new int[][]{
      {1,2,3,4},
      {4,0,6,4},
      {7,8,9,0}
    };

    for(int i=0; i<img.length; i++){
      for(int j=0; j<img[0].length; j++)
        System.out.printf("%d ", img[i][j]);
      System.out.println("");
    }
    System.out.println("");
    zeroSetter(img, img.length, img[0].length);
    for(int i=0; i<img.length; i++){
      for(int j=0; j<img[0].length; j++)
        System.out.printf("%d ", img[i][j]);
      System.out.println("");
    }
  }
}

public class One_six{
  public static void rotate(int[][] img){
    int[][] ret = new int[img.length][img[0].length];
    int n = img.length;
    int r,c,count;

    for(int k=0; k<n; k++){
      if(n <= 1){
        ret[k][k] = img[k][k];
        break;
      }

      //Top edge -> Right edge
      r = k;
      for(c=k; c<k+n; c++){
        ret[c][k+n-1] = img[r][c];
      }

      //Right edge -> Bottom edge
      c = k+n-1; count=0;
      for(r=k; r<k+n; r++){
        ret[k+n-1][k+n-count-1] = img[r][c];
        count++;
      }

      //Bottom edge -> Left edge
      r = k+n-1;
      for(c=k; c<k+n; c++){
        ret[c][k] = img[r][c];
      }

      //Left edge -> Top edge
      c = k; count = 0;
      for(r=k; r<k+n; r++){
        ret[k][k+n-count-1] = img[r][c];
        count++;
      }

      n -= 2;
    }

    for(int i=0; i<ret.length; i++){
      for(int j=0; j<ret[0].length; j++)
        System.out.printf("%d ", ret[i][j]);
      System.out.println("");
    }
    System.out.println("");

    //copy
    for(r=0; r<img.length; r++){
      for(c=0; c<img.length; c++){
        img[r][c] = ret[r][c];
      }
    }
  }

  public static void rotate2(int[][] img){
    int n = img.length;
    int k;

    for(k=0; k<n/2; k++){
      int first = k;
      int last = n-k-1;

      for(int i = first; i<last; i++){
        int temp = img[first][i];
        img[first][i] = img[last-i][first];
        img[last-i][first] = img[last][last-i];
        img[last][last-i] = img[first+i][last];
        img[first+i][last] = temp;
      }
    }
  }

  public static void main(String[] args){
    int[][] img = new int[][]{
      {1,2,3},
      {4,5,6},
      {7,8,9}
    };

    for(int i=0; i<img.length; i++){
      for(int j=0; j<img[0].length; j++)
        System.out.printf("%d ", img[i][j]);
      System.out.println("");
    }
    System.out.println("");
    rotate2(img);
    for(int i=0; i<img.length; i++){
      for(int j=0; j<img[0].length; j++)
        System.out.printf("%d ", img[i][j]);
      System.out.println("");
    }
  }
}

import java.util.ArrayList;

public class BucketSort{
  static int range = 100;

  static void sort(int[] a){
    ArrayList<ArrayList<Integer>> buckets = new ArrayList<ArrayList<Integer>>();

    for(int i=0; i<range; i++){
      buckets.add(new ArrayList<Integer>());
    }

    for(int i=0; i<a.length; i++){
      buckets.get(a[i]).add(a[i]);
    }

    int k=0;
    for(int i=0; i<range; i++){
      for(Integer j : buckets.get(i)){
        a[k++] = j;
      }
    }
  }

  public static void main(String[] args){
    int[] a = {5, 3, 4, 1, 2, 5, 3, 34, 22, 99};
    sort(a);
    for(int i=0; i<a.length; i++){
      System.out.println(a[i]);
    }
  }
}

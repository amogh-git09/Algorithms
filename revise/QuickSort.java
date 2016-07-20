import java.util.Random;
public class QuickSort{
  static int cnt=0;
  static void quickSort(int[] a, int l, int r){
    if(l >= r)
      return;

    System.out.println("count = " + ++cnt);
    Random rand = new Random();
    int index = l + rand.nextInt(r-l+1);
    swap(a, index, r);
    int wall = l, pivot = a[r];
    for(int i=l; i<r; i++){
      if(a[i] < pivot){
        swap(a, i, wall);
        wall++;
      }
    }
    swap(a, wall, r);
    quickSort(a, l, wall-1);
    quickSort(a, wall+1, r);
  }

  static void swap(int[] a, int i, int j){
    int tmp = a[i];
    a[i] = a[j];
    a[j] = tmp;
  }

  public static void main(String[] args){
    int[] a = {5, 3, 4, 1, 2};
    quickSort(a, 0, a.length-1);
    for(int i=0; i<a.length; i++){
      System.out.println(a[i]);
    }
  }
}

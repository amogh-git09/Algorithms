public class BinarySearch{
  public static int search(int[] a, int l, int r, int x){
    if(l > r)
      return -1;

    int m = (l+r)/2;
    if(a[m] == x)
      return m;

    if(a[m] < x)
      return search(a, m+1, r, x);
    else
      return search(a, l, m-1, x);
  }

  public static void main(String[] args){
    int[] a = {1, 2, 5, 6, 7, 9};
    System.out.println(search(a, 0, a.length-1, 3));
  }
}

public class MergeSort{
  private static void merge(int[] a, int p, int q, int r){
    int n1 = q-p+1;
    int n2 = r-q;
    int[] arr1 = new int[n1+1];
    int[] arr2 = new int[n2+1];

    int j=0;
    for(int i=p; i<=q; i++)
      arr1[j++] = a[i];

    j=0;
    for(int i=q+1; i<=r; i++)
      arr2[j++] = a[i];

    arr1[n1] = Integer.MAX_VALUE;
    arr2[n2] = Integer.MAX_VALUE;

    int i=0, k=p; j=0;

    while(k <= r){
      if(arr1[i] <= arr2[j])
        a[k++] = arr1[i++];
      else
        a[k++] = arr2[j++];
    }
  }

  public static void sort(int[] a, int l, int r){
    if(l < r){
      int m = (l+r)/2;
      sort(a, l, m);
      sort(a, m+1, r);
      merge(a, l, m, r);
    }
  }

  public static void main(String[] args){
    int[] a = {5, 3, 4, 1, 2};
    sort(a, 0, a.length-1);
    for(int i=0; i<a.length; i++){
      System.out.println(a[i]);
    }
  }
}

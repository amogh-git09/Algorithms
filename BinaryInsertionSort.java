public class BinaryInsertionSort{
  public static void main(String[] args){
    int[] arr = new int[args.length];

    for(int i=0; i<args.length; i++){
      arr[i] = Integer.parseInt(args[i]);
    }

    sort(arr);
    for(int i=0; i<args.length; i++){
      System.out.printf("%d ", arr[i]);
    }
    System.out.println("");
  }

  public static int search(int arr[], int l, int r, int x){
    if(l >= r)
      return x>arr[l]?l+1:l;

    int m = (l+r)/2;
    if(arr[m] < x){
      return search(arr, m+1, r, x);
    } else {
      return search(arr, l, m-1, x);
    }
  }

  public static void sort(int[] arr){
    int n = arr.length;

    for(int i=1; i<n; i++){
      int key = arr[i];
      int j;

      int pos = search(arr, 0, i, arr[i]);

      for(j=i-1; j>=pos; j--){
        arr[j+1] = arr[j];
      }
      arr[pos] = key;
    }
  }

  public static void swap(int[] arr, int a, int b){
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

}

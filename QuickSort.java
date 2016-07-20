public class QuickSort {
  public static void sort(int arr[], int l, int r){
    if(l >= r)
      return;

    int wall = l;
    int pivot = arr[r];

    for(int i=l; i<r; i++){
      if(arr[i] < pivot){
        swap(arr, wall, i);
        wall++;
      }
    }
    swap(arr, wall, r);
    sort(arr, l, wall-1);
    sort(arr, wall+1, r);
  }

  public static void swap(int arr[], int a, int b){
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  public static void main(String[] args){
    int[] arr = new int[args.length];

    for(int i=0; i<args.length; i++){
      arr[i] = Integer.parseInt(args[i]);
    }

    sort(arr, 0, arr.length-1);
    for(int i=0; i<args.length; i++){
      System.out.printf("%d ", arr[i]);
    }
    System.out.println("");
  }
}

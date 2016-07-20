public class HeapSort{
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

  public static void sort(int arr[]){
    int n = arr.length;

    //build heap
    for(int i = (n/2 - 1); i >= 0; i--){
      heapify(arr, i, n);
    }

    for(int i=n-1; i>0; i--){
      swap(arr, 0, i);
      heapify(arr, 0, i);
    }
  }

  public static void swap(int arr[], int a, int b){
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }

  public static void heapify(int arr[], int i, int n){
    int largest = i;
    int l = 2*i + 1;
    int r = 2*i + 2;

    if(l < n && arr[largest] < arr[l])
      largest = l;

    if(r < n && arr[largest] < arr[r])
      largest = r;

    if(largest != i){
      swap(arr, i, largest);
      heapify(arr, largest, n);
    }
  }
}

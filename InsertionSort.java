public class InsertionSort{
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

  public static void sort(int[] arr){
    int n = arr.length;

    for(int i=1; i<n; i++){
      int key = arr[i];
      int j;
      for(j=i-1; j>=0; j--){
        if(arr[j] > key){
          swap(arr, j, j+1);
        } else {
          break;
        }
      }
      arr[j+1] = key;
    }
  }

  public static void swap(int[] arr, int a, int b){
    int tmp = arr[a];
    arr[a] = arr[b];
    arr[b] = tmp;
  }
}

public class BubbleSort{
  public static void sort(int arr[]){
    int n = arr.length;

    for(int i=0; i<n-1; i++){
      for(int j=0; j<n-i-1; j++){
        if(arr[j] > arr[j+1]){
          int tmp = arr[j];
          arr[j] = arr[j+1];
          arr[j+1] = tmp;
        }
      }
    }
  }

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
}

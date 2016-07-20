public class BinarySearch{
  public static int search(int arr[], int l, int r, int x){
    int m = (l + r)/2;

    if(arr[m] == x){
      return m;
    } else if(l == r){
      return -1;
    } else if(arr[m] < x){
      return search(arr, m+1, r, x);
    } else {
      return search(arr, l, m-1, x);
    }
  }

  public static void main(String[] args){
    int[] arr = new int[args.length-1];
    int x = Integer.parseInt(args[args.length-1]);

    for(int i=0; i<args.length-1; i++){
      arr[i] = Integer.parseInt(args[i]);
    }

    System.out.println(search(arr, 0, arr.length-1, x));
  }
}

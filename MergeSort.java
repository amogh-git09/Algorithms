public class MergeSort {
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

  public static void sort(int arr[], int l, int r){
    if(l >= r){
      return;
    }

    int m = (l + r)/2;
    sort(arr, l, m);
    sort(arr, m+1, r);
    merge(arr, l, m, r);
  }

  public static void merge(int arr[], int p, int q, int r){
    int n1 = q - p + 1;
    int n2 = r - q;
    int[] lArr = new int[n1];
    int[] rArr = new int[n2];

    for(int i=0; i<n1; i++){
      lArr[i] = arr[p+i];
    }
    for(int i=0; i<n2; i++){
      rArr[i] = arr[q+i+1];
    }

    int i = 0; int j = 0;
    int k = p;

    while(i < n1 && j < n2){
      if(lArr[i] <= rArr[j]){
        arr[k] = lArr[i];
        i++;
      } else {
        arr[k] = rArr[j];
        j++;
      }
      k++;
    }

    while(i < n1){
      arr[k] = lArr[i];
      i++;
      k++;
    }

    while(j < n2){
      arr[k] = rArr[j];
      j++;
      k++;
    }
  }
}

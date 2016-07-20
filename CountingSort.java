public class CountingSort{
  public static void main(String[] args){
    char[] arr = new char[args.length];

    for(int i=0; i<args.length; i++){
      arr[i] = args[i].charAt(0);
    }

    arr = sort(arr);
    for(int i=0; i<args.length; i++){
      System.out.printf("%c ", arr[i]);
    }
    System.out.println("");
  }

  public static char[] sort(char arr[]){
    int[] count = new int[256];
    char[] out = new char[arr.length];

    for(int i=0; i<arr.length; i++){
      int c = (int) arr[i];
      count[c]++;
    }

    for(int i=1; i<count.length; i++){
      count[i] += count[i-1];
    }

    for(int i=0; i<arr.length; i++){
      int index = (int) arr[i];

      if(count[index] > 0){
        out[count[index]-1] = arr[i];
        count[index]--;
      }
    }

    return out;
  }
}

public class One_three{
  public static void main(String[] args){
    // System.out.println(isPermutation2(args[0], args[1]));
    System.out.println(isPermutation4("Amogh Rathore", "Rathore Amogh"));
  }

  public static boolean isPermutation(String s1, String s2){
    if(s1.length() != s2.length())
      return false;

    char[] str1 = s1.toCharArray();
    char[] str2 = s2.toCharArray();

    for(int i = 0; i < str1.length; i++){
      boolean flag = true;

      for(int j = 0; j < str2.length; j++){
        if(str1[i] == str2[j]){
          str2[j] = (char) 0;
          flag = false;
          break;
        }
      }

      if(flag)
        return false;
    }

    return true;
  }

  public static boolean isPermutation3(String s1, String s2){
    char[] str1 = s1.toCharArray();
    char[] str2 = s2.toCharArray();

    java.util.Arrays.sort(str1);
    java.util.Arrays.sort(str2);

    s1 = new String(str1);
    s2 = new String(str2);

    return s1.equals(s2);
  }

  public static boolean isPermutation4(String s1, String s2){
    int[] ascii = new int[256];

    for(char c : s1.toCharArray()){
      ascii[(int) c]++;
    }

    for(char c : s2.toCharArray()){
      if(--ascii[(int) c] < 0)
        return false;
    }

    return true;
  }

  public static boolean isPermutation2(String s1, String s2){
    int n = s1.length();
    if(n != s2.length())
      return false;

    char[] str1 = s1.toCharArray();
    char[] str2 = s2.toCharArray();

    for(int i = n/2 - 1; i >= 0; i--){
      heapify(str1, i, n);
      heapify(str2, i, n);
    }

    for(int i = 0; i < n; i++){
      char c1 = extractMin(str1, (n-i));
      char c2 = extractMin(str2, (n-i));
      System.out.printf("str1: %c, str2: %c\n", c1, c2);
      if(c1 != c2)
        return false;
    }

    return true;
  }

  public static char extractMin(char[] str, int n){
    char c = str[0];
    str[0] = str[n-1];
    heapify(str, 0, n-1);
    return c;
  }

  public static void heapify(char[] str, int i, int n){
    int smallest = i;
    int l = 2*i + 1;
    int r = 2*i + 2;

    if(l < n && str[l] < str[smallest])
      smallest = l;
    if(r < n && str[r] < str[smallest])
      smallest = r;

    if(smallest != i){
      char tmp = str[smallest];
      str[smallest] = str[i];
      str[i] = tmp;

      heapify(str, smallest, n);
    }
  }
}

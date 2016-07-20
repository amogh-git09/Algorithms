public class One_five{
  public static String compress(String s){
    char[] str = s.toCharArray();
    StringBuilder comp = new StringBuilder();
    int i=0; int j=1;

    if(str.length <= 1){
      return s;
    }

    while(i < str.length){
      while(j < str.length && str[i] == str[j])
        j++;
      int len = j-i;
      comp.append(str[i]);
      comp.append(len + "");
      i = j;
    }

    return comp.length()<s.length()?comp.toString():s;
  }

  private static String compress2(String s){
    if(compressCount(s) >= s.length())
      return s;

    char[] str = s.toCharArray();
    char[] comp = new char[compressCount(s)];
    int i=0; int j=1; int k=0;

    if(str.length <= 1){
      return s;
    }

    while(i < str.length){
      while(j < str.length && str[i] == str[j])
        j++;
      int len = j-i;
      // comp[k++] = str[i];
      k = setChar(comp, str[i], k, len);
      // comp.append(str[i]);
      // comp.append(len + "");
      i = j;
    }

    return new String(comp);
  }

  private static int setChar(char[] arr, char c, int index, int count){
    arr[index++] = c;
    char[] cnt = String.valueOf(count).toCharArray();
    for(char ch : cnt)
      arr[index++] = ch;

    return index;
  }

  private static int compressCount(String s){
    if(s.length() == 0)
      return 0;

    int count = 1; int size = 0;
    char last = s.charAt(0);

    for(int i=1; i<s.length(); i++){
      if(last == s.charAt(i))
        count++;
      else{
        size += 1 + String.valueOf(count).length();
        last = s.charAt(i);
        count = 1;
      }
    }

    size += 1 + String.valueOf(count).length();
    return size;
  }

  public static void main(String[] args){
    String s = "aaaamogeeee";
    System.out.println(compress2(s));
    System.out.println(compress(s));
  }
}

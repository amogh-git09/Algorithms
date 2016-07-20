public class One_one{
  public static void main(String[] args){
    System.out.println(isUnique3(args[0]));
  }

  public static boolean isUnique(String s){
    boolean flag = true;
    int[] arr = new int[256];
    for(int i=0; i<s.length(); i++){
      arr[(int) s.charAt(i)]++;
      if(arr[(int) s.charAt(i)] > 1){
        flag = false;
        break;
      }
    }
    return flag;
  }

  public static boolean isUnique2(String s){
    for(int i=0; i<s.length(); i++){
      char c = s.charAt(i);
      for(int j=i+1; j<s.length(); j++){
        char ch = s.charAt(j);
        if(ch == c)
          return false;
      }
    }

    return true;
  }

  public static boolean isUnique3(String s){
    int checker = 0;
    for(int i = 0; i < s.length(); i++){
      int val = s.charAt(i) - 'a';
      if((checker & (1 << val)) > 0)
        return false;
      checker |= (1 << val);
    }
    return true;
  }
}

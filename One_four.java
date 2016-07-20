public class One_four{
  public static String replace(String s){
    int count = 0;
    char[] str = s.toCharArray();
    for(int i=0; i<str.length; i++){
      if(str[i] == ' ')
        count++;
    }

    char[] ret = new char[str.length + count*2];

    for(int i=0; i<str.length; i++){
      ret[i] = str[i];
    }

    int lastIndex = str.length-1;
    for(int i=0; i<=lastIndex; i++){
      if(ret[i] == ' '){
        System.out.printf("ret[%d] is space\n", i);
        for(int j=lastIndex; j>=i; j--){
          System.out.printf("ret[%d] = %c\n", j+2, ret[j]);
          ret[j+2] = ret[j];
        }
        ret[i] = '%';
        ret[i+1] = '2';
        ret[i+2] = '0';
        i += 2;
        lastIndex += 2;
      }
    }

    return new String(ret);
  }

  public static String replace2(String s){
    int spaces=0;
    char[] tmp = s.toCharArray();
    for(int i=0; i<tmp.length; i++){
      if(tmp[i] == ' ')
        spaces++;
    }


    int newlen = tmp.length + 2*spaces;
    char[] str = new char[newlen];

    for(int i=0; i<tmp.length; i++){
      str[i] = tmp[i];
    }

    for(int i=tmp.length-1; i>=0; i--){
      if(str[i] == ' '){
        str[newlen-1] = '0';
        str[newlen-2] = '2';
        str[newlen-3] = '%';
        newlen = newlen-3;
      } else {
        str[newlen-1] = str[i];
        newlen--;
      }
    }

    return new String(str);
  }

  public static void main(String[] args){
    String s = "a  rat ";
    s = replace2(s);
    System.out.println(s);
  }
}

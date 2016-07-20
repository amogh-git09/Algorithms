public class BitManip{
  public static Boolean getBit(int num, int i){
    return ((1 << i) & num) != 0;
  }

  public static String boolToBit(Boolean b){
    if(b)
      return "1";
    else
      return "0";
  }

  public static String toBinary(int num, int bits){
    StringBuilder out = new StringBuilder();
    for(int i=bits-1; i>=0; i--){
      out.append(boolToBit(getBit(num, i)));
    }
    return out.toString();
  }

  public static String toBinary(byte b){
    StringBuilder out = new StringBuilder();
    for(int i=0; i<8; i++){
      if((b & 1) == 0){
        out.append("0");
      } else{
        out.append("1");
      }
      b = (byte) (b >> 1);
    }
    out.reverse();
    return out.toString();
  }

  public static String toBinary(Double num){
    StringBuilder out = new StringBuilder();
    out.append(".");
    while(num>0){
      if(out.length() >= 64){
        return "ERROR";
      }

      double r = 2.0*num;
      if(r >= 1){
        out.append("1");
        num = r - 1;
      } else {
        out.append("0");
        num = r;
      }
    }

    return out.toString();
  }

  public static void main(String[] args){
    System.out.println(toBinary(0.12550));
  }
}

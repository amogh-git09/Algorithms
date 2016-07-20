public class Five_five{
  public static int bitsReqtToConv(int m, int n){
    int xor = m ^ n;
    int cnt = 0;
    while(xor != 0){
      if((xor & 1) != 0)
        cnt++;
      xor = xor >> 1;
    }

    return cnt;
  }

  public static void main(String[] args){
    int m = 31;
    int n = 14;
    System.out.println(BitManip.toBinary(m, 6));
    System.out.println(BitManip.toBinary(n, 6));
    System.out.println(bitsReqtToConv(m, n));
  }
}

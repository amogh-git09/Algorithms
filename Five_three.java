public class Five_three{
  public static int next(int n){
    int c = n;
    int c1 = 0, p = 0;
    while(c != 0 && ((c & 1) == 0)){
      p++;
      c = c>>1;
    }

    while(c != 0 && ((c & 1) != 0)){
      c1++;
      p++;
      c = c>>1;
    }
    //error
    if(p == 31){
      return -1;
    }

    n = (1<<p) | n;
    n = (~((1 << p) - 1)) & n;
    n = ((1<<(c1-1)) - 1) | n;
    return n;
  }

  public static int prev(int n){
    int c = n, c1 = 0, p = 0;
    while((c != 0) && ((c & 1) != 0)){
      c1++;
      p++;
      c = c>>1;
    }
    System.out.printf("p = %d, c1 = %d\n", p, c1);
    while((c != 0) && ((c & 1) == 0)){
      System.out.println(BitManip.toBinary(c, 6));
      p++;
      c = c>>1;
    }
    System.out.printf("p = %d, c1 = %d\n", p, c1);

    if(p == 31)
      return -1;

    n = (~(1<<p)) & n;        //flip
    System.out.println(BitManip.toBinary(n, 6));
    n = (~((1<<p) - 1)) & n;  //set clear bits from p-1 through 0
    System.out.println(BitManip.toBinary(n, 6));
    int mask = ((1<<p) - 1) & (~((1 << (p-c1-1)) - 1));
    n = mask|n;
    System.out.println(BitManip.toBinary(n, 6));
    return n;
  }

  public static void main(String[] args){
    int q = 22;
    int r = next(q);
    int p = prev(q);
    System.out.println(BitManip.toBinary(q, 6) + "  :  " + q);
    System.out.println(BitManip.toBinary(r, 6) + "  :  " + r);
    System.out.println(BitManip.toBinary(p, 6) + "  :  " + p);
  }
}

public class Five_six{
  public static int swapsBits(int x){
    return ((x & 0x55555555) << 1) | ((x & 0xaaaaaaaa) >> 1);
  }

  public static void main(String[] args){
    int m = 98;
    int n = swapsBits(m);
    System.out.println(BitManip.toBinary(m, 8));
    System.out.println(BitManip.toBinary(n, 8));
  }
}

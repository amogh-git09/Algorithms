public class Seven_four{
  static int negate(int a){
    int neg = 0;
    int d = a>0?-1:1;
    while(a != 0){
      neg += d;
      a += d;
    }
    return neg;
  }

  static int multiply(int a, int n){
    int n2 = n<0?negate(n):n;
    int a2 = a<0?negate(a):a;
    int mul = 0;

    for(int i=0; i<n2; i++)
      mul += a2;

    if((n<0 && a>0) || (a<0 && n>0)){
      return negate(mul);
    }
    return mul;
  }

  //returns a-b
  static int subtract(int a, int b){
    return a + negate(b);
  }

  static int divide(int a, int b){
    int a2 = a<0?negate(a):a;
    int b2 = b<0?negate(b):b;
    int div = 0;
    int n = b2;

    while(n <= a2){
      n += b2;
      div++;
    }

    if((a<0 && b>0) || (b<0 && a>0))
      return negate(div);
    return div;
  }

  public static void main(String[] args){
    System.out.println(negate(5));
    System.out.println(multiply(10, -1));
    System.out.println(subtract(100, 20));
    System.out.println(divide(-10000, -800));
  }
}

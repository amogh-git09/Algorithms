public class Prime{
  static boolean primeSlightlyBetter(int n){
    long time = System.currentTimeMillis();
    if(n < 2){
      return false;
    }

    System.out.println("sqrt = " + Math.sqrt(n));
    for(int i=2; i<Math.sqrt(n); i++){
      if(n%i == 0){
        return false;
      }
    }
    System.out.println("Time taken = " + (System.currentTimeMillis()-time));
    return true;
  }

  static boolean naivePrime(int n){
    long time = System.currentTimeMillis();
    if(n < 2){
      return true;
    }

    for(int i=2; i<n; i++){
      if(n%i == 0){
        return false;
      }
    }
    System.out.println("Time taken = " + (System.currentTimeMillis()-time));
    return true;
  }

  public static void main(String[] args){
    // System.out.println(primeSlightlyBetter(6));
    // System.out.println(primeSlightlyBetter(11));
    // System.out.println(primeSlightlyBetter(14));
    System.out.println(naivePrime(91744613));
    System.out.println(primeSlightlyBetter(91744613));
  }
}

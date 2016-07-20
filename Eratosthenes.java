public class Eratosthenes{
  public static boolean[] sieveOfEratosthenes(int max){
    boolean[] flags = new boolean[max+1];
    init(flags);
    int prime = 2;

    while(prime <= Math.sqrt(max)){
      crossOff(flags, prime);
      prime = nextPrime(flags, prime);
      if(prime >= flags.length){
        break;
      }
    }
    return flags;
  }

  static void init(boolean[] flags){
    for(int i=2; i<flags.length; i++){
      flags[i] = true;
    }
  }

  static int nextPrime(boolean[] flags, int prime){
    prime++;
    while(prime < flags.length && flags[prime] == false){
      prime++;
    }
    return prime;
  }

  static void crossOff(boolean[] flags, int prime){
    for(int i=prime*prime; i<flags.length; i+=prime){
      flags[i] = false;
    }
  }

  public static void main(String[] args){
    int max = 1000;
    boolean[] sieve = sieveOfEratosthenes(max);
    for(int i=0; i<max; i++){
      if(sieve[i]){
        System.out.println(i);
      }
    }
  }
}

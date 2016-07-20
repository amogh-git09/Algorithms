public class Test{
  public static int func(int x){
    if(x == 1){
      return 1;
    }

    int a = (noOfDivisors(x)%2)==0?0:1;
    return func(x-1) + a;
  }

  public static int noOfDivisors(int a){
    int b = a/2;
    int cnt = 1;
    for(int i = 1; i <= b; i++){
      if(a%i == 0)
        cnt++;
    }
    return cnt;
  }

  public static void main(String[] args){
    for(int i=0; i<10; i++){

    }
    System.out.println(i);
  }
}

public class One_eight{
  public static boolean isRotation(String s1, String s2){
    return (s2 + s2).contains(s1.subSequence(0, s1.length()));
  }

  public static void main(String[] args){
    System.out.println(isRotation("waterbottle", "erbottlewat"));
  }
}

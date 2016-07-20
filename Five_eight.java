public class Five_eight{
  public static void drawHorizontal(byte[] screen, int w,
                                      int x1, int x2, int y){
    int startByte = (y*w)/8 + (x1/8);
    int startBit = x1 % 8;
    int endByte = (y*w)/8 + x2/8;
    int endBit = x2%8;

    if(startByte == endByte){
      screen[startByte] = (byte)(((1 << (8 - startBit)) - 1) &
                              (~((1 << (7-endBit)) - 1)));
    } else {
      screen[startByte] = (byte) ((1 << (8 - startBit)) - 1);
      screen[endByte] = (byte) (~((1 << (7-endBit)) - 1));
      for(int i = startByte+1; i < endByte; i++){
        screen[i] = ~0;
      }
    }
  }

  public static void main(String[] args){
    int width = 3*8;
    int size = 6;
    byte[] screen = new byte[size];
    for(int i = 0; i < size; i++){
      System.out.printf("%s ", BitManip.toBinary(screen[i]));
      if((i+1) % (width/8) == 0)
        System.out.println("");
    }

    drawHorizontal(screen, width, 1, 22, 1);
    System.out.println("");
    for(int i = 0; i < size; i++){
      System.out.printf("%s ", BitManip.toBinary(screen[i]));
      if((i+1) % (width/8) == 0)
        System.out.println("");
    }
  }
}

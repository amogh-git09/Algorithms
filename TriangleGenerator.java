import java.util.Random;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TriangleGenerator{
  public void generateTriangle(String outputFileName, int height){
    Random r = new Random();
    PrintWriter writer = null;

    try{
      writer = new PrintWriter(outputFileName);
      for(int i=1; i<=height; i++){
        for(int j=0; j<i; j++){
          int num = r.nextInt(201);
          writer.print(num + " ");
        }
        writer.println("");
      }
    } catch(FileNotFoundException e){

    } finally{
      writer.close();
    }
  }

  public static void main(String[] args){
    TriangleGenerator generator = new TriangleGenerator();
    generator.generateTriangle(args[0], Integer.parseInt(args[1]));
  }
}

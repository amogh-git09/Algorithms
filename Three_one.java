public class Three_one{
  int stackSize = 2;
  int[] buffer = new int[stackSize*3];
  int[] stackPointer = {-1, -1, -1};

  void push(int stackNum, int val) throws Exception{
    if(stackPointer[stackNum] + 1 >= stackSize){
      throw new Exception("Out of space");
    }

    stackPointer[stackNum]++;
    buffer[absTopOfStack(stackNum)] = val;
  }

  int pop(int stackNum) throws Exception{
    if(stackPointer[stackNum] == -1){
      throw new Exception("Underflow");
    }

    int item = buffer[absTopOfStack(stackNum)];
    stackPointer[stackNum]--;
    return item;
  }

  int peek(int stackNum) {
    int index = absTopOfStack(stackNum);
    return buffer[index];
  }

  boolean isEmpty(int stackNum){
    return stackPointer[stackNum] == -1;
  }

  int absTopOfStack(int stackNum){
    return stackNum*stackSize + stackPointer[stackNum];
  }

  void print(){
    for(int i=0; i<stackSize*3; i++){
      System.out.printf("%d ", buffer[i]);
    }
    System.out.println("");
  }

  public static void main(String[] args){
    Three_one stack = new Three_one();
    try{
      stack.push(0, 1);
      stack.push(0, 2);
      stack.push(2, 1);
      stack.push(2, 2);
      stack.push(1, 5);
      stack.print();
    } catch (Exception e){
      System.out.println(e.getMessage());
    }
  }
}

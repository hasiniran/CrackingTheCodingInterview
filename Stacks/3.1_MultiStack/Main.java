import java.util.Arrays;

class Main {
  public static void main(String[] args) {
    int size = 5;
    int numbStacks = 3;
    MultiStack multiStack = new MultiStack(size, numbStacks);

  int i=0;
  for(int s = 0; s<3; s++){
    for(int j=0;j<3;j++){
      multiStack.push(s, i++);
    }
  }

  System.out.println("values after push: " + Arrays.toString(multiStack.values));

  multiStack.push(2, 87);
  System.out.println("values after push: " + Arrays.toString(multiStack.values));
  
  multiStack.push(2, 88);
  System.out.println("values after push: " + Arrays.toString(multiStack.values));
  
  multiStack.push(2, 89);
  System.out.println("values after push: " + Arrays.toString(multiStack.values));
  

  multiStack.push(2, 90);
  System.out.println("values after push: " + Arrays.toString(multiStack.values));
  multiStack.push(2, 91);
  System.out.println("values after push: " + Arrays.toString(multiStack.values));

  multiStack.pop(2);
    System.out.println("values after pop: " + Arrays.toString(multiStack.values));

  multiStack.pop(1);
    System.out.println("values after pop: " + Arrays.toString(multiStack.values));
      multiStack.pop(1);
    System.out.println("values after pop: " + Arrays.toString(multiStack.values));
  }
}
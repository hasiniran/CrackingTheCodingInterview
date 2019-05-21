import java.util.EmptyStackException;

public class MultiStack{

public class StackInfo{
  int size, start, capacity;

  public StackInfo(int start, int capacity){
      this.start=start;
      this.capacity=capacity;
  }

  public boolean isFull(){
    return size==capacity;
  }

  public boolean isEmpty(){
    return size==0;
  }

  public int lastCapacityIndex(){
    int lastCapacityIndex;
    int max = values.length;
    lastCapacityIndex = adjustIndex(this.start+this.capacity-1);
    return lastCapacityIndex;
  }

  public int lastElementIndex(){
    return adjustIndex(start+size-1);
  }
}

  public StackInfo[] stackInfo;
  public int[] values;

  public MultiStack(int defaultSize, int numberOfStacks){

    System.out.println("creating the multistack");
    
    stackInfo = new StackInfo[numberOfStacks];
    for(int i=0; i<numberOfStacks; i++){
      stackInfo[i] = new StackInfo(defaultSize*i, defaultSize);
    }
    values = new int[defaultSize*numberOfStacks];

  }

  public void push(int stackNumber, int item) throws FullStackException{
    System.out.println("pushing element" + item + " to stack " + stackNumber);
    
    //if all stacks aer full throw exception
    if(allStacksAreFull()){
     throw new FullStackException();
    }
    //if this stack is full expand
    StackInfo stack = stackInfo[stackNumber];
    if(stack.isFull()){
      //EXPAND
      expand(stackNumber);

    }

    //insert to top
    stack.size++;
    values[stack.lastElementIndex()]=item;

  }

  public int pop(int stackNumber) throws EmptyStackException{
      int top;
      StackInfo stack = stackInfo[stackNumber];
      //if stack is empty throw exception

      if(stack.isEmpty()) throw new EmptyStackException();
      
      //get top
      top = values[stack.lastElementIndex()];

      //adjust top element
      values[stack.lastElementIndex()] =0;
      stack.size--;

      return top;
  }

  public int peek(int stackNumber) throws EmptyStackException{
    //if stack is empty throw exception
    StackInfo stack = stackInfo[stackNumber];
      if(stack.isEmpty()) throw new EmptyStackException();

    //get the top
    int top = values[stack.lastElementIndex()];
     return top;

  }


public boolean allStacksAreFull(){
  int totalItems=0;
    for(int i=0; i< stackInfo.length ; i++){
      totalItems += stackInfo[i].size;
    }
  return totalItems==this.values.length;
}


public void expand(int stackNumber){
  System.out.println("expanding the stack " + stackNumber);
  //shift the next stack by one

  shift((stackNumber+1)%stackInfo.length);

  //increase the capacity of this stack
  stackInfo[stackNumber].capacity++;
}


public void shift(int stackNumber){
  System.out.println("///shifting the stack "+ stackNumber);
  StackInfo stack = stackInfo[stackNumber];
  //if the stack is full shift the next stack
  if(stack.isFull()){
    shift((stackNumber+1)%stackInfo.length);
    stack.capacity++;
  }

  //shift all elements in stack by one
  int lastCapacityIndex =stack.lastCapacityIndex();
  int startIndex = stack.start;
  for(int i=lastCapacityIndex; i>startIndex; i--){
      values[i] = values[adjustIndex(i-1)];
  }

  //update stack stack data
  values[stack.start] = 0;
  stack.start = stack.start+1;
  stack.capacity--;


}

private int adjustIndex(int index){
  int max=values.length;
  return (index % max+max) % max;
}

}


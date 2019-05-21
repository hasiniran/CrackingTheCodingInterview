
public class FullStackException extends RuntimeException {

  public FullStackException(){
    this("Stack is Full");
  }

  public FullStackException(String exception){
    super(exception);
  }



}
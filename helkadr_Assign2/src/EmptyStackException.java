  /**
   * @author Hadi El-Kadri
   * Handles the exception of an empty stack and prints that it is empty
   * @param a stack of type String that represents the stack's name
   */

public class EmptyStackException extends RuntimeException
{
  public EmptyStackException (String stack)
  {
    super ("The " + stack + " is empty.");
  }
}

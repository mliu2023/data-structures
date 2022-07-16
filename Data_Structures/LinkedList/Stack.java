/**
* Interface for a stack (last in, first out).
* @author Max Liu
* @version 1.0
*/
public interface Stack<E>{

  /**
  * Adds an item to the stack.
  * @param item The item that is added.
  */
  void push(E item);
  /**
  * Removes an item from the stack.
  * @return The last item in (first one out).
  */
  E pop();
  /**
  * Return, but does not remove, the head of the stack.
  * @return The head of the stack.
  */
  E peek();
  /**
  * Returns whether the stack is empty or not.
  * @return true if it is empty, false otherwise.
  */
  boolean isEmpty();
}

/**
* Interface for a queue (first in, first out).
* @author Max Liu
* @version 1.0
*/
public interface Queue<E>{
  /**
  * Returns, but does not remove, the head item from the queue.
  * @return The head item.
  */
  E peek();
  /**
  * Removes item from the queue.
  * @return The item that is removed.
  */
  E poll();
  /**
  * Adds object to the queue.
  * @param item The object that is added to the queue.
  */
  void offer(E item);
  /**
  * Returns whether or not the queue is empty.
  * @return true if the queue is empty, false otherwise.
  */
  boolean isEmpty();

}

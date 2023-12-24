import java.util.NoSuchElementException;
import java.util.Iterator;
import java.lang.Iterable;
/**
* Class to create an LinkedListIterator.
* @author Max Liu
* @version 1.0
*/
public class LinkedListIterator<E> implements Iterator<E>{

  // fields
  private LinkedList<E> n;
  private int index;

  /**
  * Constructor for a LinkedListIterator.
  * O(1) - just instantiates the fields.
  * @param list The LinkedList that is used to make an iterator.
  */
  public LinkedListIterator(LinkedList<E> list){
    n = list;
    index = 0;
  }
  /**
  * Returns true if the iteration has more elements, false otherwise.
  * O(1) - just checks if the reference is null.
  * @return true if the iteration has more elements, false otherwise.
  */
  public boolean hasNext(){
    return index+1 == n.size();
  }
  /**
  * Returns the next element in the iteration.  Throws NoSuchElementException if the iteration has no more elements.
  * O(1) - whether or not the method throws or not, there are just a few executions.
  * @return the next element in the iteration.
  */
  public E next(){
    if(!hasNext()){
      throw new NoSuchElementException("The iteration has no more elements");
    }
    int temp = index;
    index += 1;
    return n.get(temp);
  }

}

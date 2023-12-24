import java.util.NoSuchElementException;
import java.lang.Iterable;
import java.util.Iterator;
/**
* Class to create a VectorIterator.
* @author Max Liu
* @version 1.0
*/
public class VectorIterator<T> implements Iterator<T>{

  // fields
  private Vector<T> v;
  private int index;

  /**
  * Constructor for a VectorIterator.
  * O(1) - just a few executions
  * @param vector The vector for this object.
  */
  public VectorIterator(Vector<T> vector){
    v = vector;
    index = 0;
  }

  /**
  * Returns true if the iteration has more elements, false otherwise.
  * O(1) - size() has time complexity O(1) and index < v.size() is just another
  * execution.
  * @return true if the iteration has more elements, false otherwise.
  */
  public boolean hasNext(){
    return index < v.size();
  }

  /**
  * Returns the next element in the iteration. Throws NoSuchElementException if the iteration has no more elements.
  * O(1) - whether we throw or not, there are just a few executions and get()
  * has time complexity O(1).
  * @return The next element in the iteration.
  */
  @SuppressWarnings("unchecked")
  public T next(){
    if(!hasNext()){
      throw new NoSuchElementException("The interation has no more elements.");
    }
    int temp = index;
    index += 1;
    return (T)v.get(temp);
  }
}

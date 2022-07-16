import java.util.NoSuchElementException;
import java.lang.UnsupportedOperationException;
import java.util.Iterator;
import java.lang.Iterable;

/**
* Class to create a RangeIterator.
* @author Max Liu
* @version 1.0
*/
public class RangeIterator implements Iterator<Integer>
{
    // fields
    private Range range;
    private int index;

    /**
    * Constructor for a RangeIterator.
    * @param r The range of this object.
    */
    public RangeIterator( Range r )
    {
        range = r;
        index = range.getStart();
    }

    /**
    * Returns true if the iteration has more elements, false otherwise.
    * @return true if the iteration has more elements, false otherwise.
    */
    public boolean hasNext(){
      return index <= range.getEnd();
    }

    /**
    * Returns the next element in the iteration. Throws NoSuchElementException if the iteration has no more elements.
    * @return The next element in the iteration.
    */
    public Integer next(){
      if(!hasNext()){
        throw new NoSuchElementException("The interation has no more elements.");
      }
      int temp = index;
      index += 1;
      return temp;
    }



    //ignore for now
    /*
    public void remove() {
        throw new UnsupportedOperationException();
    }
    */
}

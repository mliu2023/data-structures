import java.util.NoSuchElementException;
import java.lang.Iterable;
import java.util.Iterator;

/**
* Class to create a range.
* @author Max Liu
* @version 1.0
*/
public class Range implements Iterable<Integer> {
    private int start;
    private int end;

    /**
    * Constructor for a range.
    * @param s The start of the range.
    * @param e The end of the range.
    */
    public Range(int s, int e) {
        start = s;
        end = e;
    }

    /**
    * Accessor for the start of the range.
    * @return the start of the range.
    */
    public int getStart() {
    	return start;
    }

    /**
    * Accessor for the end of the range.
    * @return the end of the range.
    */
    public int getEnd() {
    	return end;
    }

    //have them code this
    //write the iterator() method from Iterable
    /**
    * The iterator method from the iterable interface.
    * @return an iterator of Integers.
    */
    public Iterator<Integer> iterator(){
      return new RangeIterator(this);
    }



}

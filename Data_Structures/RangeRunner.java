import java.lang.Iterable;
import java.util.Iterator;

/**
* Runner for a range.
* @author Max Liu
* @version 1.0
*/
public class RangeRunner
{

    public static void main( String[] args )
    {
        Range range = new Range(1, 10);

        // Long way
        Iterator<Integer> it = range.iterator();
        while( it.hasNext() )
        {
            System.out.println( it.next() );
        }

        // Shorter, nicer way:
        // Read ":" as "in"
        for (Integer cur : range)
        {
            System.out.println(cur);
        }

    }


}

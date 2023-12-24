
class Stats <T extends Number> {


	// array of Number or subclass
	T[] nums;

	// Pass the constructor a reference to
	// an array of type Number or subclass.
	Stats (T [] o ) {
	nums = o;
}
	// Returns average of nums array. Returns type double in all cases.
	double average() {
		double sum = 0.0;
		for ( int i=0; i < nums.length; i++ )
			sum += nums[i].doubleValue();
		return sum/nums.length;
	}


	// Write a method that determines if two averages are the same.
	// Accepts Stats object as parameter to compare against.

	/**
	*   Stats<Integer> a1 = ....
	*   Stats<Double> a2 = ...
	*   can I compare a1 and a2?
	*/
	public boolean compareTo(Stats<?> other){
		return this.average() == other.average();
	}

}
public class WildcardExercise{
	public static void main(String[] args){
		Integer[] arr1 = {1, 2, 3};
		String[] arr2 = {"1.0", "1.5", "3.5"};
		Stats<Integer> a1 = new Stats<Integer>(arr1);
		//Stats<String> a2 = new Stats<String>(arr2);
		//System.out.println(a1.compareTo(a2));
	}
}

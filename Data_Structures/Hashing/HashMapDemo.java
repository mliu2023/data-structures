import java.util.*;



public class HashMapDemo {
	public static void main(String args[]) {

	// Create a hash map.
	HashMap<String, Double> hm = new HashMap<String, Double>();

	// Put elements to the map
	hm.put("John Doe", Double.valueOf(3434.34));
	hm.put("Tom Smith", Double.valueOf(123.22));
	hm.put("Jane Baker", Double.valueOf(1378.00));
	hm.put("Tod Hall", Double.valueOf(99.22));
	hm.put("Ralph Smith", Double.valueOf(-19.08));

	System.out.println("---------");
	
	System.out.println(hm);
	
	System.out.println("---------");

	// Get a set of the entries.
	Set<Map.Entry<String, Double>> set = hm.entrySet();

	// Display the set.
	for(Map.Entry<String, Double> me : set) {
		System.out.print(me.getKey() + ": ");
		me.setValue(me.getValue() + 1);
		System.out.println(me.getValue());
		//hm.replace(me.getKey(), -10000.0);
		/*
		if (me.getValue() > 3000.00)
			me.setValue(100.22);
		
		*/
		
		
	}
	
	System.out.println("---------");
	
	System.out.println(hm);
	
	System.out.println("---------");
	
	Set<String> set1 = hm.keySet();
	
	for(String s : set1) {
		System.out.print( s + ": ");
		System.out.println(hm.get(s));
		//set1.remove("Tom Smith");
	}

	System.out.println();

	// Deposit 1000 into John Doe's account.
	double balance = hm.get("John Doe");
	hm.put("John Doe", balance + 1000);
	System.out.println("John Doe's new balance: " + hm.get("John Doe"));
	}
}

/**
* Runner for the vector class.
* @author Max Liu
* @version 1.0
*/
public class VectorRunner{

  public static void main(String[] args){
    // default constructor
    Vector<Integer> v = new Vector<Integer>();
    for(int i = 0; i < 10; i++){
      v.add(i);
    }
    System.out.println(v);
    // copy constructor
    Vector<Integer> v1 = new Vector<Integer>(v);
    // constructor with capacity
    Vector<Integer> v2 = new Vector<Integer>(50);
    System.out.println(v1);
    // add
    v.add(10);
    System.out.println(v);
    // add at index
    v.add(5, 5);
    System.out.println(v);
    System.out.println("Size: " + v.size());
    // set
    System.out.println("Element originally at index 1: " + v.set(1, 2));
    System.out.println(v);
    // get
    System.out.println("Element at index 0: " + v.get(0));
    // removing element
    Integer i1 = Integer.valueOf(1);
    Integer i2 = Integer.valueOf(2);
    System.out.println("Removing 1:");
    v.remove(i1);
    System.out.println(v);
    System.out.println("Removing 2:");
    v.remove(i2);
    System.out.println(v);
    // removing at index
    v.remove(2);
    System.out.println(v);
    System.out.println("Size: " + v.size());
    // contains
    System.out.println("v contains 10: " + v.contains(10));
    System.out.println("v contains -5: " + v.contains(-5));
    System.out.println("Index of 2: " + v.indexOf(2));
    System.out.println("v is empty: " + v.isEmpty());
    v.clear();
    System.out.println(v);
    System.out.println("v is empty: " + v.isEmpty());
    for(int j = 0; j < 10; j++){
      v.add(j*j);
    }
    System.out.println(v);
    // for each loop
    for (Integer val : v){
      System.out.println(val);
    }
    // Errors:
    // Vector<Integer> v3 = new Vector<Integer>(-5);
    // v.add(1000, 5);
    // v.add(-400, 3);
    // int p = v.get(1000);
    // int p1 = v.get(-5);
    // v.remove(1000);
    // v.remove(-10);
    // v.set(-10, 4);
    // v.set(1000, 8);
  }
}

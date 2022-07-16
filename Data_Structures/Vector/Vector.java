import java.util.NoSuchElementException;
import java.lang.Iterable;
import java.util.Iterator;
/**
* Class to create a vector, similar to an ArrayList.
* @author Max Liu
* @version 1.0
* 1. We can't create a generic array because the type of the array is not known
* at runtime.  This is an issue because the array needs to allocate memory.
* Arrays are covariant, so String[] is a subtype of Object[], but generics are
* invariant, so generics are not a subtype of one another.
* 2. Errors are more serious problems that the program cannot recover from, like
* a StackOverFlowError.  Exceptions can be recovered from using try-catch blocks.
* 3. A copy constructor allows us to make a deep copy, so we can make changes to
* the original vector while still saving the data in the copied vector.
* 4. If the initial capacity is too small, the program will have to double the
* length of the array and copy all the elements into the new array, which
* has time complexity O(n).  If the initial capacity is large enough, the
* program will not have to double the length and copy elements, which makes
* it more efficient.  The time complexities of the methods are listed with each
* method.
*/
public class Vector<T> implements Iterable<T>{

  // fields
  private Object[] data;
  private int capacity;
  private int size;

  /**
  * Default constructor for a vector, creates a vector of capacity 10.
  * O(1) - instantiating a few variables.
  */
  public Vector(){
    data = new Object[10];
    capacity = 10;
    size = 0;
  }
  /**
  * Constructor that takes creates a vector with capacity initCapacity.
  * O(1) - instantiating a few variables.
  * @param initCapacity The initial capacity of the vector.
  */
  public Vector(int initCapacity){
    if(initCapacity < 0){
      throw new NegativeArraySizeException("Cannot instantiate array with negative size");
    }
    data = new Object[initCapacity];
    capacity = initCapacity;
    size = 0;
  }
  /**
  * A copy constructor that copies a given vector.
  * O(n) - loops through the entire array
  * @param other The vector that is used to construct a deep copy.
  */
  public Vector(Vector<T> other){
    data = new Object[other.capacity];
    capacity = other.capacity;
    size = other.size;
    for(int i = 0; i < size; i++){
      data[i] = other.get(i);
    }
  }
  /**
  * Adds an item to the first available space in the vector.
  * O(n) - worst case, we call increaseCapacity with time complexity O(n),
  * and there are just a few other executions below.
  * @param toAdd The item that is added to the first available space.
  */
  public void add(T toAdd){
    if(size == capacity){
      this.increaseCapacity();
    }
    data[size] = toAdd;
    size++;
  }
  /**
  * Adds an item at the specified index and shifts the other items down.
  * O(n) - worst case, we call increaseCapacity with time complexity O(n),
  * and we loop from size to index which has time complexity O(n).
  * @param index The index at which the item is added.
  * @param toAdd The item that is inserted.
  */
  public void add(int index, T toAdd){
    if(index > size || index < 0){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for length " + size);
    }
    if(size == capacity){
      this.increaseCapacity();
    }
    for(int i = size; i > index; i--){
      data[i] = data[i-1];
    }
    data[index] = toAdd;
    size++;
  }
  /**
  * Doubles the capacity of the vector.
  * O(n) - we have to loop through data and add items to data2.
  */
  private void increaseCapacity(){
    Object[] data2 = new Object[2*capacity];
    for(int i = 0; i < size; i++){
      data2[i] = data[i];
    }
    capacity = 2*capacity;
    data = data2;
  }
  /**
  * Returns an item at the specified index.
  * O(1) - no loops, just a few executions.
  * @param index The index at which the item is returned.
  * @return The item at index.
  */
  @SuppressWarnings("unchecked")
  public T get(int index){
    if(index >= size || index < 0){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for length " + size);
    }
    return (T)(data[index]);
  }
  /**
  * Removes and returns the element at the specified index, all other items shifted down.
  * O(n) - loops through data to shift elements.
  * @param index The index at which the item is returned and removed.
  * @return The item at index.
  */
  @SuppressWarnings("unchecked")
  public T remove(int index){
    if(index >= size || index < 0){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for length " + size);
    }
    Object temp = data[index];
    for(int i = index; i < size - 1; i++){
      data[i] = data[i+1];
    }
    size--;
    return (T)temp;
  }
  /**
  * Removes the first instance of the specified object.
  * O(n) - loops through the array and checks if each item is equal to object.
  * @param obj The object who's first instance will be removed.
  * @return true if an object is removed, false otherwise.
  */
  public boolean remove(T obj){
    for(int i = 0; i < size; i++){
      if(data[i].equals(obj)){
        this.remove(i);
        return true;
      }
    }
    return false;
  }
  /**
  * Places obj at the specified location.
  * O(1) - just a few executions.
  * @param index The index at which obj is placed.
  * @param obj The object that is placed at index.
  * @return The element originally at index.
  */
  @SuppressWarnings("unchecked")
  public T set(int index, T obj){
    if(index >= size || index < 0){
      throw new IndexOutOfBoundsException("Index " + index + " is out of bounds for length " + size);
    }
    Object temp = data[index];
    data[index] = obj;
    return (T)temp;
  }
  /**
  * Returns the number of items in the vector.
  * O(1) - just returns the size.
  * @return The size of the vector.
  */
  public int size(){
    return size;
  }
  /**
  * Clears all items in the vector.
  * O(1) - just instantiates data as an array of nulls with length capacity.
  */
  public void clear(){
    data = new Object[capacity];
    size = 0;
  }
  /**
  * Checks whether the vector is empty or not.
  * O(1) - just checks if size == 0.
  * @return true if the vector is empty, false otherwise.
  */
  public boolean isEmpty(){
    return (size == 0);
  }
  /**
  * Checkes whether or not the vector has the specified object.
  * O(n) - loops through the array and checks if each item is equal to obj.
  * @param obj The object that is checked for in the vector.
  * @return true if the vector has the object, false otherwise.
  */
  public boolean contains(T obj){
    for(int i = 0; i < size; i++){
      if(data[i].equals(obj)){
        return true;
      }
    }
    return false;
  }
  /**
  * Returns the first index of the specified object.
  * O(n) - loops through the array to check if each item is equal to obj.
  * @param obj The object whos index will be found.
  * @return the index of obj if it is in the array, -1 if it is not in the array.
  */
  public int indexOf(T obj){
    for(int i = 0; i < size; i++){
      if(data[i].equals(obj)){
        return i;
      }
    }
    return -1;
  }
  /**
  * This method allows a vector to be printed.
  * O(n) - loops from 0 to size-1 to add all of the items to the string that is returned.
  * @return The vector with its items.
  */
  public String toString(){
    String v = "<";
    for(int i = 0; i < size; i++){
      v += data[i].toString();
      if(i != size - 1){
        v += ", ";
      }
    }
    v += ">";
    return v;
  }
  /**
  * Creates and returns an iterator.
  * O(1) - VectorIterator constructor has time complexity O(1).
  * @return an Iterator<T>.
  */
  public Iterator<T> iterator(){
    return new VectorIterator<T>(this);
  }
}

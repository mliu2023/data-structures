import java.lang.Throwable;
/**
* Class to create a minheap.
* @author Max Liu
* @version 1.0
*/
public class MinHeap<T extends Comparable<T>>{
  //fields
  private int capacity;
  private int size;
  private Object[] heap;

  /**
  * No-args constructor for a minheap.
  * O(1) - constant time
  */
  public MinHeap(){
    capacity = 10;
    size = 0;
    heap = new Object[10];
  }
  /**
  * Constructor that takes in the initial capacity.
  * @param initCapacity the initial capacity of the heap.
  * O(1) - constant time
  */
  public MinHeap(int initCapacity){
    if(initCapacity < 0){
      throw new NegativeArraySizeException();
    }
    capacity = initCapacity;
    size = 0;
    heap = new Object[capacity];
  }
  /**
  * Returns the size of the minheap.
  * @return The size.
  * O(1) - constant time
  */
  public int size(){return size;}
  /**
  * Returns whether or not the minheap is empty.
  * @return true if it is empty, false otherwise.
  * O(1) - constant time
  */
  public boolean isEmpty(){return size == 0;}
  /**
  * Doubles the capacity of the heap array.
  * O(n) - has to loop through the array and copy elements into the new larger array.
  */
  public void increaseCapacity(){
    Object[] heap2;
    if(capacity == 0){
      heap2 = new Object[1];
    }
    else{
      heap2 = new Object[capacity*2];
    }
    for(int i = 0; i < size; i++){
      heap2[i] = heap[i];
    }
    heap = heap2;
    capacity = 2*capacity;
  }
  /**
  * Swaps the elements at indices index1 and index2 in the array.
  * @param arr The heap array.
  * @param index1 The first index.
  * @param index2 The second index.
  * O(1) - constant time
  */
  @SuppressWarnings("unchecked")
  public void swap(Object[] arr, int index1, int index2){
    T temp = (T)arr[index1];
    arr[index1] = arr[index2];
    arr[index2] = temp;
  }
  /**
  * Inserts an element into the heap while maintaining the heap property.
  * @param v the value that is inserted.
  * Worse case: O(n) for incraseCapacity and O(log n) for heapifyUp.  This is O(n) time.
  * Best case: O(log n) for heapifyUp because log_2(n) is the height of the heap.
  */
  public void insert(T v){
    if(size == capacity){
      increaseCapacity();
    }
    heap[size] = v;
    heapifyUp(size);
    size++;
  }
  /**
  * Removes the minimum element of the heap.
  * @return the minimum element.
  * O(log n) for heapifyDown because log_2(n) is the height of the heap.
  */
  @SuppressWarnings("unchecked")
  public T poll(){
    if(size == 0){
      throw new IndexOutOfBoundsException("Index 0 out of bounds for length 0");
    }
    T temp = (T)heap[0];
    heap[0] = heap[size-1];
    heap[size-1] = null;
    size--;
    heapifyDown(0);
    return (T)temp;
  }
  /**
  * Finds the minimum element of the heap.
  * @return the minimum element or null if the heap is empty.
  * O(1) - constant time
  */
  @SuppressWarnings("unchecked")
  public T peek(){
    if(size == 0){
      throw new IndexOutOfBoundsException("Index 0 out of bounds for length 0");
    }
    return (T)heap[0];
  }
  /**
  * Returns the array representing the heap.
  * @return the heap array.
  * O(n) - loops through the heap array.
  */
  public String toString(){
    String str = "[";
    for(int i = 0; i < size-1; i++){
      str += heap[i].toString() + ", ";
    }
    if(size > 0){
      str += heap[size-1].toString();
    }
    str += "]";
    return str;
  }
  /**
  * Used to maintain the heap property after insertion.
  * O(log n) - log_2(n) is the height of the heap, and heapifyUp recursively calls
  * until the element and its parent don't need to be swapped.
  */
  @SuppressWarnings("unchecked")
  private void heapifyUp(int index){
    if(index > 0 && ((T)heap[index]).compareTo((T)heap[(index-1)/2]) < 0){
      // swap with the parent if the parent value is larger
      swap(heap, index, (index-1)/2);
      heapifyUp((index-1)/2);
    }
  }
  /**
  * Used to maintain the heap property after deletion.
  * O(log n) - log_2(n) is the height of the heap, and heapifyDown recursively calls
  * until the element doesn't need to be swapped with either of its children.
  */
  @SuppressWarnings("unchecked")
  private void heapifyDown(int index){
    if(index*2+2 < size){
      if(((T)heap[index*2+1]).compareTo((T)heap[index*2+2]) > 0){
        // swap the parent with the smaller child (right) if they need to be swapped
        if(((T)heap[index]).compareTo((T)heap[index*2+2]) > 0){
          swap(heap, index, index*2+2);
          heapifyDown(index*2+2);
        }
      }
      else{
        // swap the parent with the smaller child (left) if they need to be swapped
        if(((T)heap[index]).compareTo((T)heap[index*2+1]) > 0){
          swap(heap, index, index*2+1);
          heapifyDown(index*2+1);
        }
      }
    }
    else if(index*2+1 < size){
      // swap the parent with the left child if they need to be swapped; right child does not exist
      if(((T)heap[index]).compareTo((T)heap[index*2+1]) > 0){
        swap(heap, index, index*2+1);
        heapifyDown(index*2+1);
      }
    }
  }
}

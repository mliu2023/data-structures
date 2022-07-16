import java.util.NoSuchElementException;
import java.lang.Iterable;
import java.util.Iterator;
/**
* Class to create a LinkedList.
* 1. The optimal runtime of each of the methods is O(1).  If the LinkedList is
* of size 1, then all searches, insertions, deletions, etc. will take constant time.
* 2. A LinkedList is more efficient at adding and removing at the front
* and adding to the end.  Vector is more efficient with get() and set().  This
* LinkedList does not keep track of size, which size() inefficient.
* 3. We can let our LinkedList be a queue/stack, so if there was ever an array
* of queues we could put linked lists in.  The queue and stack interfaces force
* us to implement their methods.
* 4. Having a doubly linked list would require the implementation to keep track
* of both the next and previous reference.  This would take a bit more memory.
* However, it would allow us to delete from the end with time complexity O(1),
* as we can find the previous reference of the tail quickly.
* 5. A circularly linked list is when the tail has a reference to the head.
* This might be useful if you need to keep cycling through items in a list.
* Operating systems use circularly linked lists.  When multiple applications are
* running, the applications are put into a circularly linked list, and the GPU
* cycles through the applications and goes back to the beginning.

* @author Max Liu
* @version 1.0
*/
public class LinkedList<E> implements Queue<E>, Stack<E>, Iterable<E>{

  // fields
  private ListNode<E> head;
  private ListNode<E> tail;
  /**
  * No args constructor, sets head and tail to null.
  * O(1) - setting head and tail to null.
  */
  public LinkedList(){
    head = null;
    tail = null;
  }
  /**
  * Constructor that takes in a head.
  * O(n) - this goes through the entire LinkedList to find the tail.
  * @param h The head of the LinkedList.
  */
  public LinkedList(ListNode<E> h){
    head = h;
    tail = h;
    while (h.getNext() != null){
      tail = h.getNext();
    }
  }
  /**
  * Copy Constructor
  * O(1) - just instantiating head and tail.
  * @param other The LinkedList that is copied.
  */
  public LinkedList(LinkedList<E> other){
    head = other.head;
    tail = other.tail;
  }
  /**
  * Adds object to the end of the list.
  * O(1) - just changes the reference of the tail and makes o the new tail.
  * @param o The object that is added.
  */
  public void add(E o){
    ListNode<E> n = new ListNode<E>(o, null);
    if(head == null){
      head = n;
      tail = n;
    }
    else{
      tail.setNext(n);
      tail = n;
    }
  }
  /**
  * Adds object to stack (the head).
  * O(1) - addFirst() has time complexity O(1)
  * @param item The object that is added to the stack (the head).
  */
  public void push(E item){
    addFirst(item);
  }
  /**
  * Adds object to queue.
  * O(1) - just changes the reference of the tail and makes o the new tail.
  * @param item The object that is added to the queue.
  */
  public void offer(E item){
    addLast(item);
  }
  /**
  * Removes item and returns whether or not object was removed.
  * O(n) - has to loop through the list to find o.
  * @param o The object that is going to be removed.
  * @return true if the object was removed, false otherwise.
  */
  public boolean remove(E o){
    ListNode<E> n = new ListNode<E>(head.getValue(), head.getNext());
    while(n.getNext() != null){
      if(n.getNext().getValue().equals(o)){
        n.setNext(n.getNext().getNext());
        return true;
      }
      n = n.getNext();
    }
    return false;
  }
  /**
  * Removes and return item at specified index.
  * O(n) - has to loop through the list to get to index.
  * @param index The index at which the object is removed.
  * @return The object that is removed.
  */
  public E remove(int index){
    int s = size();
    if(index < 0 || index >= s){
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + s);
    }
    if(index == 0){
      return removeFirst();
    }
    ListNode<E> n = new ListNode<E>(head.getValue(), head.getNext());
    for(int i = 0; i < index-1; i++){
      n = n.getNext();
    }
    E val = n.getNext().getValue();
    n.setNext(n.getNext().getNext());
    return val;
  }
  /**
  * Removes and returns the first item in the list.
  * O(1) - just sets the head to the next node and returns the value from the head.
  * @return The first item in the list.
  */
  public E removeFirst(){
    int s = size();
    if(s == 0){
      throw new NoSuchElementException("Can't remove element from length 0");
    }
    E val = head.getValue();
    if(s == 1){
      head = null;
      tail = null;
    }
    else{
      head = head.getNext();
    }
    return val;
  }
  /**
  * Removes and returns the last item in the list.
  * O(n) - has to loop to the end of the list to change the tail.
  * @return The last item in the list.
  */
  public E removeLast(){
    int s = size();
    if(s == 0){
      throw new NoSuchElementException("Can't remove element from length 0");
    }
    E m = tail.getValue();
    if(s == 1){
      head = null;
      tail = null;
      return m;
    }
    ListNode<E> n = new ListNode<E>(head.getValue(), head.getNext());
    if(s == 2){
      tail = head;
      tail.setNext(null);
      return m;
    }
    for(int i = 0; i < s-2; i++){
      n = n.getNext();
    }
    tail = n;
    tail.setNext(null);
    return m;
  }
  /**
  * Adds and object to the front of the list.
  * O(1) - just changes the head.
  * @param item The item that is added to the front.
  */
  public void addFirst(E item){
    head = new ListNode<E>(item, head);
    if(tail == null){
      tail = head;
    }
  }
  /**
  * Adds object to the end of the list.
  * O(1) - just changes the old tail and creates a new tail.
  * @param item The item that is added to the end.
  */
  public void addLast(E item){
    ListNode<E> n = new ListNode<E>(item, null);
    if(head == null){
      head = n;
      tail = n;
    }
    else{
      tail.setNext(n);
      tail = n;
    }
  }
  /**
  * Returns whether or not the specific objects is in the list.
  * O(n) - loops through the list until it finds the object.
  * @param o The object that is checked for in the list.
  * @return true if o is in the list, false otherwise.
  */
  public boolean contains(E o){
    if(head == null){
      return false;
    }
    ListNode<E> n = new ListNode<E>(head.getValue(), head.getNext());
    while(n != null){
      if(n.getValue().equals(o)){
        return true;
      }
      n = n.getNext();
    }
    return false;
  }
  /**
  * Finds the size of the list.
  * O(n) - has to loop through the entire list.
  * @return the size of the list.
  */
  public int size(){
    if(head == null){
      return 0;
    }
    ListNode<E> n = new ListNode<E>(head.getValue(), head.getNext());
    int m = 1;
    while(n.getNext() != null){
      n = n.getNext();
      m++;
    }
    return m;
  }
  /**
  * Removes all items from the list.
  * O(1) - just sets head and tail to null.
  */
  public void clear(){
    head = null;
    tail = null;
  }
  /**
  * Returns item at the specified index.
  * O(n) - has to loop through the list until we get to index, size() takes O(n) as well.
  * @param index The index at which the item is returned.
  * @return The value at index.
  */
  public E get(int index){
    int s = size();
    if(index < 0 || index >= s){
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + s);
    }
    ListNode<E> n = new ListNode<E>(head.getValue(), head.getNext());
    for(int i = 0; i < index; i++){
      n = n.getNext();
    }
    return n.getValue();
  }
  /**
  * Places object as specified index.
  * O(n) - loops through the list to get to node at index, size takes O(n) as well.
  * @param index The index at which the object is placed.
  * @param o The object that is placed at index.
  * @return The item that is was originally at index.
  */
  public E set(int index, E o){
    int s = size();
    if(index < 0 || index >= s){
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + s);
    }
    ListNode<E> n = new ListNode<E>(head.getValue(), head.getNext());
    for(int i = 0; i < index; i++){
      n = n.getNext();
    }
    E val = n.getValue();
    n.setValue(o);
    return val;
  }
  /**
  * Adds object at specified location.
  * O(n) - has to loop to index to insert the new item, size() takes O(n) as well.
  * @param index The index at which the object is added.
  * @param o The object that is inserted at index.
  */
  public void add(int index, E o){
    int s = size();
    if(index < 0 || index > s){
      throw new IndexOutOfBoundsException("Index " + index + " out of bounds for length " + s);
    }
    else if(index == s){
      addLast(o);
    }
    else{
      ListNode<E> n = new ListNode<E>(head.getValue(), head.getNext());
      for(int i = 0; i < index-1; i++){
        n = n.getNext();
      }
      ListNode<E> after = n.getNext();
      ListNode<E> a = new ListNode<E>(o, after);
      n.setNext(a);
    }
  }
  /**
  * Finds the first instance of o.
  * O(n) - loops through the list to find o.
  * @param o The object whose index is found.
  * @return The index of the first instance of o, -1 if o is not found.
  */
  public int indexOf(E o){
    if(head == null){
      return -1;
    }
    ListNode<E> n = new ListNode<E>(head.getValue(), head.getNext());
    int counter = 0;
    while(n != null){
      if(n.getValue().equals(o)){
        return counter;
      }
      counter++;
      n = n.getNext();
    }
    return -1;
  }
  /**
  * Removes object from queue.
  * O(1) - just gets the value from head and changes the head (removes original head from queue).
  * @return The object that is removed from the queue (the head).
  */
  public E poll(){
    if(head == null){
      return null;
    }
    return removeFirst();
  }
  /**
  * Removes object from stack (from the head).
  * O(1) - removeFirst() has time complexity O(1).
  * @return The object that is removed from the stack (the head).
  */
  public E pop(){
    if(head == null){
      return null;
    }
    return removeFirst();
  }
  /**
  * Returns, but does not remove, the head.
  * O(1) - just returns head.
  * @return The head.
  */
  public E peek(){
    if(head == null){
      return null;
    }
    return head.getValue();
  }
  /**
  * Returns whether or not the list is empty.
  * O(1) - just one execution.
  * @return true if the list is empty, false otherwise.
  */
  public boolean isEmpty(){
    return (head == null);
  }
  /**
  * toString method that allows a LinkedList to be printed.
  * O(n) - has to loop through the entire list.
  * @return The list.
  */
  public String toString(){
    if(isEmpty()){
      return "<>";
    }
    String str = "<";
    ListNode<E> n = new ListNode<E>(head.getValue(), head.getNext());
    while(n.getNext() != null){
      str += n.toString();
      str += ", ";
      n = n.getNext();
    }
    str += n.toString();
    str += ">";
    return str;
  }
  /**
  * Creates and returns an iterator.
  * O(1) - LinkedListIterator constructor has time complexity O(1).
  * @return an iterator.
  */
  public Iterator<E> iterator(){
    return new LinkedListIterator<E>(this);
  }
}

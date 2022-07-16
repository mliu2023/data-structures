/**
* Class for a ListNode, which is part of a LinkedList.
* @author Max Liu
* @version 1.0
*/
public class ListNode<E>{

  // Data
  private E value;
  // Reference
  private ListNode<E> next;

  /**
  * Constructor for a ListNode that takes in data and a reference
  * O(1) - just a few executions.
  * @param item The data for the ListNode.
  * @param n The reference node for this ListNode.
  */
  public ListNode(E item, ListNode<E> n){
    value = item;
    next = n;
  }
  /**
  * Constructor for a ListNode, reference set to null.
  * O(1) - just a few executions.
  * @param item The data for the ListNode.
  */
  public ListNode(E item){
    value = item;
    next = null;
  }
  /**
  * Accessor for the reference.
  * O(1) - just returns the reference node.
  * @return The reference node.
  */
  public ListNode<E> getNext(){
    return next;
  }
  /**
  * Accessor for the value.
  * O(1) - just returns the value.
  * @return The value.
  */
  public E getValue(){
    return value;
  }
  /**
  * Modifier for the reference node.
  * O(1) - just sets the reference to node.
  * @param node The node that is set as the reference.
  */
  public void setNext(ListNode<E> node){
    next = node;
  }
  /**
  * Modifier for the data.
  * O(1) - just sets the value to item.
  * @param item The data to be stored in the node.
  */
  public void setValue(E item){
    value = item;
  }
  /**
  * Returns the value of the node so it can be printed.
  * O(n) - toString has a time complexity of O(n)
  * @return The value of the node.
  */
  public String toString(){
    return value.toString();
  }
}

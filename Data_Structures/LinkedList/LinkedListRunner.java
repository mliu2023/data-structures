/**
* Runner for the LinkedList class.
* @author Max Liu
* @version 1.0
*/
public class LinkedListRunner{

  public static void main(String[] args){
    // default constructor
    LinkedList<Integer> v = new LinkedList<Integer>();
    for(int i = 0; i < 10; i++){
      v.add(i);
    }
    System.out.println("v: " + v + " size: " + v.size());
    // copy constructor
    LinkedList<Integer> v1 = new LinkedList<Integer>(v);
    // constructor with ListNode
    ListNode<Integer> node1 = new ListNode<Integer>(50, null);
    LinkedList<Integer> v2 = new LinkedList<Integer>(node1);
    // empty list
    LinkedList<Integer> v3 = new LinkedList<Integer>();
    System.out.println("v1: " + v1 + " size: " + v1.size());
    // add
    v.add(10);
    System.out.println("v: " + v + " size: " + v.size());
    // add at index
    v.add(5, 5);
    System.out.println("v: " + v + " size: " + v.size());
    // set
    System.out.println("Element originally at index 1: " + v.set(1, 2));
    System.out.println("v: " + v + " size: " + v.size());
    // get
    System.out.println("Element at index 0: " + v.get(0));
    // removing element
    Integer i1 = Integer.valueOf(1);
    Integer i2 = Integer.valueOf(2);
    System.out.println("Removing 1:");
    v.remove(i1);
    System.out.println("v: " + v + " size: " + v.size());
    System.out.println("Removing 2:");
    v.remove(i2);
    System.out.println("v: " + v + " size: " + v.size());
    // removing at index
    v.remove(2);
    System.out.println("v: " + v + " size: " + v.size());
    // contains
    System.out.println("v contains 10: " + v.contains(10));
    System.out.println("v contains -5: " + v.contains(-5));
    System.out.println("Index of 2: " + v.indexOf(2));
    System.out.println("v is empty: " + v.isEmpty());
    v.clear();
    System.out.println("v: " + v + " size: " + v.size());
    System.out.println("v is empty: " + v.isEmpty());
    System.out.println("v contains 1: " + v.contains(1));
    for(int j = 0; j < 10; j++){
      v.add(j*j);
    }
    System.out.println("v: " + v);

    // for each loop
    for (Integer val : v){
      System.out.println(val);
    }
    System.out.println();
    // Testing with lists of small size.
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.add(1);
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.remove(0);
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.add(2);
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.removeLast();
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.add(3);
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.removeFirst();
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.add(4);
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.add(5);
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.removeLast();
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.removeLast();
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.add(6);
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.removeFirst();
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.addFirst(7);
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.clear();
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.addFirst(8);
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.clear();
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.addLast(9);
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.addLast(10);
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.add(2, 11);
    System.out.println("v3: " + v3 + " size: " + v3.size());
    v3.clear();
    System.out.println("v3: " + v3 + " size: " + v3.size());
    System.out.println("Index of 5: " + v3.indexOf(5));
    // Queue and Stack
    ListNode<Integer> qNode = new ListNode<Integer>(1, null);
    Queue<Integer> q = new LinkedList<Integer>(qNode);
    System.out.println(q.poll());
    System.out.println(q.isEmpty());
    q.offer(1);
    q.offer(2);
    System.out.println(q.peek());
    System.out.println(q.poll());
    System.out.println(q.poll());
    System.out.println();
    ListNode<Integer> sNode = new ListNode<Integer>(4, null);
    Stack<Integer> s = new LinkedList<Integer>(sNode);
    s.push(5);
    s.push(6);
    System.out.println(s.peek());
    System.out.println(s.pop());
    System.out.println(s.pop());
    System.out.println(s.isEmpty());
    System.out.println(s.pop());
    System.out.println(s.isEmpty());
    // Errors:
    // v.add(11, 5);
    // v.add(-1, 3);
    // int p = v3.get(3);
    // int p1 = v3.get(-5);
    // v3.remove(3);
    // v3.remove(-1);
    // v3.set(-10, 4);
    // v3.set(3, 8);
    // v3.set(0, 1);
  }
}

/**
* Class to create TreeNode.
* @author Max Liu
* @version 1.0
*/
public class BinaryTreeNode<E>{

  // fields
  private E value;
  private BinaryTreeNode<E> left;
  private BinaryTreeNode<E> right;

  /**
  * No-args constructor, sets all fields to null.
  */
  public BinaryTreeNode(){
    left = null;
    right = null;
    value = null;
  }
  /**
  * Constructs a TreeNode that takes in a value.
  * @param val The value.
  */
  public BinaryTreeNode(E val){
    value = val;
    left = null;
    right = null;
  }
  /**
  * modifier
  * @param n The left subtree.
  */
  public void setLeft(TreeNode<E> n){
    left = n;
  }
  /**
  * modifier
  * @param n The right subtree.
  */
  public void setRight(BinaryTreeNode<E> n){
    right = n;
  }
  /**
  * accessor
  * @return the left subtree.
  */
  public BinaryTreeNode<E> getLeft(){
    return left;
  }
  /**
  * accessor
  * @return the right subtree
  */
  public BinaryTreeNode<E> getRight(){
    return right;
  }
  /**
  * toString method to print out the value.
  * @return The value.
  */
  public String toString(){
    return value.toString();
  }
  //tree traversals
  //in-order
  //pre-order
  //post-order
  public static void inOrderTraversal(BinaryTreeNode<?> n){
    if(n != null){
      inOrderTraversal(n.getLeft());
      System.out.println(n);
      inOrderTraversal(n.getRight());
    }
  }
  public static void preOrderTraversal(BinaryTreeNode<?> n){
    if(n != null){
      System.out.println(n);
      inOrderTraversal(n.getLeft());
      inOrderTraversal(n.getRight());
    }
  }
  public static void postOrderTraversal(BinaryTreeNode<?> n){
    if(n != null){
      postOrderTraversal(n.getLeft());
      postOrderTraversal(n.getRight());
      System.out.println(n);
    }
  }
}

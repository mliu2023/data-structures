/**
* @author DS7 & Ms. Thuzar
*/


public class TreeNode<E extends Comparable<E>>{
  private TreeNode<E> left;
  private TreeNode<E> right;
  private E data;

  //default:
  public TreeNode(){
    this(null, null, null);
  }

  //overloaded
  public TreeNode(E v){
    this(null, null, v);
  }

  //overloaded with 3 para
  public TreeNode(TreeNode<E> l, TreeNode<E> r, E v){
    left = l;
    right = r;
    data = v;
  }

  //accessors
  public E getData(){ return data; }
  public TreeNode<E> getLeft(){ return left; }
  public TreeNode<E> getRight(){ return right; }

  //modifiers
  public void setLeft(TreeNode<E> l){ left = l; }
  public void setRight(TreeNode<E> r){ right = r; }
  public void setData(E v){ data = v; }


  public String toString(){ return data.toString();}
}

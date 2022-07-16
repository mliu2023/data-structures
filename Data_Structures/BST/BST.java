/**
* Class for a BST.
* @author Max Liu
* @version 1.0
*/
public class BST<E extends Comparable<E>>{
  private TreeNode<E> root;

  /**
  * Accessor for the root.
  * @return the root
  */
  public TreeNode<E> getRoot(){ return root; }

  /**
  * Adds a value while maintaining the properties of the BST.
  * @param v The value that is added.
  * @return The treenode that is added.
  */
  public TreeNode<E> add(E v){
    //helper method (recursive)
    return root = add(root, v); //add to the root node recursively
  }
  /**
  * Adds a value while maintaining the properties of the BST.
  * @param r The root.
  * @param v The value that is added.
  */
  public TreeNode<E> add(TreeNode<E> r, E v){
    if (r == null){
      return new TreeNode<E>(v);
    }
    else if (v.compareTo(r.getData()) <= 0)
      r.setLeft(add(r.getLeft(), v));
    else
      r.setRight(add(r.getRight(), v));
    return r;
  }
  /**
  * Finds if a value is in the tree or not.
  * @param v The value that is checked for in the tree.
  * @return true if the value is found, false otherwise.
  */
  public boolean find(E v){
    //helper method (recursive)
    return find(root, v); // find the node recursively
  }
  /**
  * Finds if a value is in the tree or not.
  * @param r The root.
  * @param v The value that is checked for in the tree.
  * @return true if the value is found, false otherwise.
  */
  public boolean find(TreeNode<E> r, E v){
    if(r == null){
      return false;
    }
    else if(v == r.getData()){
      return true;
    }
    else if(v.compareTo(r.getData()) < 0){
      return find(r.getLeft(), v);
    }
    else{
      return find(r.getRight(), v);
    }
  }
  /**
  * Removes a value from the tree if it exists.
  * @param v The value that is removed.
  * @return The treenode that is removed.
  */
  public TreeNode<E> remove(E v){
    //helper method (recursive)
    return remove(root, v); // remove the node recursively
  }
  /**
  * Removes a value from the tree if it exists.
  * @param r The root.
  * @param v The value that is removed.
  * @return The treenode that is removed.
  */
  public TreeNode<E> remove(TreeNode<E> r, E v){
    TreeNode<E> node;
    if(r == null){
      return r;
    }
    else if(r.getLeft() != null && r.getLeft().getRight() == null && v.compareTo(r.getLeft().getData()) == 0){
      node = r.getLeft();
      r.setLeft(node.getLeft());
      return node;
    }
    else if(r.getRight() != null && r.getRight().getRight() == null && v.compareTo(r.getRight().getData()) == 0){
      node = r.getRight();
      r.setRight(node.getLeft());
      return node;
    }
    else if(v == r.getData()){
      node = r.getRight();
      if(node == null){
        if(r.getLeft() != null){
          r.setRight(r.getLeft().getRight());
          r.setData(r.getLeft().getData());
          r.setLeft(r.getLeft().getLeft());
        }
        return r;
      }
      else if(node.getLeft() == null){
        r.setRight(node.getRight());
        r.setData(node.getData());
        return r;
      }
      else{
        while(node.getLeft().getLeft() != null){
          node = node.getLeft();
        }
        r.setData(node.getLeft().getData());
        node.setLeft(node.getLeft().getRight());
        return r;
      }
    }
    else if(v.compareTo(r.getData()) < 0){
      return remove(r.getLeft(), v);
    }
    else{
      return remove(r.getRight(), v);
    }
  }
  /**
  * Method to print out the inorder traversal.
  * @param root The root of the tree.
  */
  public void inOrderTraversal(TreeNode<E> root){
    if (root == null)
      return;
    inOrderTraversal(root.getLeft());
    System.out.print(root + " ");
    inOrderTraversal(root.getRight());
  }
  /**
  * Method to print out the preorder traversal.
  * @param root The root of the tree.
  */
  public void preOrderTraversal(TreeNode<E> root){
    if (root == null)
      return;
    System.out.print(root + " ");
    preOrderTraversal(root.getLeft());
    preOrderTraversal(root.getRight());
  }
  /**
  * Method to print out the postorder traversal.
  * @param root The root of the tree.
  */
  public void postOrderTraversal(TreeNode<E> root){
    if (root == null)
      return;
    postOrderTraversal(root.getLeft());
    postOrderTraversal(root.getRight());
    System.out.print(root + " ");
  }
  /**
  * Main method to test the BST.
  * @param args The command line arguments
  */
  public static void main(String[] args){
    BST<Integer> t = new BST<>();
    t.add(1);
    t.add(0);
    t.add(3);
    t.add(5);
    t.add(4);
    t.add(2);
    t.inOrderTraversal(t.getRoot());
    System.out.println();
    t.preOrderTraversal(t.getRoot());
    System.out.println();
    t.postOrderTraversal(t.getRoot());
  }

}

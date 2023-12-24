/**
 * @author Max Liu
 * @version 1.0
 * BFS DFS Lab
*/

//Task: implement the printPath, BFS, and DFS methods by using the Stack and Queue classes and the provided TreeNode class
//note: make sure code works for multiple contiguous calls of BFS

import java.util.*;
/**
* Class to do BFS and DFS.
*/
public class BFSDFS{

  /**
  * Creates a tree like an image in wikipedia.
  * @return The tree.
  */
  public static TreeNode createTreeNode(){//creates tree based on this image: https://en.wikipedia.org/wiki/Breadth-first_search#/media/File:Breadth-first-tree.svg
    TreeNode head = new TreeNode(1,null);
    head.createChildTreeNode(2);
    head.createChildTreeNode(3);
    head.createChildTreeNode(4);
    head.getChildbyVal(2).createChildTreeNode(5);
    head.getChildbyVal(2).createChildTreeNode(6);
    head.getChildbyVal(2).getChildbyVal(5).createChildTreeNode(9);
    head.getChildbyVal(2).getChildbyVal(5).createChildTreeNode(10);
    head.getChildbyVal(4).createChildTreeNode(7);
    head.getChildbyVal(4).createChildTreeNode(8);
    head.getChildbyVal(4).getChildbyVal(7).createChildTreeNode(11);
    head.getChildbyVal(4).getChildbyVal(7).createChildTreeNode(12);
    return head;
  }

  //prints path from the head of the tree to the goal node
  //nodes should be printed in the following format:  "Path to GoalNode:a-->b-->c-->d-->e"
  //hint: think about whether your implementation should use a queue or stack
  //should be O(h), where h is the maximum depth of your tree (which is equal to the maximum path length between the root node and any node in the tree)
  /**
  * Prints the path from the head to the goal.
  * @param tree The head of the tree.
  * @param goalNode The goal.
  */
  public static void printPath(TreeNode tree, TreeNode goalNode){
    Stack<TreeNode> s = new Stack<TreeNode>();
    String str = "Path to GoalNode:";
    s.push(goalNode);
    while(s.peek().getParent() != null){
      s.push(s.peek().getParent());
    }
    while(!s.empty()){
      int x = s.pop().getVal();
      str += x;
      if(x != goalNode.getVal()){
        str += "-->";
      }
    }
    System.out.println(str);
  }
  /**
  * bfs should traverse tree until the provided value is found, or until the entire tree has been traversed
  * if print is set to true this method should print the order in which the nodes were traversed
  * nodes should be printed in the following format:  "BFS Path:a-->b-->c-->d-->e"
  * @param tree The tree that is traversed through.
  * @param val The value that is searched for.
  * @param print Whether the nodes traversed to get val should be printed or not.
  * @return the tree node containing the provided value, or null if it does not exist
  */
  public static TreeNode BFS(TreeNode tree, int val, boolean print){
    if(tree.getVal() == val){
      if(print){
        printPath(tree, tree);
      }
      return tree;
    }
    Queue<TreeNode> q = new LinkedList<TreeNode>();
    q.offer(tree);
    if(print){
      System.out.println(tree.getVal());
    }
    tree.setVisited(true);
    while(q.peek() != null){
      TreeNode currNode = q.poll();
      for(int i = 0; i < currNode.getNumChildren(); i++){
        if(!currNode.getChildbyIdx(i).isVisited()){
          if(print){
            System.out.println(currNode.getChildbyIdx(i).getVal());
          }
          if(currNode.getChildbyIdx(i).getVal() == val){
            if(print){
              printPath(tree, currNode.getChildbyIdx(i));
            }
            return tree;
          }
          q.offer(currNode.getChildbyIdx(i));
          currNode.getChildbyIdx(i).setVisited(true);
        }
      }
    }
    return null;

  }

  /**dfs should traverse tree until the provided value is found, or until the entire tree has been traversed
  * if print is set to true this method should print the order in which the nodes were traversed
  * nodes should be printed in the following format:  "DFS Path:a-->b-->c-->d-->e"
  * return the tree node containing the provided value, or null if it does not exist
  * @param tree The tree that is traversed through.
  * @param val The value that is searched for.
  * @param print Whether the nodes traversed to get val should be printed or not.
  * @return the tree node containing the provided value, or null if it does not exist
  */
  public static TreeNode DFS(TreeNode tree, int val, boolean print){
    Stack<TreeNode> s = new Stack<TreeNode>();
    boolean visit;
    s.push(tree);
    if(print){
      System.out.println(tree.getVal());
    }
    while(!s.empty()){
      TreeNode currNode = s.peek();
      if(currNode.getVal() == val){
        printPath(tree, currNode);
        return currNode;
      }
      else if(currNode.getNumChildren() == 0){
        s.pop();
      }
      else{
        visit = false;
        for(int i = 0; i < currNode.getNumChildren() && !visit; i++){
          if(!currNode.getChildbyIdx(i).isVisited()){
            visit = true;
            currNode.getChildbyIdx(i).setVisited(true);
            s.push(currNode.getChildbyIdx(i)).getVal();
            if(print){
              System.out.println(currNode.getChildbyIdx(i).getVal());
            }
          }
        }
        if(!visit){
          s.pop();
        }
      }
    }
    return null;
  }

  /**
  * main method in BFSDFS.
  * @param args The command line arguments
  */
  public static void main(String args[]){
    TreeNode tree = createTreeNode();
    BFS(tree, 1, true);
    tree.resetVisited();
    BFS(tree, 2, true);
    tree.resetVisited();
    BFS(tree, 3, true);
    tree.resetVisited();
    BFS(tree, 4, true);
    tree.resetVisited();
    BFS(tree, 5, true);
    tree.resetVisited();
    BFS(tree, 6, true);
    tree.resetVisited();
    BFS(tree, 7, true);
    tree.resetVisited();
    BFS(tree, 8, true);
    tree.resetVisited();
    BFS(tree, 9, true);
    tree.resetVisited();
    BFS(tree, 10, true);
    tree.resetVisited();
    BFS(tree, 11, true);
    tree.resetVisited();
    BFS(tree, 12, true);
    tree.resetVisited();
    DFS(tree, 1, true);
    tree.resetVisited();
    DFS(tree, 2, true);
    tree.resetVisited();
    DFS(tree, 3, true);
    tree.resetVisited();
    DFS(tree, 4, true);
    tree.resetVisited();
    DFS(tree, 5, true);
    tree.resetVisited();
    DFS(tree, 6, true);
    tree.resetVisited();
    DFS(tree, 7, true);
    tree.resetVisited();
    DFS(tree, 8, true);
    tree.resetVisited();
    DFS(tree, 9, true);
    tree.resetVisited();
    DFS(tree, 10, true);
    tree.resetVisited();
    DFS(tree, 11, true);
    tree.resetVisited();
    DFS(tree, 12, true);
    //
    BFS(tree, 50, true);
    System.out.println(DFS(tree, -5, true));
    System.out.println(BFS(tree, 500, false));
    DFS(tree, -51, false);
  }
}

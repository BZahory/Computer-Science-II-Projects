//---------------------------------------------------------------------------
// BinarySearchTree.java          by Dale/Joyce/Weems               Chapter 7
//
// Defines all constructs for a reference-based BST.
// Supports three traversal orders Preorder, Postorder & Inorder ("natural")
//---------------------------------------------------------------------------

package p5_zahory_b;


import java.util.Comparator;
import java.util.Iterator;
import java.util.Scanner;

public class BinarySearchTree<T> extends BinaryTree
{
  public BinarySearchTree(BinaryTree<T> bt, int tInd)
  {
    Iterator it = bt.getIteratorByNum(tInd);
    while(it.hasNext())
      add(it.next());
  }

}
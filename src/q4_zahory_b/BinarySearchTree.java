//---------------------------------------------------------------------------
// BinarySearchTree.java          by Dale/Joyce/Weems               Chapter 7
//
// Defines all constructs for a reference-based BST.
// Supports three traversal orders Preorder, Postorder & Inorder ("natural")
//---------------------------------------------------------------------------

package q4_zahory_b;


import java.util.Comparator;
import java.util.Iterator;

public class BinarySearchTree<T> implements BSTInterface<T>
{
  protected BSTNode<T> root;      // reference to the root of this BST
  protected Comparator<T> comp;   // used for all comparisons

  protected boolean found;   // used by remove

  public BinarySearchTree()
  // Precondition: T implements Comparable
  // Creates an empty BST object - uses the natural order of elements.
  {
    root = null;
    comp = new Comparator<T>()
    {
       public int compare(T element1, T element2)
       {
         return ((Comparable)element1).compareTo(element2);
       }
    };
  }

  public BinarySearchTree(Comparator<T> comp)
  // Creates an empty BST object - uses Comparator comp for order
  // of elements.
  {
    root = null;
    this.comp = comp;
  }

  public boolean isFull()
  // Returns false; this link-based BST is never full.
  {
    return false;
  }

  public boolean isEmpty()
  // Returns true if this BST is empty; otherwise, returns false.
  {
    return (root == null);
  }

  public T min()
  // If this BST is empty, returns null;
  // otherwise returns the smallest element of the tree.
  {
    if (isEmpty())
       return null;
    else
    {
       BSTNode<T> node = root;
       while (node.getLeft() != null)
         node = node.getLeft();
       return node.getInfo();
    }
  }

  public T max()
  // If this BST is empty, returns null;
  // otherwise returns the largest element of the tree.
  {
    if (isEmpty())
       return null;
    else
    {
       BSTNode<T> node = root;
       while (node.getRight() != null)
         node = node.getRight();
       return node.getInfo();
    }
  }

  private int recSize(BSTNode<T> node)
  // Returns the number of elements in subtree rooted at node.
  {
    if (node == null)
      return 0;
    else
      return 1 + recSize(node.getLeft()) + recSize(node.getRight());
  }

  public int size()
  // Returns the number of elements in this BST.
  {
    return recSize(root);
  }

  public int size2()
  // Returns the number of elements in this BST.
  {
    int count = 0;
    if (root != null)
    {
      LinkedStack<BSTNode<T>> nodeStack = new LinkedStack<BSTNode<T>>();
      BSTNode<T> currNode;
      nodeStack.push(root);
      while (!nodeStack.isEmpty())
      {
        currNode = nodeStack.top();
        nodeStack.pop();
        count++;
        if (currNode.getLeft() != null)
          nodeStack.push(currNode.getLeft());
        if (currNode.getRight() != null)
          nodeStack.push(currNode.getRight());
      }
    }
    return count;
  }

  private boolean recContains(T target, BSTNode<T> node)
  // Returns true if the subtree rooted at node contains info i such that
  // comp.compare(target, i) == 0; otherwise, returns false.
 {
    if (node == null)
      return false;       // target is not found
    else if (comp.compare(target, node.getInfo()) < 0)
      return recContains(target, node.getLeft());   // Search left subtree
    else if (comp.compare(target, node.getInfo()) > 0)
      return recContains(target, node.getRight());  // Search right subtree
    else
      return true;        // target is found
  }

  public boolean contains (T target)
  // Returns true if this BST contains a node with info i such that
  // comp.compare(target, i) == 0; otherwise, returns false.
  {
    return recContains(target, root);
  }


  private T recGet(T target, BSTNode<T> node)
  // Returns info i from the subtree rooted at node such that
  // comp.compare(target, i) == 0; if no such info exists, returns null.
  {
    if (node == null)
      return null;             // target is not found
    else if (comp.compare(target, node.getInfo()) < 0)
      return recGet(target, node.getLeft());         // get from left subtree
    else
    if (comp.compare(target, node.getInfo()) > 0)
      return recGet(target, node.getRight());        // get from right subtree
    else
      return node.getInfo();  // target is found
  }

  public T get(T target)
  // Returns info i from node of this BST where comp.compare(target, i) == 0;
  // if no such node exists, returns null.
  {
    return recGet(target, root);
  }

  private void recAdd(T element, BSTNode<T> node)
  // Adds element to tree rooted at node; tree retains its BST property.
  {
      if(comp.compare(element, node.getInfo()) <= 0) {
          if (node.getLeft() == null)
              node.setLeft(new BSTNode<>(element));
          else
              recAdd(element, node.getLeft());
      }else {
          if (node.getRight() == null)
              node.setRight(new BSTNode<>(element));
          else
              recAdd(element, node.getRight());
      }
      }

  public boolean add (T element)
  // Adds element to this BST. The tree retains its BST property.
  {
      if(root==null)
          root = new BSTNode<>(element);
      else
        recAdd(element, root);
    return true;
  }


  private T getPredecessor(BSTNode<T> subtree)
  // Returns the information held in the rightmost node of subtree
  {
    BSTNode<T> temp = subtree;
    while (temp.getRight() != null)
      temp = temp.getRight();
    return temp.getInfo();
  }

  private BSTNode<T> removeNode(BSTNode<T> node)
  // Removes the information at node from the tree.
  {
    T data;
    if (node.getLeft() == null)
      return node.getRight();
    else if (node.getRight() == null)
      return node.getLeft();
    else
    {
      data = getPredecessor(node.getLeft());
      node.setInfo(data);
      node.setLeft(recRemove(data, node.getLeft()));
      return node;
    }
  }

  private BSTNode<T> recRemove(T target, BSTNode<T> node)
  // Removes element with info i from tree rooted at node such that
  // comp.compare(target, i) == 0 and returns true;
  // if no such node exists, returns false.
  {
    if (node == null)
      found = false;
    else if (comp.compare(target, node.getInfo()) < 0)
      node.setLeft(recRemove(target, node.getLeft()));
    else if (comp.compare(target, node.getInfo()) > 0)
      node.setRight(recRemove(target, node.getRight()));
    else
    {
      node = removeNode(node);
      found = true;
    }
    return node;
  }

  public boolean remove (T target)
  // Removes a node with info i from tree such that comp.compare(target,i) == 0
  // and returns true; if no such node exists, returns false.
  {
    root = recRemove(target, root);
    return found;
  }

  public Iterator<T> getIterator(Traversal orderType)
  // Creates and returns an Iterator providing a traversal of a "snapshot"
  // of the current tree in the order indicated by the argument.
  // Supports Preorder, Postorder, and Inorder traversal.
  {
    final LinkedQueue<T> infoQueue = new LinkedQueue<T>();
    if (orderType == Traversal.Preorder)
      preOrder(root, infoQueue);
    else
    if (orderType == Traversal.Inorder)
      inOrder(root, infoQueue);
    else
    if (orderType == Traversal.Postorder)
      postOrder(root, infoQueue);

    return new Iterator<T>()
    {
      public boolean hasNext()
      // Returns true if the iteration has more elements; otherwise returns false.
      {
        return !infoQueue.isEmpty();
      }

      public T next()
      // Returns the next element in the iteration.
      // Throws NoSuchElementException - if the iteration has no more elements
      {
        if (!hasNext())
          throw new IndexOutOfBoundsException("illegal invocation of next " +
                                     " in BinarySearchTree iterator.\n");
        return infoQueue.dequeue();
      }

      public void remove()
      // Throws UnsupportedOperationException.
      // Not supported. Removal from snapshot iteration is meaningless.
      {
        throw new UnsupportedOperationException("Unsupported remove attempted on "
                                              + "BinarySearchTree iterator.\n");
      }
    };
  }

  private void preOrder(BSTNode<T> node, LinkedQueue<T> q)
  // Enqueues the elements from the subtree rooted at node into q in preOrder.
  {
    if (node != null)
    {
      q.enqueue(node.getInfo());
      preOrder(node.getLeft(), q);
      preOrder(node.getRight(), q);
    }
  }

  private void inOrder(BSTNode<T> node, LinkedQueue<T> q)
  // Enqueues the elements from the subtree rooted at node into q in inOrder.
  {
    if (node != null)
    {
      inOrder(node.getLeft(), q);
      q.enqueue(node.getInfo());
      inOrder(node.getRight(), q);
    }
  }

  private void postOrder(BSTNode<T> node, LinkedQueue<T> q)
  // Enqueues the elements from the subtree rooted at node into q in postOrder.
  {
    if (node != null)
    {
      postOrder(node.getLeft(), q);
      postOrder(node.getRight(), q);
      q.enqueue(node.getInfo());
    }
  }

  public Iterator<T> iterator()
  // InOrder is the default, "natural" order.
  {
    return getIterator(Traversal.Inorder);
  }

  public void print(){
      String[] printArr = new String[findMaxDepth(1, this.root)];
      for(int i = 0 ; i < printArr.length ; i++)
          printArr[i] = "";
      printHelper(0, this.root, printArr);
      for (String x: printArr)
          System.out.println(x);
  }

  public static void printHelper(int level, BSTNode node, String[] strs){
        strs[level] += node.getInfo().toString().split("\\|")[2];
        for (int i = 0; i < strs.length ; i++){
             strs[i] += "\t";
          }
        if(node.getLeft()!=null)
            printHelper(level+1, node.getLeft(), strs);
        if(node.getRight()!=null)
            printHelper(level+1, node.getRight(), strs);
  }

  public static int findMaxDepth (int depth, BSTNode node){
      if(node.getRight()!=null&&node.getLeft()!=null)
          return Math.max(findMaxDepth(depth+1, node.getRight()),findMaxDepth(depth+1, node.getLeft()));
      if(node.getRight()!=null)
          return findMaxDepth(depth+1, node.getRight());
      if(node.getLeft()!=null)
          return findMaxDepth(depth+1, node.getLeft());
      return depth;

  }

    public static BSTNode findNode (String id, BSTNode node){
      if(id.equals(node.getInfo().toString().split("\\|")[2]))
          return node;
      if(node.getRight()!=null)
          return findNode(id, node.getRight());
        if(node.getLeft()!=null)
            return findNode(id, node.getLeft());
        return null;
    }

    public boolean remove (String target) {
        if(root.getInfo().toString().split("\\|")[2].equals(target)){
            if(root.getLeft()!=null) {
                BSTNode temp = root.getLeft();
                if(root.getRight().getRight()!=null)
                do temp = root.getRight();
                while (root.getRight().getRight() != null);

                temp.getRight().setRight(root.getRight());
                temp.getRight().setLeft(root.getLeft());

                root = temp.getRight();
                temp.setRight(null);

                return true;
            }else{
                BSTNode temp = root.getRight();

                if(root.getLeft().getLeft()!=null)
                do temp = root.getLeft();
                while( (root.getLeft().getLeft() != null));

                temp.getLeft().setRight(root.getRight());
                temp.getLeft().setLeft(root.getLeft());

                root = temp.getLeft();
                temp.setLeft(null);

                return true;
            }
        }

        BSTNode parent = findParent(target, this.root);
        BSTNode node;

        if (parent == null)
            return false;
        if (target.equals(parent.getLeft().getInfo().toString().split("\\|")[2])){
            node = parent.getLeft();
            parent.setLeft(node.getLeft());
            if(node.getRight()!=null)
                this.add((T) node.getRight().getInfo());
        }else {
            node = parent.getRight();
            parent.setRight(node.getRight());
            if(node.getRight()!=null)
                this.add((T) node.getRight().getInfo());
        }

        return true;
    }

    public static BSTNode findParent (String id, BSTNode node){
        if(node.getRight()!=null){
            if(id.equals(node.getRight().getInfo().toString().split("\\|")[2]))
                return node;
            BSTNode pot = findParent(id, node.getRight());
            if(pot != null)
                return pot;
        }
        if(node.getLeft()!=null) {
            if(id.equals(node.getLeft().getInfo().toString().split("\\|")[2]))
                return node;
            return findParent(id, node.getLeft());
        }
        return null;
    }



}
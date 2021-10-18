package p2_zahory_b;//----------------------------------------------------------------------------
// p1_zahory_b.LLNode.java                by Dale/Joyce/Weems                    Chapter 2
//
// Implements <T> nodes for a Linked List.
//----------------------------------------------------------------------------

public class LLNode<T>
{
  protected LLNode<T> next, nested;
  protected T info;
  
  public LLNode(T info)
  {
    this.info = info;
    next = null;
    nested = null;
  }
 
  public void setInfo(T info){ this.info = info;}
  public T getInfo(){ return info; }
  public void setNext(LLNode<T> next){this.next = next;}

  public void setNested(LLNode<T> nested) {
    this.nested = nested;
  }

  public LLNode<T> getNext(){ return next;}

  public LLNode<T> getNested() {
    return nested;
  }

  @Override
  public String toString() {
    return info.toString();
  }
}
 
 
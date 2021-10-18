package p4_zahory_b;//----------------------------------------------------------------------------
// p1_zahory_b.LLNode.java                by Dale/Joyce/Weems                    Chapter 2
//
// Implements <T> nodes for a Linked List.
//----------------------------------------------------------------------------

public class LLNode<T>
{
  protected LLNode<T> link,nested;
  protected T info;
  
  public LLNode(T info)
  {
    this.info = info;
    link = null;
    nested = null;
  }
 
  public void setInfo(T info){ this.info = info;}
  public T getInfo(){ return info; }
  public void setLink(LLNode<T> link){this.link = link;}
  public LLNode<T> getLink(){ return link;}

  public void setNested(LLNode<T> nested) {
    this.nested = nested;
  }

  public LLNode<T> getNested() {
    return nested;
  }

  @Override
  public String toString() {
    return info.toString();
  }
}
 
 
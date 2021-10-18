package p5_zahory_b;

public class BTNode<T>
{
    private T info;                // The node info
    private BTNode<T> left;       // A link to the left child node
    private BTNode<T> right;      // A link to the right child node

    public BTNode(T info)
    {
        this.info = info; left = null;  right = null;
    }

    public BTNode(String key, T info)
    {
        this.info = info; left = null;  right = null;
    }

    public void setInfo(T info){this.info = info;}
    public T getInfo(){return info;}

    public void setLeft(BTNode<T> link){left = link;}
    public void setRight(BTNode<T> link){right = link;}

    public BTNode<T> getLeft(){return left;}
    public BTNode<T> getRight(){return right;}

    @Override
    public String toString() {
        return info.toString();
    }
}
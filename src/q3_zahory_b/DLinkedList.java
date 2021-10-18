package q3_zahory_b;

//---------------------------------------------------------------------------
// LinkedQueue.java by Dale/Joyce/Weems Chapter 4
//
// Implements QueueInterface using a linked list.
//---------------------------------------------------------------------------


public class DLinkedList<T> {
    protected DLLNode<T> front; // reference to the front of this queue
    protected DLLNode<T> rear; // reference to the rear of this queue
    protected int numElements = 0; // number of elements in this queue

    public DLinkedList() {
        front = null;
        rear = null;
    }

    public void addEnd(T element)
// Adds element to the rear of this queue.
    {
        DLLNode<T> newNode = new DLLNode<T>(element);
        newNode.setForward(null);
        newNode.setBack(rear);
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.setForward(newNode);
            rear = newNode;
        }
        numElements++;
    }

    public T removeFront()
    {
        T element;
        element = front.getInfo();
        front = front.getForward();
        if (front == null)
            rear = null;
        else
            front.setBack(null);
        numElements--;
        return element;
    }

    public boolean isEmpty()
// Returns true if this queue is empty; otherwise, returns false.
    {
        return (front == null);
    }

    public boolean isFull()
// Returns false - a linked queue is never full.
    {
        return false;
    }

    public int size()
// Returns the number of elements in this queue.
    {
        return numElements;
    }

}
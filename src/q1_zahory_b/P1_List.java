package q1_zahory_b;

import java.util.Scanner;
import java.util.Stack;

public class P1_List {
    private LLNode<NovaClass> tail;


    public P1_List(Scanner sc){
        String[] splitData = sc.nextLine().split(", ");
        NovaClass info = new NovaClass(splitData[0],splitData[1],splitData[2]);

        this.tail = new LLNode<NovaClass>(info);
        this.tail.setLink(tail);
    }

    public LLNode<NovaClass> getTail() {
        return tail;
    }

    @Override
    public String toString() {
        LLNode<NovaClass> index = tail.getLink();
        StringBuilder string = new StringBuilder(index.toString().split("|")[0]);

        while(index.getLink().toString().split("|")[0]!=tail.toString().split("|")[0]){
            index = index.getLink();

            string.append(" --> " + index.getLink().toString().split("|")[0]);
        }

        return string.toString();
    }

    public void addClass (Scanner sc) {
        String[] splitData = sc.nextLine().split(", ");
        NovaClass info = new NovaClass(splitData[0],splitData[1],splitData[2]);
        LLNode<NovaClass> newNode = new LLNode<NovaClass>(info);

        newNode.setLink(tail.getLink());
        tail.setLink(newNode);
        this.tail = newNode;

    }

}
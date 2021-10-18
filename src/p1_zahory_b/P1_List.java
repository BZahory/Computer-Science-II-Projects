package p1_zahory_b;

import java.util.Scanner;
import java.util.Stack;

public class P1_List {
    private LLNode<NovaClass> tail;

    public P1_List(Scanner sc){
        String[] splitData = sc.nextLine().split(", ");
        NovaClass info = new NovaClass(splitData[0],splitData[1],splitData[2]);
        LLNode<NovaClass> newNode = new LLNode<>(info);
        this.tail = newNode;
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

        newNode.link = tail.link;
        this.tail.link = newNode;
        this.tail = newNode;
    }

}
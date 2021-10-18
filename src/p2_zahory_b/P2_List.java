package p2_zahory_b;


import java.util.Scanner;
import java.util.Stack;

public class P2_List {
    private LLNode<NovaClass> head;
    private LinkedStack<LLNode<NovaClass>> levelStack;


    public P2_List(Scanner sc){
        levelStack = new LinkedStack<LLNode<NovaClass>>();
        LLNode<NovaClass> index;

        index = head = new LLNode<NovaClass>(new NovaClass(sc.next()));
        levelStack.push(index);

        StringBuilder txt = new StringBuilder();

        while(sc.hasNext())
            txt.append(sc.next());

        while(txt.length()>0) {
            String temp;

            if (txt.charAt(0) == '(') {
                int c1 = txt.indexOf(")");
                int c2 = txt.indexOf("(");
                int c3 = txt.indexOf(",");

                if(c1==-1)
                    c1 = 999999;
                if(c2==-1)
                    c2 = 999999;
                if(c3==-1)
                    c3 = 999999;

                temp = txt.substring(1,Math.min(c1,Math.min(c2,c3)));


                index = index.nested = new LLNode<NovaClass>(new NovaClass(temp));
                levelStack.push(index);
                txt.delete(0, temp.length()+1);
            } else {
                int c1 = txt.indexOf(")");
                int c2 = txt.indexOf("(");
                int c3 = txt.indexOf(",");

                if(c1==-1)
                    c1 = 999999;
                if(c2==-1)
                    c2 = 999999;
                if(c3==-1)
                    c3 = 999999;

                temp = txt.substring(1,Math.min(c1,Math.min(c2,c3)));

                index = index.next = new LLNode<NovaClass>(new NovaClass(temp));
                txt.delete(0, temp.length());
            }
            //index = levelStack.pop();
        }



    }



    @Override
    public String toString() {
        StringBuilder string = new StringBuilder(head.toString().split("|")[0]);

        LLNode<NovaClass> indexNode = head;

        while(true){
            indexNode = indexNode.getNext();

            if(indexNode == null)
                break;

            string.append(" --> " + indexNode.toString().split("|")[0]);
        }

        return string.toString();
    }




}

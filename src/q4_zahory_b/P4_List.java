package q4_zahory_b;

import java.util.Scanner;

public class P4_List {
    private LLNode<NovaClass> head;

    public P4_List(Scanner sc) {
        this.head = new LLNode<NovaClass>(new NovaClass(sc.next()));

        StringBuilder input = new StringBuilder();

        while(sc.hasNext())
            input.append(sc.next());

        create(input, head);
    }

    public void create(StringBuilder input, LLNode<NovaClass> current) {

        while (input.length() > 0) {
            char keyChar = input.charAt(0);
            if(keyChar=='('||keyChar==')')
                input.delete(0,1);

            if (keyChar == '(' && input.length()>0) {
                getTail(current).setNested(new LLNode<NovaClass>(new NovaClass(input.substring(0, 1))));
                input.delete(0, 1);
                create(input, getTail(current).getNested());
            } else if (keyChar == ')' && input.length()>0) {
                return;
            } else if (input.length()>0) {
                getTail(current).setLink(new LLNode<NovaClass>(new NovaClass(input.substring(0, 1))));
                input = input.delete(0, 1);
            }

        }
    }

    public LLNode<NovaClass> getTail(LLNode<NovaClass> initial) {
        LLNode<NovaClass> tracker = initial;
        while (tracker.getLink() != null)
            tracker = tracker.getLink();
        return tracker;
    }

    public int getNextCharIndex(String input) {
        int leftP, rightP, min;
        leftP = input.indexOf('(');
        rightP = input.indexOf(')');

        if (leftP != -1)
            min = leftP;
        else
            min = rightP;

        if (rightP != -1 && rightP < min)
            min = rightP;


        return min;
    }

    public LLNode<NovaClass> getHead() {
        return head;
    }

    public void print(int indents, LLNode<NovaClass> start) {
        LLNode<NovaClass> current = start;
        if (current == null) {
            return;
        } else if (current.nested == null) {
            indentPrint(indents, current);
            print(indents, current.link);
        } else {
            indentPrint(indents, current);
            print(indents + 1, current.nested);
            if(current.link!=null)
                print(indents, current.link);
        }
    }

    public void indentPrint(int indents, LLNode<NovaClass> current) {
        for (int i = 0; i < indents; i++)
            System.out.print("\t");
        System.out.println(current);
    }
}
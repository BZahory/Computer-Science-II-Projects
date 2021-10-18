package q2_zahory_b;

import java.util.Scanner;

public class Q2_List {
    private LLNode<NovaClass> head;

    public Q2_List(Scanner sc){
        this.head = new LLNode<NovaClass>(new NovaClass(sc.next()));

        StringBuilder input = new StringBuilder();

        while(sc.hasNext())
            input.append(sc.next());

        LinkedStack<LLNode<NovaClass>> nodeStack = new LinkedStack<>();
        LLNode<NovaClass> current = head;



        while(input.length()>0){
            char keyChar = input.charAt(0);
            if(keyChar=='('||keyChar==')')
                input.delete(0,1);

            int nextCharIndex = getNextCharIndex(input.toString());

            if(keyChar == '(' && input.length()>0){
                nodeStack.push(getTail(current));
                getTail(current).setNested(new LLNode<NovaClass>(new NovaClass(input.substring(0,1))));
                current = getTail(current).getNested();
                input = input.delete(0,1);
            }else if(keyChar == ')' && input.length()>0){
                current = nodeStack.top();
                nodeStack.pop();
            }else if(input.length()>0){
                getTail(current).setLink(new LLNode<NovaClass>(new NovaClass(input.substring(0,1))));
                input  = input.delete(0,1);
            }

        }
    }

    public LLNode<NovaClass> getTail(LLNode<NovaClass> initial){
        LLNode<NovaClass> tracker = initial;
        while(tracker.getLink()!=null)
            tracker = tracker.getLink();
        return tracker;
    }

    public int getNextCharIndex(String input){
        int leftP,rightP,min;
        leftP = input.indexOf('(');
        rightP = input.indexOf(')');

        if(leftP != -1)
            min = leftP;
        else
            min = rightP;

        if(rightP != -1 && rightP < min)
            min = rightP;

        return min;
    }

    public void print(int a, int b) {
        LinkedStack<LLNode<NovaClass>> nodeStack = new LinkedStack<>();
        int indents = 0;
        LLNode<NovaClass> current = this.head;
        LinkedStack<LLNode<NovaClass>> pNodes = new LinkedStack<>();
        pNodes.push(current);

        while(!pNodes.isEmpty()) {
            if (current==null){
                if(pNodes.isEmpty()) {
                    return;
                }else{
                    current = pNodes.top();
                    current = current.getLink();
                    pNodes.pop();
                    indents--;
                }
            }else if(current.nested==null){
                if(indents == a || indents == b) {
                    System.out.print(current + " ");
                }

                current = current.link;
            }else{
                if(indents == a || indents == b) {
                    System.out.print(current + " ");
                }

                pNodes.push(current);
                indents++;
                current = current.nested;
            }
        }
    }
}

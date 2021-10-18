package p4_zahory_b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir"), "src\\p4_zahory_b\\p5.txt"));
        BinarySearchTree bst = new BinarySearchTree();
        while(sc.hasNextLine()){
            String[] temp = sc.nextLine().split(", ");
            bst.add(new NovaClass(temp[0],temp[1],temp[2]));
        }
        bst.print();

        Scanner console = new Scanner(System.in);
        System.out.println("Node to be removed?");
        if(bst.remove(console.next()))
            bst.print();
        else
            System.out.println("Node does not exist.");

    }
            }
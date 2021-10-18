package p5_zahory_b;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir"), "src\\p5_zahory_b\\p5.txt"));
        BinaryTree<BTNode<DecisionPoint>> bt = new BinaryTree<>();
        bt.createTree(sc);

        Scanner console = new Scanner(System.in);
        System.out.println("Traversal? Enter 1 for preorder, 2 for inorder, or 3 for postorder traversal.");
        int tInd = Integer.parseInt(console.nextLine());
        bt.takeIteratorInput(tInd);

        System.out.println();

        BinarySearchTree<BTNode<DecisionPoint>> bst = new BinarySearchTree(bt,tInd);
        System.out.println("Traversal? Enter 1 for preorder, 2 for inorder, or 3 for postorder traversal.");
        int tInd2 = Integer.parseInt(console.nextLine());
        bst.takeIteratorInput(tInd2);

        bt.predictGrade();
    }
            }
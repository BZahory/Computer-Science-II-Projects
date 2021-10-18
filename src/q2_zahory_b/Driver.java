package q2_zahory_b;

import java.io.*;
import java.util.*;


public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir"), "src\\q2_zahory_b\\q2.txt"));
        Q2_List list = new Q2_List(sc);
        Scanner console = new Scanner(System.in);
        System.out.println("Which lines would you like to merge?");
        list.print(console.nextInt(),console.nextInt());
    }
}
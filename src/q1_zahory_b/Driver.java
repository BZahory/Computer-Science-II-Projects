package q1_zahory_b;

import java.io.*;
import java.util.*;


public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir"),"src\\p1_zahory_b\\p1.txt"));
        P1_List list = new P1_List(sc);

        while(sc.hasNextLine()) {
            list.addClass(sc);
        }

        System.out.println("A linked list has been built:\n" + list);

    }
}

package p2_zahory_b;

import java.io.*;
import java.util.*;


public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir"),"src\\p2_zahory_b\\p2.txt"));
        P2_List list = new P2_List(sc);System.out.println(list);
    }
}

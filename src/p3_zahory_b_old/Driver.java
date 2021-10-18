package p3_zahory_b_old;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Driver {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File(System.getProperty("user.dir"), "src\\p3_zahory_b\\p5.txt"));
        P3_List list = new P3_List(sc);
        list.print(0,list.getHead());
    }
}
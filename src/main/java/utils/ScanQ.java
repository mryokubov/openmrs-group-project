package utils;

import java.util.Scanner;

public class ScanQ {

public static void scanTest(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Did all the tests pass?");
        String scanLine = scanner.nextLine();
        if(scanLine.equals("yes")){
            System.out.println("Congrats!!!");
        }
        else{
            System.out.println("Try again!");
        }
      }
}
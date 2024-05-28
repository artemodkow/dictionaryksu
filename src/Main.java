

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in, "UTF-8");
        Oper oper = new Oper();

        int flagDic = 0;
        do {
            System.out.print("\nEnter number operation: ");
            System.out.print("\n1 - Select 1 dictionary");
            System.out.print("\n2 - Select 2 dictionary");
            System.out.print("\n0 - Exit progam\n");

            try {
                flagDic = Integer.parseInt(in.nextLine());
            } catch (java.lang.NumberFormatException e) {
                flagDic = 0;
            }

            if (flagDic==0 || flagDic>2){
                break;
            }

            System.out.print("\nEnter name file for load:\n");
            String nameFile = in.nextLine();
            Dict dt = new Dict(flagDic,nameFile);

            int flag = 1;
            do {
                System.out.print("\nEnter number operation: ");
                System.out.print("\n1 - Add word");
                System.out.print("\n2 - Listing all words");
                System.out.print("\n3 - Remove word");
                System.out.print("\n4 - Find word");
                System.out.print("\n0 - Go to dictionary selection" + "\n");
                int num = 10;

                try {
                    num = Integer.parseInt(in.nextLine());
                } catch (java.lang.NumberFormatException e) {
                    num = 10;
                }

                if (num == 0) {
                    flag = 0;
                } else if (num == 1) {
                    System.out.print("Enter key: ");
                    String wordEng = in.nextLine();
                    System.out.print("Enter value: ");
                    String wordRus = in.nextLine();
                    oper.printStr(dt.setWord(wordEng, wordRus));
                } else if (num == 2) {
                    oper.printStr(dt.getAllWord());
                } else if (num == 3) {
                    System.out.print("\nEnter key: ");
                    String wordEng = in.nextLine();
                    oper.printStr(dt.removeWord(wordEng));
                } else if (num == 4) {
                    System.out.print("\nEnter key: ");
                    String wordEng = in.nextLine();
                    System.out.println("\nValue: " + dt.getWord(wordEng));
                }
            }

            while (flag > 0);
        }
        while (flagDic > 0);
    }

}

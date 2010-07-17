/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hoppity_hop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author jteng
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // reading in file
        String str = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader("input.txt"));
            str = in.readLine();
            in.close();
        } catch (IOException e) {
            System.out.print(e.toString());
        }
        int number = Integer.parseInt(str);

        for (int counter = 1; counter <= number; counter++) {
            if ((counter%3 == 0) && (counter%5 ==0)){
                System.out.println(counter + " Hop");
            }
            else if (counter%3 == 0)
                System.out.println(counter + " Hoppity");
            else if (counter%5 == 0)
                System.out.println(counter + " Hophop");
        }
    }
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hoppity_hop;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author jteng
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Liar_Liar(args[0]);
    }

    /**
     * Hoppity Hop!
        To help test whether your puzzle submissions fit the guidelines, try this simple test puzzle. Your solution must follow the guidelines like any other puzzle. Write a program that takes as input a single argument on the command line. This argument must be a file name, which contains a single positive integer. The program should read this file and obtain the integer within, and then output a sequence of strings based upon the number (details below).


        Input specifications

        The input file will contain a single positive integer (in base 10) expressed as a string using standard ASCII text (e.g. for example, the number "15" but without the double quotes). This number may or may not be padded on either side with white space. There will be no commas, periods, or any other non-numeric characters present within the number. The file may or may not terminate in a single new line character ("\n"). An example input file is below:
        15



        Output specifications

        The program should iterate over all integers (inclusive) from 1 to the number expressed by the input file. For example, if the file contained the number 10, the submission should iterate over 1 through 10. At each integer value in this range, the program may possibly (based upon the following rules) output a single string terminating with a newline.

        For integers that are evenly divisible by three, output the exact string Hoppity, followed by a newline.
        For integers that are evenly divisible by five, output the exact string Hophop, followed by a newline.
        For integers that are evenly divisble by both three and five, do not do any of the above, but instead output the exact string Hop, followed by a newline.

        Example output (newline at end of every line):
        Hoppity
        Hophop
        Hoppity
        Hoppity
        Hophop
        Hoppity
        Hop
     */
    public static void Hoppity_Hop(){
        // reading in file
        ArrayList<String> file = new ArrayList<String>();
        String filename = "../input.txt";
        int number;
        file = readFile(filename);
        if (file.size() < 1){
            return;
        }
        else {
            number = Integer.parseInt(file.get(0));
        }
        

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

    private static ArrayList<String> readFile(String filename) {
        ArrayList<String> raw_data = new ArrayList<String>();
        String str;
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            String line = "";
            while ((line = in.readLine()) != null){
                raw_data.add(line);
            }
            in.close();
        } catch (IOException e) {
            System.out.print(e.toString());
        }
        return raw_data;
    }
    /**
        Meep meep!

        To help test whether your puzzle submissions fit the guidelines, try this simple test puzzle. Your solution must follow the guidelines like any other puzzle. Write a program that takes as input a single argument on the command line. Normally this argument must be the name of a text file; however, for this puzzle your program should ignore the argument given. Instead, your program must print to standard out the string "Meep meep!" (without the double quotes and with exact capitalization) followed by a single newline (not zero or two).


        Input specifications

        The input file will contain ASCII text that is going to be completely ignored by your program. In fact, do not even bother opening up the file, it will just complicate things. The input file format is as follows:
        <Lots of ASCII characters that do not matter>
        Example input file:
        Just ignore me, I am not important.



        Output specifications

        The output should be the string "Meep meep!" (without the double quotes, using exact capitalization) followed by a single newline (don't forget this part!).

        Example output (newline after string):
        Meep meep!
     */
    public static void Meep_Meep(String[] args){
        if (args.length > 0){
            //System.out.println("First argument: "+args[0]);
            System.out.println("Meep meep!");
        }
    }
    /**
     *
    Liar, Liar

    As a newbie on a particular internet discussion board, you notice a distinct trend among its veteran members; everyone seems to be either unfailingly honest or compulsively deceptive. You decide to try to identify the members of the two groups, starting with the assumption that every senior member either never lies or never tells the truth. You compile as much data as possible, asking each person for a list of which people are liars. Since the people you are asking have been around on the board for a long time, you may assume that they have perfect knowledge of who is trustworthy and who is not. Each person will respond with a list of people that they accuse of being liars. Everyone on the board can see that you are a tremendous n00b, so they will grudgingly give you only partial lists of who the liars are. Of course these lists are not to be taken at face value because of all the lying going on.

    You must write a program to determine, given all the information you've collected from the discussion board members, which members have the same attitude toward telling the truth. It's a pretty popular discussion board, so your program will need to be able to process a large amount of data quickly and efficiently.


    Input Specifications

    Your program must take a single command line argument; the name of a file. It must then open the file and read out the input data. The data begins with the number of veteran members n followed by a newline. It continues with n chunks of information, each defining the accusations made by a single member. Each chunk is formatted as follows:
     <accuser name> <m>
    followed by m lines each containing the name of one member that the accuser says is a liar. accuser name and m are separated by some number of tabs and spaces. m will always be in [0, n]. All member names contain only alphabetic characters and are unique and case-sensitive.

    Example input file:
     5
    Stephen   1
    Tommaso
    Tommaso   1
    Galileo
    Isaac     1
    Tommaso
    Galileo   1
    Tommaso
    George    2
    Isaac
    Stephen



    Output Specifications

    Your output must consist of two numbers separated by a single space and followed by a newline, printed to standard out. The first number is the size of the larger group between the liars and the non-liars. The second number is the size of the smaller group. You are guaranteed that exactly one correct solution exists for all test data.

    Example output:
    3 2
     */
    private static void Liar_Liar(String filename) {
        ArrayList grp1 = new ArrayList();
        ArrayList grp2 = new ArrayList();
        ArrayList<String> file = new ArrayList<String>();
        file = readFile(filename);
        
    }

}

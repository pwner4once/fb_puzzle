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
        //Liar_Liar(args[0]);
        Breathalyzer(args[0]);
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
        ArrayList<String> grp1 = new ArrayList<String>();
        ArrayList<String> grp2 = new ArrayList<String>();
        ArrayList<String> file = readFile(filename);
        int numberOfAccusation = Integer.parseInt(file.get(0));
        int tracker = 1;
        boolean grpMade = false;
        while(numberOfAccusation > 0){
            String line = file.get(tracker++);
            String[] pieces = line.split(" ");

            // get rid of stupid blank fields within the string array
            ArrayList<String> pieces_alns = new ArrayList<String>();
            for (int index = 0; index < pieces.length; index++) {
                if (!pieces[index].equals("")) {
                    pieces_alns.add(pieces[index]);
                }
            }
            String[] pieces_ns = new String[pieces_alns.size()];
            pieces_alns.toArray(pieces_ns);

            // process the file by groups starting with accuser and # of accused person
            if (pieces_ns.length == 2){
                if (grpMade){
                    ArrayList<String> accuserGrp = null;
                    ArrayList<String> accusedGrp = null;
                    String accuser = pieces_ns[0];
                    // pieces[0] : accuser name
                    // pieces[1] : number of accused person

                    // try to determine accuser's group
                    if (grp1.contains(accuser)){
                        accuserGrp = grp1;
                        accusedGrp = grp2;
                    }
                    else if (grp2.contains(accuser)){
                        accuserGrp = grp2;
                        accusedGrp = grp1;
                    }

                    // adding all accused person to apropriate grp
                    for (int counter = 0; counter < Integer.parseInt(pieces_ns[1]); counter++) {
                        String accused = file.get(tracker++);
                        if (accusedGrp == null || accuserGrp == null){
                            if (grp1.contains(accused)){
                                accusedGrp = grp1;
                                accuserGrp = grp2;
                            } else{
                                accusedGrp = grp2;
                                accuserGrp = grp1;
                            }
                        }
                        else{
                            if (!accusedGrp.contains(accused))
                                accusedGrp.add(accused);
                        }
                    }
                    if (!accuserGrp.contains(accuser))
                        accuserGrp.add(accuser);
                }
                numberOfAccusation--;

              }else{ // make initial group
                  grpMade = true;
                  grp1.add(pieces_ns[0]);
                  for (int i = 0; i < Integer.parseInt(pieces_ns[1]); i++) {
                      grp2.add(file.get(tracker++));
                  }
               }

        }

        if (grp1.size() > grp2.size())
            System.out.println(grp1.size() + " " + grp2.size());
        else
            System.out.println(grp2.size() + " " + grp1.size());
    }

    /**
     * Breathalyzer

        To safeguard against the dreaded phenomenon of wall posting while drunk, Facebook is implementing a feature that detects when post content is too garbled to have been done while sober and informs the user that they need to take an online breathalyzer test before being allowed to post.

        Unfortunately, there is far too much content for a given set of persons to evaluate by hand. Fortunately, you are a programmer of some repute and can write a program that processes and evaluates wall posts. You realize that such a program would be of great use to society and intend to resolve the problem once and for all. The program you write must compute a score for a body of text, returning this score upon completion.

        Your program will be given a list of accepted words and run on one wall post at a time. For each word W in the post, you must find word W' from the list of accepted words such that the number of changes from W to W' is minimized. It is possible that W is already W' and thus the number of changes necessary is zero. A change is defined as replacing a single letter with another letter, adding a letter in any position, or removing a letter from any position. The total score for the wall post is the minimum number of changes necessary to make all words in the post acceptable.


        Input Specification

        Your program must take a single string argument, representing the file name containing the wall post to analyze. In addition, your program must open up and read the accepted word list from the following static path location:
         /var/tmp/twl06.txt
        For testing purposes, you may download and examine the accepted word list here. When submitting your code, you do not need to include this file, as it is already present on the machine.

        The input file consists entirely of lower case letters and space characters. You are guaranteed that the input file will start with a lower case letter, and that all words are separated by at least one space character. The file may or may not end with a new line character.

        Example input file:
         tihs sententcnes iss nout varrry goud
        You are guaranteed that your program will run against well formed input files and that the accepted word list is identical to the one provided for testing.


        Output Specification

        Your program must print out the minimum number of changes necessary to turn all words in the input wall post into accepted words as defined by the word list file. Words may not be joined together, or separated into multiple words. A change in a word is defined as one of the following:
        Replacing any single letter with another letter.
        Adding a single letter in any position.
        Removing any single letter.
        This score must be printed out as an integer and followed by a single new line.

        Example Output (newline after number):
        8
     * @param filename
     */
    public  static void Breathalyzer(String filename){
        ArrayList<String> raw_data = readFile(filename);
        BreathalyzerClass breathlyzer = new BreathalyzerClass();
        int[] test = breathlyzer.wordIndex("asdfweni");
        
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
}

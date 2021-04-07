/*
Maram  Alshehri

CPCS204
P2

15/10/2017
 */
package wordcounter;

/**
 *
 * @author Maram
 */
import java.io.*;
import java.util.*;

public class FrequencyCounter {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException {

        // declare and create Object reading from file and checking if it exists or not
        File file1 = new File("document.txt");
        if (!file1.exists()) {
            System.out.println("The document.txt file dose not exist");
        }

        // declare and create Object reading from file and checking if it exists or not
        File file2 = new File("commands.txt");
        if (!file1.exists()) {
            System.out.println("The commands.txt file dose not exist");
        }
        // declare and create Object reading from file and checking if it exists or not         
        File file3 = new File("stopwords.txt");
        if (!file1.exists()) {
            System.out.println("The Fstopwords.txt file dose not exist");
        }

        // declare and create object (write) to write into output file
        File file4 = new File("output.txt");
        PrintWriter write = new PrintWriter(file4);

        //create a scanner
        Scanner input1 = new Scanner(file1);
        Scanner input2 = new Scanner(file2);
        Scanner input3 = new Scanner(file3);

        //   declare variabls to read and command
        String command, reader;
        // counting the total words
        int total = 0;

///declare and create list "linked list array"
        DocumentWords list = new DocumentWords();
        ///

        // declear stopwordss' array and declare variabl to read from stopwordss file, and read from command file the stop word orderd
        String[] stopwords = new String[174];
        String stopR, stopOrd;

        //declear variabl to read word after command WORDFREQUENCY
        String wordF;

        //to calculate uniq word 
        int uniq = 0;

        //to calculate the ratio
        double ratio = 0;

        // to calculate uniq word Befor Delet 
        int uniqBeforDelet;

        // while loop for insert data into linked list
        do {
            reader = input1.next();
            if (list.search(reader)) {
            } else {
                list.insert(reader);
            }

        } while (input1.hasNext());

        // while loop for fill array  "stopwords"
        do {

            for (int i = 0; i < stopwords.length; i++) {
                stopR = input3.next();
                stopwords[i] = stopR;
            }
        } while (input3.hasNext());

        // while loop for command
        do {

            //to read command from file
            command = input2.next();
            switch (command) {
                case "TOTALWORDS":

                    total = list.sumTotal();

                    write.println("Total number of words in the document = " + total);
                    break;

                case "UNIQUEWORDS":
                    uniq = list.sumUniq();
                    write.println("Number of unique words in the document = " + uniq);
                    break;

                case "TYPESTOKENSRATIO":
                    ratio = (double) uniq / total;

                    write.println("Types to tokens ratio in the document = " + ratio);
                    break;

                case "ISSTOPWORD":
                    stopOrd = input2.next();
                    for (int i = 0; i < stopwords.length; i++) {
                        if (stopwords[i].equals(stopOrd)) {
                            write.println("\"" + stopOrd + "\" is a stopword");
                        }

                    }
                    break;

                case "MOSTFREQUENT":
                    list.compare(write);

                    break;

                case "WORDFREQUENCY":
                    wordF = input2.next();
                    if (list.search2(wordF)) {
                        list.numberOfF(write, wordF);
                    } else {
                        write.println("The frequency of \"" + wordF + "\" in the document is " + 0);
                    }
                    break;

                case "REMOVESTOPWORDS":

                    list.delete(stopwords);

                    uniq = list.sumUniq();

                    total = list.sumTotal();
                    write.println("Total number of words in the document after removing stopwords = " + total);
                    write.println("Number of unique words in the document after removing stopwords = " + uniq);
                    write.println("Types to tokens ratio in the document after removing stopwords = " + ((double) uniq / total));

                    break;

                case "PRINTLIST":
                    if (list.isEmpty()) {
                        System.out.println(">    Error: cannot print nodes (the list is empty)");
                        System.out.println();
                    } else {
                        write.println("------------------------------------");
                        list.PrintList(write);

                        write.println("------------------------------------");
                    }

                    break;

                case "QUIT":
                    write.println("Goodbye.");
                    input2.close();
                    write.close();
                    System.exit(0);
                    break;

            }

        } while (input2.hasNext());
Scanner in= new Scanner(System.in);
        System.out.println("Enter anum");
        int a=in.nextInt();
        
        boolean maram=true;
                while (maram=false)
                {
                    if (a==1)
                    {maram=true;}
                    else {maram =false;
                    
                        System.out.println("Try agin ");}
                }
    }

    //=====================================================
}

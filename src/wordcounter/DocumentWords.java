/*
Maram Alshehri

CPCS204
P2

15/10/2017
 */
package wordcounter;

import java.io.PrintWriter;

/**
 *
 * @author Maram
 */
public class DocumentWords {

    private Word head;

    public DocumentWords() {
        head = null;

    }
    //==========================================================================================

    // boolean | isEmpty()
    //
    public boolean isEmpty() {
        return head == null;
    }

    //==========================================================================================
    public boolean search(String word) {
        return search(head, word);
    }
    //
    // boolean | search(Word, int)
    //

    private boolean search(Word head, String word) {
        Word helpPtr = head;
        while (helpPtr != null) {
            if (helpPtr.getWord().equals(word)) {
                //To increase the frequency
                helpPtr.setFrequency(1);
                return true;
            }
            helpPtr = helpPtr.getNext();
        }
        return false;
    }

    //==========================================================================================
    //
    // void | insert(int)
    //
    public void insert(String word) {
        head = insert(head, word);
    }
    //
    // LLnode | insert(Word, value)
    //

    private Word insert(Word head, String word) {

        // IF there is no list, newNode will be the first node, so just return it
        if (head == null) {
            head = new Word(word, head);

            return head;
        } // ELSE, we have a list. Insert the new node at the correct location
        else {
            // We need to traverse to the correct insertion location...so we need a help ptr
            Word helpPtr = head;
            Word newNode = new Word(word, helpPtr.getNext());
            helpPtr.setNext(newNode);
            // Traverse to correct insertion point
            while (helpPtr.getNext() != null) {

                helpPtr = helpPtr.getNext();

            }
           
        }
        // Return head
        return head;
    }

    //==========================================================================================
    //
    // void | PrintList()
    //
    public void PrintList(PrintWriter write) {
        PrintList(head, write);

    }

    //
    // void | PrintList(LLnode)
    //
    private void PrintList(Word head, PrintWriter write) {

        // We need to traverse...so we need a help ptr
        Word helpPtr = head;
        Word head2 = head;
        // Traverse to correct insertion point
        while (helpPtr != null) {

            // Print the data value of the node
            if (helpPtr.getWord().equals("The")) {
                helpPtr = helpPtr.getNext();
            }
            write.print(helpPtr.getWord() + " : " + helpPtr.getFrequency());
            write.println();
            // Step one node over
            helpPtr = helpPtr.getNext();
        }

        ////// This step(while loop ) JUST for print word "The" End of List
        while (head2 != null) {

            if (head2.getWord().equals("The")) {
                write.print(head2.getWord() + " : " + head2.getFrequency());
                write.println();
            }

            head2 = head2.getNext();
        }

    }

////==========================================================================================
    //sum uniq
    //UNIQUEWORDS 
    public int sumUniq() {
        return sumUniq(head);
    }

    private int sumUniq(Word head) {
        Word helpPtr = head;
        int sumU = 0;
        while (helpPtr != null) {
            sumU++;
            helpPtr = helpPtr.getNext();
        }

        return sumU;
    }

    //==========================================================================================
    //sum uniq
    //TOTALWORDS 
    public int sumTotal() {
        return sumTotal(head);
    }

    private int sumTotal(Word head) {
        Word helpPtr = head;
        int sumU = 0;
        while (helpPtr != null) {
            sumU += helpPtr.getFrequency();
            helpPtr = helpPtr.getNext();
        }

        return sumU;
    }

    //==========================================================================================
    // void | compare()
    //
    public void compare(PrintWriter write) {
        compare(head, write);
        // write.close();
    }
    //
    // void | compare(Word)
    //

    private void compare(Word head, PrintWriter write) {
        // We need to traverse...so we need a help ptr
        Word helpPtr = head;
        int most = helpPtr.getFrequency();
        // Traverse , Find The most frequent
        while (helpPtr != null) {
            if (helpPtr.getFrequency() > most) {
                most = helpPtr.getFrequency();
            }
            helpPtr = helpPtr.getNext();
        }
        // This step(while loop )for print The most frequent word in the document
        helpPtr = head;
        while (helpPtr != null) {
            if (helpPtr.getFrequency() == most) {
                write.println("The most frequent word in the document is " + "\"" + helpPtr.getWord() + "\"" + " with a frequency of " + helpPtr.getFrequency());

                break;
            }
            helpPtr = helpPtr.getNext();
        }

    }
//==========================================================================================

    public void numberOfF(PrintWriter write, String wordF) {
        numberOfF(head, write, wordF);
    }

    private void numberOfF(Word head, PrintWriter write, String wordF) {
        Word helpPtr = head;
        while (helpPtr != null) {
            if (helpPtr.getWord().equals(wordF)) {
                write.println("The frequency of \"" + helpPtr.getWord() + "\" in the document is " + helpPtr.getFrequency());
            }
            helpPtr = helpPtr.getNext();
        }

    }
//==========================================================================================

    public boolean search2(String word) {
        return search2(head, word);
    }
    //
    // boolean | search2(Word, String)
    //

    private boolean search2(Word head, String word) {
        Word helpPtr = head;
        while (helpPtr != null) {
            if (helpPtr.getWord().equals(word)) {

                return true;
            }
            helpPtr = helpPtr.getNext();
        }
        return false;
    }

//==========================================================================================
    //
    // void | delete(int)
    //
    public void delete(String[] data) {
        head = delete(head, data);
    }

    //
    // LLnode | delete(LLnode, value)
    //
    private Word delete(Word head, String[] data) {
        // We can only delete if the list has nodes (is not empty)
        if (!isEmpty()) {
            // IF the first node (at the head) has the data value we are wanting to delete
            // we found it. Delete by skipping the node and making head point to the next node.
            for (int i = 0; i < data.length; i++) {

                if (head.getWord().equals(data[i])) {
                    head = head.getNext();
                } // ELSE, the data is perhaps somewhere else in the list...so we must traverse and look for it
                else {
                    // We need to traverse to find the data we want to delete...so we need a help ptr
                    Word helpPtr = head;
                    // Traverse to correct deletion point
                    while (helpPtr.getNext() != null) {
                        if (helpPtr.getNext().getWord().equals(data[i])) {
                            helpPtr.setNext(helpPtr.getNext().getNext());
                            break; // we deleted the value and should break out of the while loop
                        }
                        helpPtr = helpPtr.getNext();
                    }
                }
            }
            // return the possibly updated head of the list
            return head;
        }
        return head;
    }

}

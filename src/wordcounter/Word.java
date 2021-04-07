/*
Maram Alshehri

CPCS204
P2

15/10/2017
 */
package wordcounter;

/**
 *
 * @author Maram
 */
public class Word {

    private String word;
    private int frequency;
    private Word next;

    public Word() {
        word = null;
        next = null;
    }
    //==================================

    public Word(String word) {
        this.word = word;
        frequency = 1;
        next = null;
    }

    //====================================
    public Word(String word, Word next) {//نستخدمها لما انسرت للهد وهو فاضي
        this.word = word;
        this.frequency = 1;
        this.next = next;
    }
    //==================================

    public String getWord() {
        return word;
    }
    //==================================

    public void setWord(String word) {
        this.word = word;
    }
    //==================================

    public int getFrequency() {
        return frequency;
    }
    //==================================

    public void setFrequency(int frequency) {
        this.frequency += frequency;
    }
    //==================================

    public Word getNext() {
        return next;
    }
    //==================================

    public void setNext(Word next) {
        this.next = next;
    }

}

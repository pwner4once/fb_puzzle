/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package hoppity_hop;

import java.util.ArrayList;

/**
 *
 * @author jteng
 */
class BreathalyzerClass {

    ArrayList<String> words = null;
    ArrayList<int[]> wordsSorted = null;
    ArrayList<Integer> changes = null;

    
    public BreathalyzerClass() {
        this.words = new ArrayList<String>();
        this.wordsSorted = new ArrayList<int[]>();
        this.changes =  new ArrayList<Integer>();
    }

    public BreathalyzerClass(ArrayList<String> _words, ArrayList<int[]> _wordsSorted, ArrayList<Integer> _changes) {
        this.words = _words;
        this.wordsSorted = _wordsSorted;
        this.changes = _changes;
    }

    public void addRow(String word, int[] wordSorted, int changes){
        if ((this.words != null) && (this.wordsSorted != null) && (this.changes != null)){
            this.words.add(word);
            this.wordsSorted.add(wordSorted);
            this.changes.add(new Integer(changes));;
        }
    }

    public void addRow(String word){
        this.words.add(word);
        this.wordsSorted.add(wordIndex(word));
        this.changes.add((new Integer(countChanges(word))));
    }
    
    /**
     * return an array of 24(a,b,c,...z) with value as occurence of that alphabet in that word
     * @param word
     * @return
     */
    public int[] wordIndex(String word){
        int[] alphabetIndex = new int[24];
        word = word.toLowerCase();
        for (int i = 0; i < word.length(); i++) {
            alphabetIndex[word.charAt(i) - 'a']++;
        }
        return alphabetIndex;
    }

    private int countChanges(String word, int[] anotherWordIndex) {
        int[] wordIndex = wordIndex(word);
        
        int changes = 0;
        return changes;
    }

    private int countChanges(String word) {
        int[] wordIndex = wordIndex(word);

        int changes = 0;
        return changes;
    }


}

package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

//Author Name: Alejandro Vargas
//Date: 10/27/2021
//Program Name: main.Vargas_module7_word_occurrence
//Purpose: load a text file and output the top 20 most used words with unit testing added 

/**
 * An object that process a file and return a map with all the words occurrences
 * Also process a map of words and counters and return a list of the words with more occurrences 
 */
public class WordOccurrence {

	/**
	 * Returns <tt>Map<String, Integer></tt> if the file exist and contains words.
	 * More formally, it will return a map with all the words
	 * that the file contains and it concurrence, where the key is the word itself,
	 * and the value is the number of occurrences in the file.
	 * 
	 * @param file file that will be checked by the wordOccurrence.
	 * @return <tt>Map<String, Integer></tt> if the file contains words 
	 * @throws FileNotFoundException if the file does not exist
	 */
    public Map<String, Integer> wordOccurrence(File file) throws FileNotFoundException {
        Map<String, Integer> wordsCounter = new HashMap<>();
    
        // filling the array list with the words of the file to check
        Scanner myReader = new Scanner(file);

        while (myReader.hasNextLine()) {
            String line = myReader.nextLine();
            String[] words = line.split("\\s?[, \\.:;?!-]\\s?");
            for (String word : words) {

                Integer counts = wordsCounter.get(word);
                if (counts != null) {
                    wordsCounter.put(word, counts + 1);
                } else {
                    wordsCounter.put(word, 1);
                }
            }

            // excluding the unnecessary characters
            wordsCounter.remove("");
            wordsCounter.remove(" ");
            wordsCounter.remove("?");
            wordsCounter.remove("!");


        }

        myReader.close();

        return wordsCounter;
    }
    /**
	 * Returns <tt>List<Map.Entry<String, Integer>></tt> it returns the amount of entries
	 * that would be define by the top variable. Sorted in decreasing order.
	 * 
	 * @param wordsCounter the map which will be processed 
	 * @param top the number which determine the words on the list
	 * @return <tt>List<Map.Entry<String, Integer>></tt> if the file contains words 
	 * 
	 */
    public List<Map.Entry<String, Integer>> getTopCounters(Map<String, Integer> wordsCounter, int top) {
        List<Map.Entry<String, Integer>> topCounters = new ArrayList<>(wordsCounter.entrySet());

        topCounters.sort(this::sortEntryList);

        if (topCounters.size() > top) {
            return topCounters.subList(0, top);
        } else {
            return topCounters;
        }
    }

    /**
	 * Returns <tt>integer</tt> depending on the input(-1 , 0 , 1) depending on the input;
	 * if the value of a entry is more than the value of b entry, it will return -1
	 * if both values are equal it will return 0
	 * otherwise it will return 1 
	 * 
	 * 
	 * @param a first entry to be compared
	 * @param b second entry to be compared
	 * @return <tt>integer</tt> depending on the input(-1 , 0 , 1)
	 * 
	 */
    private int sortEntryList(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
        if (a.getValue() > b.getValue()) {
            return -1;
        } else if (a.getValue().equals(b.getValue())) {
            return 0;
        } else {
            return 1;
        }
    }
}

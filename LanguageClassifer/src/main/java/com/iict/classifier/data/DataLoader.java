package com.iict.classifier.data;

import com.iict.classifier.model.Word;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This class is a part of the package com.iict.classifier.data and the package
 * is a part of the project LanguageClassifer.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://integratedict.com.np/
 * https://semantro.com/
 * <p>
 * Created by santa on 2024-06-21.
 * https://github.com/santabasnet
 */
public class DataLoader {

    /* Nepali Data File */
    private static final String nepaliDataFile = "resources/n_final_list.txt";
    /* English Data File */
    private static final String englishDataFile = "resources/e_final_list.txt";

    /* Read list of words line by line */
    private static List<Word> readListOfWords(String fileName) {
        List<Word> finalList = new ArrayList<>();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                finalList.add(new Word(line.trim()));
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return finalList;
    }

    /* Load Nepali Data */
    public static List<Word> loadNepaliWords() {
        return readListOfWords(nepaliDataFile);
    }

    /* Load English Data */
    public static List<Word> loadEnglishWords() {
        return readListOfWords(englishDataFile);
    }

    /* Get n randomized words from a List. */
    public static List<Word> loadNRandomizedWords(int n, List<Word> words) {
        Collections.shuffle(words);
        return words.subList(0, n);
    }

    /* Load English Data of size n */
    public static List<Word> loadEnRandomizedWords(int n) {
        return loadNRandomizedWords(n, loadEnglishWords());
    }

    /* Load Nepali Data of size n */
    public static List<Word> loadNpRandomizedWords(int n) {
        return loadNRandomizedWords(n, loadNepaliWords());
    }

}

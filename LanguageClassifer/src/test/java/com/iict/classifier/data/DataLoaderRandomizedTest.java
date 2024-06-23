package com.iict.classifier.data;

import com.iict.classifier.model.Word;

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
public class DataLoaderRandomizedTest {

  public static void main(String[] args) {

    int n = 5000;

    List<Word> nepaliWords = DataLoader.loadNpRandomizedWords(n);
    System.out.println("\nNepali Words: " + nepaliWords);
    System.out.println("Nepali Words Size: " + nepaliWords);

    List<Word> englishWords = DataLoader.loadEnRandomizedWords(n);
    System.out.println("\n\n\nEnglish Words: " + englishWords);
    System.out.println("English Words Size: " + englishWords.size());

  }

}

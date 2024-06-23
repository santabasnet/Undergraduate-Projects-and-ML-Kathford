package com.iict.classifier.data;

import com.iict.classifier.model.Word;

import java.util.List;

/**
 * This class is a part of the package com.iict.classifier.data and the package
 * is a part of the project LanguageClassifier.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://integratedict.com.np/
 * https://semantro.com/
 * <p>
 * Created by santa on 2024-06-21.
 * https://github.com/santabasnet
 */
public class DataLoaderTest {

    public static void main(String[] args) {

        List<Word> nepaliWords = DataLoader.loadNepaliWords();
        System.out.println("\nNepali Words: " + nepaliWords.size());

        List<Word> englishWords = DataLoader.loadEnglishWords();
        System.out.println("\nEnglish Words: " + englishWords.size());

    }

}

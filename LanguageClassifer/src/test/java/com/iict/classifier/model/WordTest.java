package com.iict.classifier.model;

/**
 * This class is a part of the package com.iict.classifier.model and the package
 * is a part of the project LanguageClassifier.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://integratedict.com.np/
 * https://semantro.com/
 * <p>
 * Created by santa on 2024-06-21.
 * https://github.com/santabasnet
 */
public class WordTest {

    public static void main(String[] args) {
        Word word = new Word("Playerplay");
        System.out.println(word.allGrams());
        System.out.println(word.gramFrequencies());
    }

}

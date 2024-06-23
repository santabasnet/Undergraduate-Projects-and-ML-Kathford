package com.iict.classifier;

import com.iict.classifier.model.Word;
import com.iict.classifier.use.Classifier;

import java.util.Arrays;
import java.util.List;

/**
 * This class is a part of the package com.iict.classifier and the package
 * is a part of the project Default (Template) Project.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://integratedict.com.np/
 * https://semantro.com/
 * <p>
 * Created by santa on 2024-06-21.
 * https://github.com/santabasnet
 */
public class Main {
    public static void main(String[] args) {
        /* Classifier */
        System.out.println("Summary : \n" + Classifier.model.summary());

        /* Some Nepali and English Words, are used for inputs */
        List<String> testWords = Arrays.asList(
                "software", ";ˆ6jo]/", "Nepali", "g]kfnL", "Nationality"
        );

        /* Display the result */
        System.out.println("Classifier Results: ");
        testWords.forEach(text -> {
            Word word = new Word(text);
            System.out.printf("\tWord = %20s >> %s", word, Classifier.classify(word));
            System.out.println();
        });

    }
}
package com.iict.classifier.model;

import java.util.Map;

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
public class LanguageModel {

    private final Double languageProbability;
    private final Map<String, Double> ngramsProbability;

    public LanguageModel(Double languageProbability, Map<String, Double> ngramsProbability) {
        this.languageProbability = languageProbability;
        this.ngramsProbability = ngramsProbability;
    }

    /* Calculate Language Probability for a Word */
    public Double probabilityOf(Word word) {
        double likelihood = word.allGrams().stream()
                .mapToDouble(gram -> ngramsProbability.getOrDefault(gram, 0.0))
                .sum();
        return likelihood + languageProbability;
    }

    /* Summary */
    public String summary() {
        return "Probability of Language = " +
                languageProbability +
                ",\tTotal Gram Entries : " +
                ngramsProbability.size();
    }
}

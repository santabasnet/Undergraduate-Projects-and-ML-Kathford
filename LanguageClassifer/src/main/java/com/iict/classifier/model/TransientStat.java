package com.iict.classifier.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

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
public class TransientStat {
    private final List<Word> words;
    private final Map<String, Long> gramFrequencies;
    private final Long totalGrams;

    public TransientStat(List<Word> words) {
        this.words = words;
        this.gramFrequencies = accumulateGramFrequencies();
        this.totalGrams = languageTotalGrams();
    }

    /* Accumulate all the gram frequencies */
    private Map<String, Long> accumulateGramFrequencies() {

        Map<String, Long> results = new HashMap<>();
        for (Word word : this.words) {

            for (Map.Entry<String, Long> gram: word.gramFrequencies().entrySet()){
                long count = results.getOrDefault(gram.getKey(), 0L);
                results.put(gram.getKey(), gram.getValue() + count);
            }

            /*word.gramFrequencies().forEach(
                    (k, v) -> results.put(k, results.getOrDefault(k, 0L) + v)
            );*/
        }
        return results;
    }

    private long languageTotalGrams() {
        return this.gramFrequencies.values().stream().reduce(0L, (a, b) -> a + b);
    }

    /* Gram With Frequencies */
    public Map<String, Long> getGramFrequencies() {
        return this.gramFrequencies;
    }

    /* Total Grams */
    public long getTotalGrams() {
        return totalGrams;
    }
    /* Total Grams */

    /* This for object factory.*/
    public static TransientStat of(List<Word> words) {
        return new TransientStat(words);
    }
}

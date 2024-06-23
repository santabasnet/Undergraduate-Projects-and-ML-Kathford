package com.iict.classifier.model;

import com.iict.classifier.utils.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static com.iict.classifier.utils.Literals.MAX_SIZE;
import static com.iict.classifier.utils.Literals.MIN_SIZE;

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
public class Word {
    private final String text;

    public Word(String text) {
        this.text = text.toLowerCase();
    }

    public String getText() {
        return text;
    }

    public List<String> allGrams() {
        return StringUtils.wordGramsOf(this.text, MIN_SIZE, MAX_SIZE);
    }

    public Map<String, Long> gramFrequencies() {
        /*Map<String, Long> frequencies = new HashMap<>();
        allGrams().forEach(gram -> {
            long count = frequencies.getOrDefault(gram, 0L);
            frequencies.put(gram, count + 1);
        });
        return frequencies;*/
        return allGrams().stream().collect(Collectors.groupingBy(w -> w, Collectors.counting()));
    }

    @Override
    public String toString() {
        return "{text='" + text + "'}";
    }
}

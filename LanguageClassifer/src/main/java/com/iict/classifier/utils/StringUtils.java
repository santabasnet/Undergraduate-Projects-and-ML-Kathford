package com.iict.classifier.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.IntStream;

/**
 * This class is a part of the package com.iict.classifier.utils and the package
 * is a part of the project LanguageClassifier.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://integratedict.com.np/
 * https://semantro.com/
 * <p>
 * Created by santa on 2024-06-21.
 * https://github.com/santabasnet
 */
public class StringUtils {

    private static List<String> getGramsOf(String text, int size) {
        return IntStream
                .range(0, text.length() - size + 1)
                .mapToObj(i -> text.substring(i, i + size))
                .toList();

    }

    private static List<List<String>> collectGrams(String text, int minSize, int maxSize) {
        return IntStream
                .range(minSize, maxSize + 1)
                .mapToObj(size -> getGramsOf(text, size))
                .toList();
    }

    public static List<String> wordGramsOf(String text, int minSize, int maxSize) {
        if (text.isEmpty()) return new ArrayList<>();
        else if (text.length() < minSize) return List.of(text);
        else return collectGrams(text, minSize, maxSize).stream()
                    .flatMap(Collection::stream)
                    .toList();
    }

}

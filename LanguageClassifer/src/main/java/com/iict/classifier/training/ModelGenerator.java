package com.iict.classifier.training;

import com.iict.classifier.model.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is a part of the package com.iict.classifier.training and the package
 * is a part of the project LanguageClassifier.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://integratedict.com.np/
 * https://semantro.com/
 * <p>
 * Created by santa on 2024-06-21.
 * https://github.com/santabasnet
 */
public class ModelGenerator {

    private final List<Word> nepaliWords;
    private final List<Word> englishWords;

    public ModelGenerator(List<Word> nepaliWords, List<Word> englishWords) {
        this.nepaliWords = nepaliWords;
        this.englishWords = englishWords;
    }

    public static LanguageModel buildLanguageModel(TransientStat stat, Long totalGrams) {

        /* We bias the language probability based on the available number of grams. */
        double langProbability = Math.log((double) stat.getTotalGrams() / (double) totalGrams);
        Map<String, Double> gramProbabilities = stat.getGramFrequencies().entrySet().stream().collect(
                Collectors.toMap(Map.Entry::getKey, e -> Math.log((double) e.getValue() / (double) stat.getTotalGrams()))
        );
        return new LanguageModel(langProbability, gramProbabilities);

    }

    /* Perform Training Here */
    public ClassifierModel train() {

        System.out.println("\nTraining Started ...");

        TransientStat nepaliStat = TransientStat.of(nepaliWords);
        TransientStat englishStat = TransientStat.of(englishWords);
        //System.out.println("Nepali : " + nepaliStat.getGramFrequencies());
        //System.out.println("English : " + englishStat.getGramFrequencies());

        Long totalGrams = nepaliStat.getTotalGrams() + englishStat.getTotalGrams();

        LanguageModel npModel = buildLanguageModel(nepaliStat, totalGrams);
        LanguageModel enModel = buildLanguageModel(englishStat, totalGrams);

        Map<Language, LanguageModel> allLanguageModels = new HashMap<>();
        allLanguageModels.put(Language.NEAPALI_LANGUAGE, npModel);
        allLanguageModels.put(Language.ENGLISH_LANGUAGE, enModel);

        System.out.println("\nTraining Completed !");

        return new ClassifierModel(allLanguageModels);
    }
}

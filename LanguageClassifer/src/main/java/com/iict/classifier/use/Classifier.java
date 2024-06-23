package com.iict.classifier.use;

import com.iict.classifier.data.DataLoader;
import com.iict.classifier.model.ClassifierModel;
import com.iict.classifier.model.Language;
import com.iict.classifier.model.Word;
import com.iict.classifier.training.ModelGenerator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * This class is a part of the package com.iict.classifier.use and the package
 * is a part of the project LanguageClassifier.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://integratedict.com.np/
 * https://semantro.com/
 * <p>
 * Created by santa on 2024-06-21.
 * https://github.com/santabasnet
 */
public class Classifier {

    /* Words size */
    private static int defaultWordSize = 5000;

    private static List<Word> npWords = Arrays.asList(new Word(".xg["), new Word(".xg'"));
    private static List<Word> enWords = Arrays.asList(new Word("play"), new Word("player"));

    /* Initialize Model using training process */
    /*public static final ClassifierModel model = new ModelGenerator(
            npWords, enWords
    ).train();*/

    public static final ClassifierModel model = new ModelGenerator(
            DataLoader.loadNepaliWords(),
            DataLoader.loadEnglishWords()
    ).train();

    public static Language classify(Word word) {
        Map<Language, Double> probabilities = model.getAllModels().entrySet().stream().collect(
                Collectors.toMap(Map.Entry::getKey, entry -> entry.getValue().probabilityOf(word))
        );
        return Collections.min(probabilities.entrySet(), Map.Entry.comparingByValue()).getKey();
    }

}

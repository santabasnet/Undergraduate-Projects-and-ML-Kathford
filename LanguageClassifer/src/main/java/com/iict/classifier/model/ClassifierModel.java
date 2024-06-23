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
public class ClassifierModel {

    private final Map<Language, LanguageModel> allModels;


    public ClassifierModel(Map<Language, LanguageModel> allModels) {
        this.allModels = allModels;
    }

    public Map<Language, LanguageModel> getAllModels() {
        return this.allModels;
    }

    /* Get Summary Of language models */
    public String summary() {
        return "Total Models : " +
                allModels.size() +
                "\n" +
                "Nepali Grams Size: " +
                allModels.get(Language.NEAPALI_LANGUAGE).summary() +
                "\n" +
                "English Grams Size: " +
                allModels.get(Language.ENGLISH_LANGUAGE).summary() +
                "\n";
    }

}

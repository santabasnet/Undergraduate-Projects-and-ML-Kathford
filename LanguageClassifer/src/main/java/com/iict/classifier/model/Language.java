package com.iict.classifier.model;

import static com.iict.classifier.utils.Literals.*;

/**
 * This class is a part of the package com.iict.classifier.model and the package
 * is a part of the project LanguageClassifer.
 * <p>
 * Semantro/Integrated ICT Pvt. Ltd. Lalitpur, Nepal.
 * https://integratedict.com.np/
 * https://semantro.com/
 * <p>
 * Created by santa on 2024-06-21.
 * https://github.com/santabasnet
 */
public class Language {

    private final String code;
    private final String name;

    public static final Language DEFAULT = new Language(NP, NEPALI);

    public static final Language ENGLISH_LANGUAGE = new Language(EN, ENGLISH);
    public static final Language NEAPALI_LANGUAGE = DEFAULT;

    public Language(String code, String name) {
        this.code = code;
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Language{" +
                "code='" + code + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

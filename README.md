# Undergraduate-Projects-and-Supervised ML-Kathford
This repo contains lecture matrials and hands on demonstration of Supervised Machine Learning with Naive Bayes classifier. The
implementation is done through Java Language.

##Sample usage:
```java
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
```

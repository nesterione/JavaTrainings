package javaselast.lessons.lesson09;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Calculate words frequency in text.
 */
public final class WordFrequency {

    /**
     * Min length word used for analysis.
     */
    private static final int MIN_WORD_LENGTH = 4;

    /**
     * This is utility file.
     */
    private WordFrequency() { }

    /**
     *
     * @param args file path.
     * @throws IOException throws io exception
     */
    public static void main(final String[] args) throws IOException {

        if (args.length < 1) {
            System.out.println("pass file path");
            System.exit(-1);
        }

        final String path = args[0];
        File file = new File(path);

        if (!file.exists() || file.isDirectory()) {
            System.out.println("file " + path + " not found");
            System.exit(-1);
        }

        int wordsCount = 0;
        Map<String, Integer> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split("[\\s.;:?!)(]+");
                for (String word: words) {

                    if (word.length() < MIN_WORD_LENGTH) {
                        continue;
                    }

                    String lowerWord = word.toLowerCase();
                    wordsCount++;
                    if (map.containsKey(lowerWord)) {
                        Integer count = map.get(lowerWord);
                        map.put(lowerWord, ++count);
                    } else  {
                        map.put(lowerWord, 1);
                    }
                }
            }
        }

        // print result
        for (String word : map.keySet()) {
            double frequency = ((double) map.get(word)) / wordsCount;
            System.out.format("%s: %f\n", word, frequency);
        }
    }
}
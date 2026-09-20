package string.assigment_problems;

import java.util.*;

public class StopWordFrequencyReport {

    public static void generateReport(String text) {

        String[] stopWords = {
            "the", "was", "and", "a", "is", "of", "in"
        };

        text = text.toLowerCase();

        text = text.replace(",", "")
                   .replace(".", "")
                   .replace("!", "")
                   .replace("?", "");

        String[] words = text.split("\\s+");

        HashMap<String, Integer> frequency = new HashMap<>();

        for (String word : words) {

            boolean isStopWord = false;

            for (String stopWord : stopWords) {
                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            if (!isStopWord && !word.isEmpty()) {
                frequency.put(word, frequency.getOrDefault(word, 0) + 1);
            }
        }

        List<Map.Entry<String, Integer>> list =
                new ArrayList<>(frequency.entrySet());

        list.sort((a, b) -> b.getValue() - a.getValue());

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }

    public static void main(String[] args) {

        String text = "Java is a programming language. Java is easy and Java is powerful.";

        generateReport(text);
    }
}
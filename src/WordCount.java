import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) {
    }


    public static void wordCount(String fileName) {
        // Read from file
        String contents = "2.txt";
        try {
            contents = new String(Files.readAllBytes(Paths.get(fileName)));
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Break up into words
        String[] words = contents.split("\\s+");
        System.out.println("File has " + words.length + " words.");


        // Filling the map
        HashMap<String, Integer> wordCounter = new HashMap<>();
        for (String word : words) {
            word = word.toLowerCase().replaceAll(".[,:;.?!]$", "");
            wordCounter.put(word, wordCounter.containsKey(word) ? wordCounter.get(word) + 1 : 1);
        }

        // Outputting sorted
        wordCounter.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }


    public static boolean hasPair(int[] arr, int n) {
        for (int i = 0; i < arr.length; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] + arr[j] == n)
                    return true;

        return false;
    }

    public static boolean betterHasPair(int[] arr, int n) {
        HashSet<Integer> complimentaries = new HashSet<>();
        for (int i : arr) {
            if (complimentaries.contains(i))
                return true;
            complimentaries.add(n - i);
        }
        return false;
    }
}
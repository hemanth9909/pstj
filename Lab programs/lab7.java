import java.util.*;
import java.util.regex.*;

public class HashtagFrequencyCounter {
    public static void main(String[] args) {
        String text = "Java is great! #Java #Coding "
                    + "#Python #Java #Coding";

        Map<String, Integer> frequency = new LinkedHashMap<>();

        Pattern pattern = Pattern.compile("#\\w+");
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String hashtag = matcher.group().toLowerCase();
            frequency.put(hashtag,
                frequency.getOrDefault(hashtag, 0) + 1);
        }

        System.out.println("Hashtag Frequencies:");
        for (String tag : frequency.keySet()) {
            System.out.println(tag + " : " + frequency.get(tag));
        }
    }
}
Hashtag Frequencies:
#java : 3
#coding : 2
#python : 1

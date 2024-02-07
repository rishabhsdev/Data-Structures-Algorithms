package DataStructures;

import java.util.HashMap;
import java.util.Map;

public class HashMapsExample {

    Map<Character, Integer> map = new HashMap<>();

    public Character findFirstNonRepeating(String input) {

        for (char ch : input.toCharArray()) {

            if (ch == ' ') {
                continue;
            } else if (!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                map.put(ch, map.get(ch) + 1);
            }

        }

        for (char ch : input.toCharArray()) {

            if (ch == ' ' || map.get(ch) > 1) {
                continue;
            } else {
                return ch;
            }
        }

        return '0';
    }

    @Override
    public String toString() {
        return "HashMaps [map=" + map + "]";
    }

}

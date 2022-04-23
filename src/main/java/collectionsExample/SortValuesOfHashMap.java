package collectionsExample;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static java.util.Map.Entry.comparingByValue;

public class SortValuesOfHashMap {

    /*
     *
     * String s= "void hello is a void kite hello from a void"
     *
     * void = 3
     * hello = 2
     * a = 2
     * is = 1
     * kite = 1
     * from = 1
     *
     *sort on the basis of decreasing frequency values
     *
     * */
    public static void main(String[] args) {
        String s = "void hello is a void kite hello from a void";

        var freqMap = new HashMap<String, Integer>();
        String[] strArr = s.split(" ");
        if (Objects.nonNull(strArr)) {
            for (String s1 : strArr) {
                freqMap.put(s1, freqMap.getOrDefault(s1, 0) + 1);
            }

            //sorting the values
            freqMap.entrySet().stream()
                    .sorted(Map.Entry.<String,Integer>comparingByValue().reversed())
                    .forEach(record-> {

                    });
        }
    }
}

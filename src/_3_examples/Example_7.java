package _3_examples;

import java.util.Comparator;
import java.util.EnumSet;

/**
 * Created by dmytro_adonin on 1/22/2016.
 */
public class Example_7 {

    public static void main(String[] args) {
        String s1 = "aaa";
        String s2 = "bbb";
        System.out.println(createComparator(EnumSet.of(ComparationRule.SIMPLE)).compare(s1, s2));
    }

    private static Comparator<String> createComparator(EnumSet<ComparationRule> rules) {
        return (s1, s2) -> {
            if (rules.contains(ComparationRule.CASE_INSENSITIVE)) {
                s1 = s1.toLowerCase();
                s2 = s2.toLowerCase();
            }
            if (rules.contains(ComparationRule.SPACE_INSENSITIVE)) {
                s1 = s1.replaceAll("\\s+", "");
                s2 = s2.replaceAll("\\s+", "");
            }
            return rules.contains(ComparationRule.REVERSE) ? s1.compareTo(s2) : s2.compareTo(s1);
        };
    }

    enum ComparationRule {
        SIMPLE,
        REVERSE,
        CASE_INSENSITIVE,
        SPACE_INSENSITIVE
    }

}



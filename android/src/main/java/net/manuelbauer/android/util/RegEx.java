package net.manuelbauer.android.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Collection of basic RegEx operations
 *
 * @author Manuel Bauer
 */
public class RegEx {


    public static Iterable<MatchResult> findMatches(String pattern, CharSequence s) {
        List<MatchResult> results = new ArrayList<>();

        Matcher matcher = Pattern.compile(pattern, Pattern.DOTALL).matcher(s);

        while(matcher.find()) {
            results.add(matcher.toMatchResult());
        }


        return results;
    }

    /**
     * Find the first occurrence of a pattern inside a sequence
     *
     * @param pattern
     * @param sequence
     * @return Result as {@code MatchResult} or null
     */
    public static MatchResult findFirstMatch(String pattern, CharSequence sequence) {
        Iterable<MatchResult> results = findMatches(pattern, sequence);

        if(results.iterator().hasNext()) {
            return results.iterator().next();
        } else {
            return null;
        }
    }
}

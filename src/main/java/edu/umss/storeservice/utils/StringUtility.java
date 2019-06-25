package edu.umss.storeservice.utils;

import java.util.*;

public class StringUtility {

    public static final String BLANK_SPACE_SEPARATOR = " ";
    // TODO add unit test to the this methods

    private static final String NO_ALPHANUMERIC_PATTERN = "[^\\d-A-Za-z ]";

    private StringUtility() {
        throw new IllegalStateException("Utility class");
    }

    public static List<String> tokenizerToList(StringTokenizer tokenizer) {
        List<String> list = new ArrayList<>();
        while (tokenizer.hasMoreTokens()) {
            list.add(tokenizer.nextToken());
        }
        return list;
    }

    public static String listAsString(List<String> list) {
        StringBuilder builder = new StringBuilder();
        for (String text : list) {
            builder.append(text);
        }
        return builder.toString();
    }

    public static String sublistAsString(List<String> list, int start, int end) {
        if (list.size() < end) {
            return listAsString(list.subList(start, list.size()));
        }
        return listAsString(list.subList(start, end));
    }

    public static String sanitizeString(String text) {
        return text != null ? text : "";
    }

    public static String removeQuotes(String json) {
        String text = sanitizeString(json);
        if (text.startsWith("\"")) {
            return text.substring(1, text.length() - 1);
        }
        return text;
    }

    public static String constantCaseToNormalText(String text) {
        return text.toLowerCase().replace('_', ' ');
    }

    public static String removeTrailingComma(String text) {
        if (text != null && (text.lastIndexOf(',') == text.length())) {
            return text.substring(0, text.length() - 1);
        }
        return text;
    }

    public static boolean textMatchesWord(String text, String word) {
        return sanitizeString(text).replaceAll(NO_ALPHANUMERIC_PATTERN, "").trim()
                .equalsIgnoreCase(sanitizeString(word).trim());
    }

    public static boolean textMatchesPhrase(String text, String phrase) {
        List<String> list = tokenizerToList(new StringTokenizer(text, BLANK_SPACE_SEPARATOR, true));
        int phraseSize = new StringTokenizer(phrase, BLANK_SPACE_SEPARATOR, true).countTokens();
        for (int i = 0; i < list.size(); i++) {
            if (textMatchesWord(sublistAsString(list, i, i + phraseSize), phrase)) {
                return true;
            }
        }
        return false;
    }

    public static boolean caselessContains(String text, String value) {
        return text.toLowerCase().contains(value.toLowerCase());
    }

    /**
     * It receives a list with different texts, uses a token to separate key and
     * value and returns a map with all the related values inside the same key
     */
    public static Map<String, String> convertItemsToMapByToken(List<String> items, String token, String textSeparator) {
        HashMap<String, String> filteredValues = new HashMap<>();
        for (String item : items) {
            String[] separetedItem = item.split(token, 2);
            if (filteredValues.containsKey(separetedItem[0].toUpperCase().trim())) {
                String originalValue = filteredValues.get(separetedItem[0].toUpperCase().trim());
                String newValue = new StringBuilder().append(originalValue).append(textSeparator)
                        .append(separetedItem[1].trim()).toString();
                filteredValues.replace(separetedItem[0].toUpperCase().trim(), newValue);
            } else if (separetedItem.length == 2) {
                filteredValues.put(separetedItem[0].toUpperCase().trim(), separetedItem[1].trim());
            }
        }
        return filteredValues;
    }
}

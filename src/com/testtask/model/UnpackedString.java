package com.testtask.model;

import java.util.regex.MatchResult;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UnpackedString {

    private Integer length;

    private String content;

    public UnpackedString(String capchaString) {
        if (capchaString != null) {
            this.content = capchaToContent(capchaString);
            this.length = content.length();
        }
    }

    private String capchaToContent(String capchaString) {
        StringBuilder sb = new StringBuilder();
        String[] unrecognizedParts = getArrayOfSpecificParts(capchaString, "\\D+");
        String[] recognizedParts = getArrayOfSpecificParts(capchaString, "\\d+");
        for (int unpPos = 0, repPos = 0; unpPos < unrecognizedParts.length || repPos < recognizedParts.length; unpPos++, repPos++) {
            if (unpPos < unrecognizedParts.length && !unrecognizedParts[unpPos].isEmpty()) {
                sb.append("?".repeat(Integer.parseInt(unrecognizedParts[unpPos])));
            }
            if (repPos < recognizedParts.length && !recognizedParts[repPos].isEmpty()) {
                sb.append(recognizedParts[repPos]);
            }
        }
        return sb.toString();
    }

    private String[] getArrayOfSpecificParts(String capchaString, String condition) {
        return capchaString.split(condition);
    }

    private int[] getArrayOfLengthsOfUnrecognizedParts(String capchaString) {
        Pattern p = Pattern.compile("\\d+");
        Matcher m = p.matcher(capchaString);
        int[] ints = m.results().map(MatchResult::group).mapToInt(Integer::parseInt).toArray();
        return ints;
    }

    public Integer getLength() {
        return length;
    }

    public String getContent() {
        return content;
    }

    public boolean possiblySame(UnpackedString other) {
        if (this == other) return true;

        if (length == null || other.length == null || !length.equals(other.length)) return false;
        return content != null ? isContentPossiblySame(other.content) : false;
    }

    private boolean isContentPossiblySame(String thatContent) {
        for (int pos = 0; pos < this.length; pos++) {
            char c = content.charAt(pos);
            char t = thatContent.charAt(pos);
            if (c != '?' && t != '?' && c != t) {
                return false;
            }
        }
        return true;
    }
}

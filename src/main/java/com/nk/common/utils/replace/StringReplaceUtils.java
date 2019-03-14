package com.nk.common.utils.replace;

import java.util.Map;

public class StringReplaceUtils {

    public static String replaceMatch(String text, Map<String, Object> params) {
        StringBuilder stringBuilder = new StringBuilder();

        int startIndex = 0;
        int end = text.indexOf("@");
        String preStr = text.substring(0, end);
        stringBuilder.append(preStr);
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == '@') {
                if (startIndex > 0) {
                    stringBuilder.append(text, startIndex, i);
                }
                startIndex = i + 1;
                continue;
            }
            if (text.charAt(i) == '#') {
                stringBuilder.append(params.get(text.substring(startIndex, i)));
                startIndex = i + 1;
            }
        }
        if (startIndex < text.length()) {
            stringBuilder.append(text.substring(startIndex));
        }

        return stringBuilder.toString();
    }
}

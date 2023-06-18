package org.example.es.plugins.splitjamo;

import org.example.es.plugins.common.TokenConvertIterator;

public class SplitJamoIterator implements TokenConvertIterator {

    private static final String[] splitHangulCompatibilityJamo = {
            "ㄱ", "ㄲ", "ㄱㅅ", "ㄴ", "ㄴㅈ", "ㄴㅎ", "ㄷ", "ㄸ", "ㄹ", "ㄹㄱ", "ㄹㅁ", "ㄹㅂ", "ㄹㅅ", "ㄹㅌ", "ㄹㅍ",
            "ㄹㅎ", "ㅁ", "ㅂ", "ㅃ", "ㅂㅅ", "ㅅ", "ㅆ", "ㅇ", "ㅈ", "ㅉ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ", "ㅏ",
            "ㅐ", "ㅑ", "ㅒ", "ㅓ", "ㅔ", "ㅕ", "ㅖ", "ㅗ", "ㅗㅏ", "ㅗㅐ", "ㅗㅣ", "ㅛ", "ㅜ", "ㅜㅓ", "ㅜㅔ", "ㅜㅣ",
            "ㅠ", "ㅡ", "ㅡㅣ", "ㅣ"
    };

    private static final char HANGUL_COMPATIBILITY_JAMO_START = 'ㄱ';
    private static final char MODERN_HANGUL_COMPATIBILITY_JAMO_END = 'ㅣ';

    @Override
    public void iterate(StringBuilder result, char ch) {
        if (isNotHangulCompatibilityJamo(ch)) {
            result.append(ch);
            return;
        }

        final int index = ch - HANGUL_COMPATIBILITY_JAMO_START;
        result.append(splitHangulCompatibilityJamo[index]);
    }

    private boolean isNotHangulCompatibilityJamo(char ch) {
        return !(HANGUL_COMPATIBILITY_JAMO_START <= ch && ch <= MODERN_HANGUL_COMPATIBILITY_JAMO_END);
    }
}

package org.example.es.plugins.chosung;

import org.example.es.plugins.common.TokenInplace;

public class ChosungInplace implements TokenInplace {

    private static final char HANGUL_SYLLABLES_START = '가';
    private static final int INITIAL_CONSONANT_BASE = 28 * 21;
    private static final char HANGUL_SYLLABLES_END = '힣';
    private static final char[] initialConsonants = {
            'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    };

    @Override
    public char inplace(char ch) {
        if (HANGUL_SYLLABLES_START <= ch && ch <= HANGUL_SYLLABLES_END) {
            return inplaceHangulToChosung(ch);
        }

        return ch;
    }

    private char inplaceHangulToChosung(final char ch) {
        int charIndex = ch - HANGUL_SYLLABLES_START;
        int initialConsonantIndex = charIndex / INITIAL_CONSONANT_BASE;

        if (initialConsonantIndex < initialConsonants.length) {
            return initialConsonants[initialConsonantIndex];
        }

        return ch;
    }
}

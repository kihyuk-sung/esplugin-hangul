package org.example.es.plugins.common;

public class KoreanUtils {
    private static final char HANGUL_SYLLABLES_START = '가';
    private static final char HANGUL_SYLLABLES_END = '힣';

    private static final int INITIAL_CONSONANT_SIZE = 19;
    private static final int VOWELS_SIZE = 21;
    private static final int TRAILING_CONSONANT_SIZE = 28;

    private static final int INITIAL_CONSONANT_BASE = TRAILING_CONSONANT_SIZE * VOWELS_SIZE;
    private static final int VOWEL_BASE = TRAILING_CONSONANT_SIZE;

    private static final char[] initialConsonants = {
            'ㄱ', 'ㄲ', 'ㄴ', 'ㄷ', 'ㄸ', 'ㄹ', 'ㅁ', 'ㅂ', 'ㅃ', 'ㅅ', 'ㅆ', 'ㅇ', 'ㅈ', 'ㅉ', 'ㅊ', 'ㅋ', 'ㅌ', 'ㅍ', 'ㅎ'
    };

    private static final char[] vowels = {
            'ㅏ', 'ㅐ', 'ㅑ', 'ㅒ', 'ㅓ', 'ㅔ', 'ㅕ', 'ㅖ', 'ㅗ', 'ㅘ', 'ㅙ', 'ㅚ', 'ㅛ', 'ㅜ', 'ㅝ', 'ㅞ', 'ㅟ', 'ㅠ', 'ㅡ', 'ㅢ', 'ㅣ'
    };

    private static final String[] trailingConsonants = {
            "", "ㄱ", "ㄲ", "ㄳ", "ㄴ", "ㄵ", "ㄶ", "ㄷ", "ㄹ", "ㄺ",
            "ㄻ", "ㄼ", "ㄽ", "ㄾ", "ㄿ", "ㅀ", "ㅁ", "ㅂ", "ㅄ", "ㅅ",
            "ㅆ", "ㅇ", "ㅈ", "ㅊ", "ㅋ", "ㅌ", "ㅍ", "ㅎ"
    };

    public static boolean isHangulSyllables(char ch) {
        return HANGUL_SYLLABLES_START <= ch && ch <= HANGUL_SYLLABLES_END;
    }

    public static char getHangulInitialConsonant(char ch) {
        final int index = (ch - HANGUL_SYLLABLES_START) / INITIAL_CONSONANT_BASE;
        return initialConsonants[index];
    }

    public static char getHangulVowel(char ch) {
        final int index = ((ch - HANGUL_SYLLABLES_START) / VOWEL_BASE) % VOWELS_SIZE;
        return vowels[index];
    }

    public static String getHangulTrailingConsonant(char ch) {
        final int index = (ch - HANGUL_SYLLABLES_START) % TRAILING_CONSONANT_SIZE;
        return trailingConsonants[index];
    }

}

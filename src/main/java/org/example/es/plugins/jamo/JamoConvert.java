package org.example.es.plugins.jamo;

import org.example.es.plugins.common.KoreanUtils;
import org.example.es.plugins.common.TokenConvert;

public class JamoConvert implements TokenConvert {
    @Override
    public CharSequence convert(CharSequence token) {
        final StringBuilder result = new StringBuilder();

        for (int i = 0; i < token.length(); i++) {
            final char ch = token.charAt(i);
            iterate(result, ch);
        }

        return result.toString();
    }

    private void iterate(StringBuilder result, char ch) {
        if (!KoreanUtils.isHangulSyllables(ch)) {
            result.append(ch);
            return;
        }

        result.append(KoreanUtils.getHangulInitialConsonant(ch));
        result.append(KoreanUtils.getHangulVowel(ch));
        result.append(KoreanUtils.getHangulTrailingConsonant(ch));
    }
}

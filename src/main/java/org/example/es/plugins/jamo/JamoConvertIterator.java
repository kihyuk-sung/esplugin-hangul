package org.example.es.plugins.jamo;

import org.example.es.plugins.common.KoreanUtils;
import org.example.es.plugins.common.TokenConvertIterator;

public class JamoConvertIterator implements TokenConvertIterator {

    @Override
    public void iterate(StringBuilder result, char ch) {
        if (!KoreanUtils.isHangulSyllables(ch)) {
            result.append(ch);
            return;
        }

        result.append(KoreanUtils.getHangulInitialConsonant(ch));
        result.append(KoreanUtils.getHangulVowel(ch));
        result.append(KoreanUtils.getHangulTrailingConsonant(ch));
    }
}

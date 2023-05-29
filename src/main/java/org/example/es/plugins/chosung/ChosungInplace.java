package org.example.es.plugins.chosung;

import org.example.es.plugins.common.KoreanUtils;
import org.example.es.plugins.common.TokenInplace;

public class ChosungInplace implements TokenInplace {

    @Override
    public char inplace(char ch) {
        if (KoreanUtils.isHangulSyllables(ch)) {
            return KoreanUtils.getHangulInitialConsonant(ch);
        }

        return ch;
    }
}

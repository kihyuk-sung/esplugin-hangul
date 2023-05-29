package org.example.es.plugins.common;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class TokenInplaceFilter extends TokenFilter {

    private final TokenInplace tokenInplace;
    private final CharTermAttribute termAttr = addAttribute(CharTermAttribute.class);

    public TokenInplaceFilter(TokenStream input, TokenInplace tokenInplace) {
        super(input);
        this.tokenInplace = tokenInplace;
    }

    @Override
    public final boolean incrementToken() throws IOException {
        if (!input.incrementToken()) {
            return false;
        }

        char[] buffer = termAttr.buffer();
        for (int i = 0; i < buffer.length; i++) {
            final char ch = buffer[i];
            buffer[i] = tokenInplace.inplace(ch);
        }
        return true;
    }
}

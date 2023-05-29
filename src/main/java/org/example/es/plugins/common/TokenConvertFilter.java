package org.example.es.plugins.common;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;

import java.io.IOException;

public class TokenConvertFilter extends TokenFilter {

    private final TokenConvert tokenConvert;
    private final CharTermAttribute termAttr = addAttribute(CharTermAttribute.class);

    public TokenConvertFilter(TokenStream input, TokenConvert tokenConvert) {
        super(input);
        this.tokenConvert = tokenConvert;
    }

    @Override
    public final boolean incrementToken() throws IOException {
        if (!input.incrementToken()) {
            return false;
        }

        final CharSequence converted = tokenConvert.convert(termAttr);
        termAttr.setEmpty();
        termAttr.append(converted);
        return true;
    }
}

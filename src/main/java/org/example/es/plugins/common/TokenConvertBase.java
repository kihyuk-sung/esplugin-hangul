package org.example.es.plugins.common;


public class TokenConvertBase implements TokenConvert {

    private final TokenConvertIterator iterator;

    public TokenConvertBase(TokenConvertIterator iterator) {
        this.iterator = iterator;
    }

    @Override
    public CharSequence convert(CharSequence token) {
        final StringBuilder result = new StringBuilder();

        for (int i = 0; i < token.length(); i++) {
            final char ch = token.charAt(i);
            iterator.iterate(result, ch);
        }

        return result.toString();
    }


}

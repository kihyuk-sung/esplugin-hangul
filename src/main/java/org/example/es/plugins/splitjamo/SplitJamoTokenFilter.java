package org.example.es.plugins.splitjamo;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;
import org.example.es.plugins.common.TokenConvert;
import org.example.es.plugins.common.TokenConvertBase;
import org.example.es.plugins.common.TokenConvertFilter;

public class SplitJamoTokenFilter extends AbstractTokenFilterFactory {

    private static final TokenConvert convert = new TokenConvertBase(new SplitJamoIterator());

    public SplitJamoTokenFilter(IndexSettings indexSettings, Environment env, String name, Settings settings) {
        super(indexSettings, name, settings);
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new TokenConvertFilter(tokenStream, convert);
    }
}

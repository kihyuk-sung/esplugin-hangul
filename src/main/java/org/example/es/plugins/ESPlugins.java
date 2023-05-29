package org.example.es.plugins;

import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;
import org.example.es.plugins.chosung.ChosungTokenFilterFactory;

import java.util.Collections;
import java.util.Map;

public class ESPlugins extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        return Collections.singletonMap("chosung", ChosungTokenFilterFactory::new);
    }
}

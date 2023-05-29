package org.example.es.plugins;

import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.indices.analysis.AnalysisModule;
import org.elasticsearch.plugins.AnalysisPlugin;
import org.elasticsearch.plugins.Plugin;
import org.example.es.plugins.chosung.ChosungTokenFilterFactory;
import org.example.es.plugins.jamo.JamoTokenFilterFactory;

import java.util.HashMap;
import java.util.Map;

public class ESPlugins extends Plugin implements AnalysisPlugin {

    @Override
    public Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
        Map<String, AnalysisModule.AnalysisProvider<TokenFilterFactory>> extra = new HashMap<>();

        extra.put("chosung", ChosungTokenFilterFactory::new);
        extra.put("jamo", JamoTokenFilterFactory::new);

        return extra;
    }
}

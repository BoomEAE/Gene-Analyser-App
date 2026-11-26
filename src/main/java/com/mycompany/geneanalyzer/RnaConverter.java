package com.mycompany.geneanalyzer;

import java.util.List;

public class RnaConverter implements SequenceConverter {

    public boolean canHandle(String in) {
        String s = in.strip().toUpperCase();
        return s.contains("U") && s.matches("[ACGUN\\s]+");
    }
    public List<DNASequence> parse(String in) {
        return List.of(new DNASequence("rna", in.toUpperCase().replace('U', 'T')));
    }
}

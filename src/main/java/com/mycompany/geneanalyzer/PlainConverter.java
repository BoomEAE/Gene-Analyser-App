package com.mycompany.geneanalyzer;

import java.util.List;

public class PlainConverter implements SequenceConverter {

    @Override
    public boolean canHandle(String input) {
        return input.strip().matches("[ACGTNacgtn\\\\s]+");
    }

    @Override
    public List<DNASequence> parse(String input) {
        return List.of(new DNASequence("unnamed", input));
    }
}

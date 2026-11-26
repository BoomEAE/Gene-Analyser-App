package com.mycompany.geneanalyzer;

import java.util.List;

public interface SequenceConverter {
    boolean canHandle(String input);
    List<DNASequence> parse(String input);
}

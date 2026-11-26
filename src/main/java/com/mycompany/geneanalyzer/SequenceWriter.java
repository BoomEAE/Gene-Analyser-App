package com.mycompany.geneanalyzer;

import java.util.Collection;
import java.util.stream.Collectors;

public interface SequenceWriter {
    /** Text for one record, always ending in a newline. */
    String write(DNASequence seq);

    String extension();

    default String writeAll(Collection<DNASequence> seqs) {
        return seqs.stream().map(this::write).collect(Collectors.joining());
    }
}

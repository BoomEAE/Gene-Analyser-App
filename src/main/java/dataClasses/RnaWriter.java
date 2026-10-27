package org.derick;

public class RnaWriter implements SequenceWriter {

    public String write(DNASequence seq) {
        return seq.getRawSequence().replace('T', 'U') + "\n";
    }

    public String extension() {
        return "rna";
    }
}

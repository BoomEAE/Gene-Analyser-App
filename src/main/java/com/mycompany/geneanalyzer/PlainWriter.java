package com.mycompany.geneanalyzer;

public class PlainWriter implements SequenceWriter {

    public String write(DNASequence seq) { return seq.getRawSequence() + "\n"; }

    public String extension() {
        return "txt";
    }
}

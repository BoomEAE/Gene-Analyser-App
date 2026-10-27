package org.derick;

public class FastqWriter implements SequenceWriter {
    // ('I' = Phred 40 in Sanger encoding).
    private static final char DEFAULT_QUALITY = 'I';

    public String write(DNASequence seq) {
        return "@" + seq.getId() + "\n"
                + seq.getRawSequence() + "\n"
                + "+\n"
                + String.valueOf(DEFAULT_QUALITY).repeat(seq.length()) + "\n";
    }

    public String extension() {
        return "fastq";
    }
}

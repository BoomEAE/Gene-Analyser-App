/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derick.dnadataclasses;

/**
 * Based on BIOJAVA Class
 *
 * @author 6300410
 * Model Class to write FASQ sequence into external CSV file
 */
public class FastqWriter implements SequenceWriter {
    // ('I' = Phred 40 in Sanger encoding).
    private static final char DEFAULT_QUALITY = 'I';

    @Override
    public String write(DNASequence seq) {
        return "@" + seq.getId() + "\n"
                + seq.getRawSequence() + "\n"
                + "+\n"
                + String.valueOf(DEFAULT_QUALITY).repeat(seq.length()) + "\n";
    }

    @Override
    public String extension() {
        return "fastq";
    }
}

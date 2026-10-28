/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derick.dnasequencedataclasses;

/**
 *
 * @author 6300410
 */
public class FastaWriter implements SequenceWriter {
    private static final int LINE_WIDTH = 70;

    public String write(DNASequence seq) {
        String raw = seq.getRawSequence();
        StringBuilder sb = new StringBuilder(">").append(seq.getId()).append('\n');

        for (int i = 0; i < raw.length(); i += LINE_WIDTH)
            sb.append(raw, i, Math.min(i + LINE_WIDTH, raw.length())).append('\n');

        return sb.toString();
    }

    public String extension() {
        return "fasta";
    }
}

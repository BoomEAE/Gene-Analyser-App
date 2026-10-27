package org.derick;

public class GenBankWriter implements SequenceWriter {
    private static final int LINE_BASES = 60;
    private static final int BLOCK = 10;

    public String write(DNASequence seq) {
        String raw = seq.getRawSequence().toLowerCase();
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("LOCUS       %-16s %d bp    DNA     linear   UNK%n",
                seq.getId(), seq.length()));

        sb.append("ORIGIN\n");

        for (int line = 0; line < raw.length(); line += LINE_BASES) {
            sb.append(String.format("%9d", line + 1));
            int end = Math.min(line + LINE_BASES, raw.length());
            for (int b = line; b < end; b += BLOCK)
                sb.append(' ').append(raw, b, Math.min(b + BLOCK, end));
            sb.append('\n');
        }

        sb.append("//\n");

        return sb.toString();
    }

    public String extension() {
        return "gb";
    }
}

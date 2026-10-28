package com.mycompany.geneanalyzer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class SequenceCollection implements Iterable<DNASequence> {
    private final Map<String, DNASequence> sequences = new LinkedHashMap<>();
    private final SequenceReader reader = new SequenceReader();

    public void add(DNASequence seq) {
        if (sequences.containsKey(seq.getId()))
            throw new IllegalArgumentException("Duplicate sequence id: " + seq.getId());
        sequences.put(seq.getId(), seq);
    }

    public void addAll(Collection<DNASequence> seqs) {
        seqs.forEach(this::add);
    }

    /** Parse any supported input (plain, FASTA, FASTQ, GenBank, RNA) and store the results. */
    public List<DNASequence> load(String input) {
        List<DNASequence> parsed = reader.read(input);
        addAll(parsed);
        return parsed;
    }

    public List<DNASequence> loadFile(Path path) throws IOException {
        return load(Files.readString(path));
    }

    public Optional<DNASequence> get(String id) {
        return Optional.ofNullable(sequences.get(id));
    }

    public boolean remove(String id) {
        return sequences.remove(id) != null;
    }

    public int size() {
        return sequences.size();
    }

    public List<DNASequence> all() {
        return List.copyOf(sequences.values());
    }

    @Override
    public Iterator<DNASequence> iterator() {
        return all().iterator();
    }

    public enum Format {
        PLAIN(new PlainWriter()),
        RNA(new RnaWriter()),
        FASTA(new FastaWriter()),
        FASTQ(new FastqWriter()),
        GENBANK(new GenBankWriter());

        private final SequenceWriter writer;
        Format(SequenceWriter writer) { this.writer = writer; }
        public SequenceWriter writer() { return writer; }
    }

    /** Write every stored sequence in the given format. */
    public String write(Format format) {
        return format.writer().writeAll(all());
    }

    /** Write a single stored sequence in the given format. */
    public String write(String id, Format format) {
        DNASequence seq = sequences.get(id);
        if (seq == null) throw new NoSuchElementException("No sequence with id " + id);
        return format.writer().write(seq);
    }

    public void writeTo(Format format, Path path) throws IOException {
        Files.writeString(path, write(format));
    }
}

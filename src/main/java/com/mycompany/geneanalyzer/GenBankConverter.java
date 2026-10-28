package com.mycompany.geneanalyzer;

import java.util.ArrayList;
import java.util.List;

public class GenBankConverter implements SequenceConverter {

    public boolean canHandle(String in) { return in.contains("LOCUS") && in.contains("ORIGIN"); }

    public List<DNASequence> parse(String in) {
        List<DNASequence> result = new ArrayList<>();

        for (String record : in.split("(?m)^//\\s*$")) {
            if (!record.contains("ORIGIN")) continue;

            String id = record.lines().filter(l -> l.startsWith("LOCUS"))
                    .map(l -> l.split("\\s+")[1]).findFirst().orElse("unnamed");

            String seqPart = record.substring(record.indexOf("ORIGIN") + 6);
            String bases = seqPart.replaceAll("[^A-Za-z]", "");  // drops numbers/spaces

            result.add(new DNASequence(id, bases));
        }
        return result;
    }
}

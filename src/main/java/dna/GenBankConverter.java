/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derick.dnasequencedataclasses;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author 6300410
 */

public class GenBankConverter implements SequenceConverter {

    @Override
    public boolean canHandle(String in) { return in.contains("LOCUS") && in.contains("ORIGIN"); }

    @Override
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

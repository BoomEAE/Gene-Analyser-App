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
public class FastaConverter implements SequenceConverter {

    @Override
    public boolean canHandle(String input) {
        return input.stripLeading().startsWith(">");
    }

    @Override
    public List<DNASequence> parse(String input) {
        List<DNASequence> result = new ArrayList<>();
        String id = null;

        StringBuilder sb = new StringBuilder();

        for (String line : input.split("\\R")) {
            if (line.startsWith(">")) {
                if (id != null) result.add(new DNASequence(id, sb.toString()));
                id = line.substring(1).trim();
                sb.setLength(0);
            } else {
                sb.append(line.trim());
            }
        }

        if (id != null) {
            result.add(new DNASequence(id, sb.toString()));
        }

        return result;
    }
}

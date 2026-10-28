/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derick.dnasequencedataclasses;

/**
 *
 * @author 6300410
 */
import java.util.ArrayList;
import java.util.List;

public class FastqConverter implements SequenceConverter {
    
    @Override
    public boolean canHandle(String in) {
        return in.stripLeading().startsWith("@");
    }

    @Override
    public List<DNASequence> parse(String in) {
        String[] lines = in.split("\\R");
        List<DNASequence> result = new ArrayList<>();

        for (int i = 0; i + 3 < lines.length; i += 4) {
            result.add(new DNASequence(lines[i].substring(1).trim(), lines[i + 1]));
            // lines[i+3] is quality scores;
        }

        return result;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derick.dnasequencedataclasses;

import java.util.List;
/**
 *
 * @author 6300410
 */

public class RnaConverter implements SequenceConverter {

    @Override
    public boolean canHandle(String in) {
        String s = in.strip().toUpperCase();
        return s.contains("U") && s.matches("[ACGUN\\s]+");
    }
    
    @Override
    public List<DNASequence> parse(String in) {
        return List.of(new DNASequence("rna", in.toUpperCase().replace('U', 'T')));
    }
}

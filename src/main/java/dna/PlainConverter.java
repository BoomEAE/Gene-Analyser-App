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

public class PlainConverter implements SequenceConverter {

    @Override
    public boolean canHandle(String input) {
        return input.strip().matches("[ACGTNacgtn\\\\s]+");
    }

    @Override
    public List<DNASequence> parse(String input) {
        return List.of(new DNASequence("unnamed", input));
    }
}

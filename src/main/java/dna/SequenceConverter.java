/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package derick.dnasequencedataclasses;

import java.util.List;

/**
 *
 * @author 6300410
 */

public interface SequenceConverter {
    boolean canHandle(String input);
    List<DNASequence> parse(String input);
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package derick.dnasequencedataclasses;

import java.util.Collection;
import java.util.stream.Collectors;
/**
 *
 * @author 6300410
 */

public interface SequenceWriter {
    /** Text for one record, always ending in a newline.
     * @param seq
     * @return  */
    String write(DNASequence seq);

    String extension();

    default String writeAll(Collection<DNASequence> seqs) {
        return seqs.stream().map(this::write).collect(Collectors.joining());
    }
}

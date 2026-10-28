/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derick.dnasequencedataclasses;

/**
 *
 * @author 6300410
 */
public class PlainWriter implements SequenceWriter {

    @Override
    public String write(DNASequence seq) { return seq.getRawSequence() + "\n"; }

    @Override
    public String extension() {
        return "txt";
    }
}
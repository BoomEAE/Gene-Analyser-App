/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derick.dnadataclasses;

/**
 * Based on BIOJAVA Class
 *
 * @author 6300410
 * Model Class for writing a plain sequence into external CSV
 */
public class PlainWriter implements SequenceWriter {

    @Override
    public String write(DNASequence seq) { return seq.getRawSequence() + "\n"; }

    @Override
    public String extension() {
        return "txt";
    }
}
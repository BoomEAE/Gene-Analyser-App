/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geneanalyzerprroject;

/**
 *
 * @author Cynthia Zhang
 */
public class SequenceValidator {
    
    public boolean isValidSequence(String sequence) {
        if (sequence == null || sequence.length() == 0) {
            return false;
        }

        String dna = sequence.toUpperCase();

        for (int i = 0; i < dna.length(); i++) {
            char nucleotide = dna.charAt(i);

            if (nucleotide != 'A' && nucleotide != 'T' && nucleotide != 'C' && nucleotide != 'G') {
                return false;
            }
        }

        return true;
    }  
}


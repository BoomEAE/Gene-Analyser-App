/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geneanalyzerprroject;
import java.util.Comparator;

/**
 *
 * @author Cynthia
 */
public class SequenceComparator implements Comparator <DNASequence> {
    
    @Override
    public int compare(DNASequence sequence1, DNASequence sequence2) {
        double gcContent1 = calculateGCContent(sequence1);
        double gcContent2 = calculateGCContent(sequence2);

        return Double.compare(gcContent1, gcContent2);
    }
    
    private double calculateGCContent(DNASequence sequence) {
        String dna = sequence.getRawSequence().toUpperCase();
        int gcCount = 0;

        for (int i = 0; i < dna.length(); i++) {
            char nucleotide = dna.charAt(i);

            if (nucleotide == 'G' || nucleotide == 'C') {
                gcCount++;
            }
        }

        if (dna.length() == 0) {
            return 0;
        }

        return (double) gcCount / dna.length() * 100;
    }
}

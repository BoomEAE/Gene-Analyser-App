/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geneanalyzerprroject;

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

}

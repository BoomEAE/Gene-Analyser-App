/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geneanalyzerprroject;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Cynthia Zhang
 */
public class SequenceComparator implements Comparator <DNASequence> {
    
    @Override
    public int compare(DNASequence sequence1, DNASequence sequence2) {
        double gcContent1 = calculateGCContent(sequence1);
        double gcContent2 = calculateGCContent(sequence2);

        return Double.compare(gcContent1, gcContent2);
    }
    
     public DNASequence[] findMostSimilarSequences(List<DNASequence> sequences) { 
        if (sequences == null || sequences.size() < 2) {
            return null;
        }
 
        DNASequence[] result = new DNASequence[2];
        double smallestDifference = Double.MAX_VALUE;

        for (int i = 0; i < sequences.size(); i++) {
            DNASequence sequence1 = sequences.get(i);

            for (int j = i + 1; j < sequences.size(); j++) {

                DNASequence sequence2 = sequences.get(j);
                double gcContent1 = calculateGCContent(sequence1);
                double gcContent2 = calculateGCContent(sequence2);
                double difference = Math.abs(gcContent1 - gcContent2);

                if (difference < smallestDifference) {
                    smallestDifference = difference;
                    result[0] = sequence1;
                    result[1] = sequence2;
                }
            }
        }

        return result;
    }
     
     
    public List<DNASequence> organizeSequences(List<DNASequence> sequences) {

        if (sequences == null) {
            return null;
        }

        List<DNASequence> organizedSequences = new ArrayList<>();

        for (int i = 0; i < sequences.size(); i++) {
            organizedSequences.add(sequences.get(i));
        }

        Collections.sort(organizedSequences, this);
        return organizedSequences;
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

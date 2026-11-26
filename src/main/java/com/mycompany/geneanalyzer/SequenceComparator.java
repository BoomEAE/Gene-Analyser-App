/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geneanalyzer;
import java.util.Comparator;
import java.util.List;
/**
 *
 * @author Cynthia Zhang
 */
public class SequenceComparator implements Comparator <DNASequence> {
    
    private SequenceValidator sequenceValidator = new SequenceValidator();
    
    @Override
    public int compare(DNASequence sequence1, DNASequence sequence2) {
        double gcContent1 = calculateGCContent(sequence1);
        double gcContent2 = calculateGCContent(sequence2);

        return Math.abs(Double.compare(gcContent1, gcContent2));
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
    
    public int getBaseADifference(DNASequence sequence1, DNASequence sequence2){
        NucleotideComposition nucleotideComposition1 = new NucleotideComposition(sequence1);
        NucleotideComposition nucleotideComposition2 = new NucleotideComposition(sequence2);
        return Math.abs(nucleotideComposition1.getACount() - nucleotideComposition2.getACount());
    }
    
    public int getBaseTDifference(DNASequence sequence1, DNASequence sequence2){
        NucleotideComposition nucleotideComposition1 = new NucleotideComposition(sequence1);
        NucleotideComposition nucleotideComposition2 = new NucleotideComposition(sequence2);
        return Math.abs(nucleotideComposition1.getTCount() - nucleotideComposition2.getTCount());
    }
    
    public int getBaseCDifference(DNASequence sequence1, DNASequence sequence2){
        NucleotideComposition nucleotideComposition1 = new NucleotideComposition(sequence1);
        NucleotideComposition nucleotideComposition2 = new NucleotideComposition(sequence2);
        return Math.abs(nucleotideComposition1.getCCount() - nucleotideComposition2.getCCount());
    }
    
    public int getBaseGDifference(DNASequence sequence1, DNASequence sequence2){
        NucleotideComposition nucleotideComposition1 = new NucleotideComposition(sequence1);
        NucleotideComposition nucleotideComposition2 = new NucleotideComposition(sequence2);
        return Math.abs(nucleotideComposition1.getGCount() - nucleotideComposition2.getGCount());
    }
    
    public double getPercentageADifference(DNASequence sequence1, DNASequence sequence2){
        NucleotideComposition nucleotideComposition1 = new NucleotideComposition(sequence1);
        NucleotideComposition nucleotideComposition2 = new NucleotideComposition(sequence2);
        return Math.abs(nucleotideComposition1.getAPercentage() - nucleotideComposition2.getAPercentage());
    }
    
    public double getPercentageTDifference(DNASequence sequence1, DNASequence sequence2){
        NucleotideComposition nucleotideComposition1 = new NucleotideComposition(sequence1);
        NucleotideComposition nucleotideComposition2 = new NucleotideComposition(sequence2);
        return Math.abs(nucleotideComposition1.getTPercentage() - nucleotideComposition2.getTPercentage());
    }
    
    public double getPercentageCDifference(DNASequence sequence1, DNASequence sequence2){
        NucleotideComposition nucleotideComposition1 = new NucleotideComposition(sequence1);
        NucleotideComposition nucleotideComposition2 = new NucleotideComposition(sequence2);
        return Math.abs(nucleotideComposition1.getCPercentage() - nucleotideComposition2.getCPercentage());
    }
    
    public double getPercentageGDifference(DNASequence sequence1, DNASequence sequence2){
        NucleotideComposition nucleotideComposition1 = new NucleotideComposition(sequence1);
        NucleotideComposition nucleotideComposition2 = new NucleotideComposition(sequence2);
        return Math.abs(nucleotideComposition1.getGPercentage() - nucleotideComposition2.getGPercentage());
    }
}

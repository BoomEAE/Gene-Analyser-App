/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geneanalyzerprroject;

/**
 *
 * @author Cynthia Zhang
 */
public class NucleotideComposition {
    private int aCount;
    private int tCount;
    private int cCount;
    private int gCount;

    private double aPercentage;
    private double tPercentage;
    private double cPercentage;
    private double gPercentage;
    
    public NucleotideComposition(DNASequence sequence) {
        String dna = sequence.getRawSequence().toUpperCase();

        aCount = 0;
        tCount = 0;
        cCount = 0;
        gCount = 0;

        for (int i = 0; i < dna.length(); i++) {
            char nucleotide = dna.charAt(i);

            if (nucleotide == 'A') {
                aCount++;
            } else if (nucleotide == 'T') {
                tCount++;
            } else if (nucleotide == 'C') {
                cCount++;
            } else if (nucleotide == 'G') {
                gCount++;
            }
        }

        int total = aCount + tCount + cCount + gCount;

        if (total > 0) {
            aPercentage = (double) aCount / total * 100;
            tPercentage = (double) tCount / total * 100;
            cPercentage = (double) cCount / total * 100;
            gPercentage = (double) gCount / total * 100;
        }
    }
    
    public int getACount() {
        return aCount;
    }

    public int getTCount() {
        return tCount;
    }

    public int getCCount() {
        return cCount;
    }

    public int getGCount() {
        return gCount;
    }

    public double getAPercentage() {
        return aPercentage;
    }

    public double getTPercentage() {
        return tPercentage;
    }

    public double getCPercentage() {
        return cPercentage;
    }

    public double getGPercentage() {
        return gPercentage;
    }
    
}

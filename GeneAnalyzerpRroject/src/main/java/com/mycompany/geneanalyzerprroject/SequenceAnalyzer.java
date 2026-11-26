/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geneanalyzerprroject;

/**
 *
 * @author Cynthia Zhang
 */
public class SequenceAnalyzer {
    
    public AnalysisResult analyze(DNASequence sequence) {
             
        SequenceValidator validator = new SequenceValidator();
        if (sequence == null || !validator.isValidSequence(sequence.getRawSequence())) {
            return null;
        }

        NucleotideComposition composition = new NucleotideComposition(sequence);
        int total = sequence.length();
        double gcContent = 0;

        if (total > 0) {
            gcContent = (double) (composition.getGCount()+ composition.getCCount()) / total * 100;
        }

        return new AnalysisResult(sequence.getId(), composition, gcContent);
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.geneanalyzerprroject;

/**
 *
 * @author Cynthia
 */
public class AnalysisResult {    
    private String sequenceId;
    private NucleotideComposition nucleotideComposition;
    private double gcContent;
    
    public AnalysisResult(String sequenceId, NucleotideComposition nucleotideComposition, double gcContent) {
        this.sequenceId = sequenceId;
        this.nucleotideComposition = nucleotideComposition;
        this.gcContent = gcContent;
    }
    
    public String getSequenceId() {
        return sequenceId;
    }

    public NucleotideComposition getNucleotideComposition() {
        return nucleotideComposition;
    }

    public double getGcContent() {
        return gcContent;
    }
}

package com.mycompany.geneanalyzer;

public class DNASequence {
    private String id;
    private final String rawSequence;

    public DNASequence(String id, String rawSequence) {
        String cleaned = rawSequence.replaceAll("\\s+", "");

        if (!cleaned.matches("[ACGTN]*")) {
            throw new IllegalArgumentException("Invalid DNA characters");
        }

        this.id = id;
        this.rawSequence = cleaned;
    }

    public String getId() {
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }

    public String getRawSequence() {
        return rawSequence;
    }

    public int length() {
        return rawSequence.length();
    }
    
    @Override
    public String toString(){
        return id + "( sequence size: " + length() + ")";
    }
}

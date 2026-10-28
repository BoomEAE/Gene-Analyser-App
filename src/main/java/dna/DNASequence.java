/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derick.dnasequencedataclasses;

/**
 *
 * @author 6300410
 */
public class DNASequence {
    private final String id;
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

    public String getRawSequence() {
        return rawSequence;
    }

    public int length() {
        return rawSequence.length();
    }
}

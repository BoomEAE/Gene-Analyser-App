/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package derick.dnasequencedataclasses;

/**
 *
 * @author 6300410
 */
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class SequenceReader {
    private final List<SequenceConverter> converters = List.of(
            new FastaConverter(),
            new FastqConverter(),
            new GenBankConverter(),
            new RnaConverter(),
            new PlainConverter()
    );

    public List<DNASequence> read(String input) {

        for (SequenceConverter c : converters) {
            if (c.canHandle(input)) return c.parse(input);
        }

        throw new IllegalArgumentException("Unrecognized sequence format");
    }

    public List<DNASequence> readFile(Path path) throws IOException {
        return read(Files.readString(path));
    }
}

import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;

import java.io.IOException;

/**
 * Arkady Shagal
 * 10:51 PM
 */
public class Main {
    public static void main(String[] args) throws IOException {
        CharStream stream = new ANTLRFileStream("input2.txt");
        GrammarLexer lexer = new GrammarLexer(stream);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokenStream);

        parser.body();
    }
}

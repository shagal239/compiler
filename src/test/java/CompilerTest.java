import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Arkady Shagal
 * 2:46 PM
 */
public class CompilerTest {
    public File run(String file){
        try {
            /*BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }*/
            GrammarLexer lexer = new GrammarLexer(new ANTLRFileStream(file));
            GrammarParser parser = new GrammarParser(new CommonTokenStream(lexer));
            List<String> code = parser.start().result;

            String outfile = "test_interpretator.";

            File file1 = new File(outfile + file.substring(file.indexOf(".") + 1));
            PrintWriter out = new PrintWriter(file1);
            for (String line: code) {
                out.println(line);
            }
            out.close();
            return file1;
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public void runTest(String file) throws Exception {
        File out = run(file);
        new Interpretator().run(out);
    }

    @Test
    public void test1() throws Exception {
        runTest("test_compiler.1");
    }
    @Test
    public void test2() throws Exception {
        runTest("test_compiler.2");
    }
    @Test
    public void test3() throws Exception {
        runTest("test_compiler.3");
    }
    @Test
    public void test4() throws Exception {
        runTest("test_compiler.4");
    }

    @Test
    public void test5() throws Exception {
        runTest("test_compiler.5");
    }

    @Test
    public void test6() throws Exception {
        runTest("test_compiler.6");
    }
}

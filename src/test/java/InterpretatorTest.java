import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * Arkady Shagal
 * 6:41 PM
 */
public class InterpretatorTest {
    @Test
    public void test1() throws Exception {
        File file = new File("test_interpretator_hand.1");
        Interpretator interpretator = new Interpretator();
        interpretator.run(file);
    }

    @Test
    public void test2() throws Exception {
        File file = new File("test_interpretator_hand.2");
        Interpretator interpretator = new Interpretator();
        interpretator.run(file);
    }
    @Test
    public void test3() throws Exception {
        File file = new File("test_interpretator_hand.3");
        Interpretator interpretator = new Interpretator();
        interpretator.run(file);
    }
    @Test
    public void test4() throws Exception {
        File file = new File("test_interpretator_hand.4");
        Interpretator interpretator = new Interpretator();
        interpretator.run(file);
    }

    @Test
    public void test5() throws Exception {
        File file = new File("test_interpretator.5");
        Interpretator interpretator = new Interpretator();
        interpretator.run(file);
    }

    @Test
    public void test_auto() throws Exception {
        File file = new File("test_interpretator.3");
        Interpretator interpretator = new Interpretator();
        interpretator.run(file);
    }

    @Test
    public void test_auto_10() throws Exception {
        File file = new File("test_interpretator.9");
        Interpretator interpretator = new Interpretator();
        interpretator.run(file);
    }
}

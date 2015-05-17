import org.junit.Test;

/**
 * Arkady Shagal
 * 8:54 PM
 */
public class Compilable {
    @Test
    public void test(){
        int a = 0;
        int b = 1;
        int c = 2;
        int d = a = b -= c;
        System.err.println(a + " " + b + " " + c + " " + d);
    }
}

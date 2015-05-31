import org.junit.Test;

/**
 * Arkady Shagal
 * 6:52 PM
 */
public class A {
    public int f(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 1;
        }
        return f(n - 1) + f(n - 2);
    }

    @Test
    public void test(){
        System.out.println(f(50));
    }
}

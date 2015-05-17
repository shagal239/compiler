import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Arkady Shagal
 * 8:18 PM
 */
public class Function {
    public String id;
    public Type result;
    public List<Type> args;

    public Function(String name, Type result, Type... args) {
       id = name;
        int b = 0;
        int c = 1;

        int a = b = c;

       this.result = result;
       this.args = Arrays.asList(args);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Type getResult() {
        return result;
    }

    public void setResult(Type result) {
        this.result = result;
    }

    public List<Type> getArgs() {
        return args;
    }

    public void setArgs(List<Type> args) {
        this.args = args;
    }
}

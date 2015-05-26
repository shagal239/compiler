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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Function function = (Function) o;

        if (args != null ? !args.equals(function.args) : function.args != null) return false;
        if (id != null ? !id.equals(function.id) : function.id != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (args != null ? args.hashCode() : 0);
        return result;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Arkady Shagal
 * 10:21 PM
 */
public class FunctionVariable extends Variable {
    public Type returnType;
    public List<Type> args;

    public FunctionVariable(String id, Type type) {
        super(type, id);
    }
}

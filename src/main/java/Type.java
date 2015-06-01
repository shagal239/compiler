import java.util.List;

/**
 * Arkady Shagal
 * 2:06 PM
 */
public enum Type {
    IntegerType,
    BooleanType,
    StringType,
    FunctionType,
    VoidType;

    public Type returnType;
    public List<Type> args;

    private Type() {

    }
    private Type(Type returnType, List<Type> args) {
        this.returnType = returnType;
        this.args = args;
    }
}


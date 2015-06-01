import java.util.HashMap;

/**
 * Arkady Shagal
 * 10:45 AM
 */
public class Scope {
    HashMap<String, Variable> variables = new HashMap<String, Variable>();
    HashMap<String, FunctionVariable> functions = new HashMap<String, FunctionVariable>();

    public void addFunction(String name, FunctionVariable function) {
        functions.put(name, function);
    }
    public void addVariable(String name, Variable variable) {
        variables.put(name, variable);
    }

    boolean containsFunction(String s) {
        return functions.containsKey(s);
    }
    boolean contains(String s){
        return variables.containsKey(s);
    }

    Variable get(String s){
        return variables.get(s);
    }

    FunctionVariable getFunction(String s) {
        return functions.get(s);
    }
}

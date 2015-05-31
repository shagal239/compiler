import java.util.HashMap;

/**
 * Arkady Shagal
 * 10:45 AM
 */
public class Scope {
    HashMap<String, Variable> variables = new HashMap<String, Variable>();
    public void addVariable(String name, Variable variable) {
        variables.put(name, variable);
    }

    boolean contains(String s){
        return variables.containsKey(s);
    }

    Variable get(String s){
        return variables.get(s);
    }
}

import java.util.*;

/**
 * Arkady Shagal
 * 11:22 AM
 */
public class Functions {
    static Map<String, Set<Function>> map = new HashMap<String, Set<Function>>();
    static {
        List<Type> types = new ArrayList<Type>();

        add("print", Type.VoidType, Type.StringType);
        add("print", Type.VoidType, Type.IntegerType);
        add("print", Type.VoidType, Type.BooleanType);
        add("println", Type.VoidType, Type.StringType);
        add("println", Type.VoidType, Type.IntegerType);
        add("println", Type.VoidType, Type.BooleanType);

        add("read", Type.StringType, types);
        add("read", Type.StringType, types);
        add("read", Type.StringType, types);

        add("readln", Type.IntegerType, types);
        add("readln", Type.IntegerType, types);
        add("readln", Type.IntegerType, types);

    }

    static public void add(String name, Type returnType, Type... var) {
        add(new Function(name, returnType, var));
    }

    static public void add(String name, Type returnType, List<Type> var) {
        add(new Function(name, returnType, var));
    }


    static public boolean add(Function f) {
        if (!map.containsKey(f.getId())) {
            Set<Function> set = new HashSet<Function>();
            set.add(f);
            map.put(f.getId(), set);
        } else {
            Set<Function> functions = map.get(f.getId());
            if (functions.contains(f)) {
                return false;
            } else {
                functions.add(f);
                return true;
            }
        }
        return true;
    }

    static public Function get(String name, List<Type> args) {
        if (!map.containsKey(name)) {
            return null;
        }
        for (Function f : map.get(name)) {
            if (f.getArgs().equals(args)) {
                return f;
            }
        }
        return null;
    }
}

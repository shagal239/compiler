import com.sun.org.apache.xpath.internal.operations.Bool;

import java.io.*;
import java.util.*;

/**
 * Arkady Shagal
 * 4:39 PM
 */

public class Interpretator {
    //IO
    Scanner input;
    PrintWriter output;

    Stack<Integer> callStack = new Stack<Integer>();
    Stack<HashMap<String, Variable>> variableStack = new Stack<HashMap<String, Variable>>();
    Map<String, Integer> tags = new HashMap<String, Integer>();
    List<String> commands = new ArrayList<String>();
    Stack<Variable> stack = new Stack<Variable>();
    Stack<HashMap<String, Variable>> functionStack = new Stack<HashMap<String, Variable>>();

    public Variable getFunctionVariable(String name) {
        return functionStack.peek().get(name);
    }

    public void putFunctionVariable(String name, Variable variable) {
        functionStack.peek().put(name, variable);
    }

    public int step() {
        int pos = callStack.get(callStack.size() - 1);
        callStack.set(callStack.size() - 1, pos + 1);
        return pos + 1;
    }

    public void putVariable(String name, Variable variable) {
        if (name.startsWith("&"))  {
            variableStack.get(variableStack.size() - 2).put(name.substring(1), variable);
        } else {
            variableStack.peek().put(name, variable);
        }
    }

    public Variable read(String name) {
        Variable v = new Variable(Type.StringType, name);
        v.value = input.next();
        return v;
    }

    public Variable readln(String name) {
        Variable v = new Variable(Type.StringType, name);
        Scanner in = new Scanner(System.in);
        v.value = in.nextLine();
        return v;
    }

    public void print(String s) {
        output.print(s);
    }

    public void println(String s) {
        output.println(s);
    }

    public void callFunction(String name) {
        if (name.equals("read")) {
            Variable to = stack.pop();
            putVariable(to.id, read(name));
            return;
        }
        if (name.equals("readln")) {
            Variable to = stack.pop();
            putVariable(to.id, readln(name));
            return;
        }
        if (name.equals("print")) {
            stack.pop();
            Variable variable = stack.pop();
            print(variable.value.toString());
            return;
        }
        if (name.equals("println")) {
            stack.pop();
            Variable variable = stack.pop();
            println(variable.value.toString());
            return;
        }

        variableStack.push(new HashMap<String, Variable>());
        callStack.add(tags.get(name));
    }


    public Variable getVariable(String name) {
        return variableStack.peek().get(name);
    }

    public Variable applyUnary(String name, String right) {
        if (right.equals("true") || right.equals("false")) {
            Variable variable = new Variable(Type.BooleanType, name);
            variable.value = Boolean.parseBoolean(right);
            return variable;
        }
        if (right.startsWith("\"")) {
            Variable variable = new Variable(Type.StringType, name);
            variable.value = (right.substring(1, right.length() - 1));
            return variable;
        }
        if (right.matches("[0-9]+")) {
            Variable variable = new Variable(Type.IntegerType, name);
            variable.value = (Integer.parseInt(right));
            return variable;
        }
        if (right.matches("[a-z][0-9]+")) {
            Variable variable = getVariable(right);
            variable.id = name;
            return variable;
        }
        if (name.matches("F[0-9]+")) {
            Variable variable = getFunctionVariable(right);
            variable.id = name;
            return variable;
        }
        return applyUnary(name, right.substring(1));
    }

    public Variable applyBinary(String left, String op, String right) {
        return getVariable(left).apply(op, getVariable(right));
    }

    public void goTo(String tag) {
        callStack.set(callStack.size() - 1, tags.get(tag));
    }

    public void apply (String command) throws Exception {
        String[] split = command.split(" ");
        if (command.endsWith(":")) {
            return;
        }

        if (command.equals("breakpoint")) {
            return;
        }

        if (command.startsWith("goto")) {
            goTo(split[1]);
        }

        if (command.startsWith("if")) {
            Variable variable = getVariable(split[1]);
            if (variable == null || variable.value == null) {
                throw new Exception("error");
            }
            if ((Boolean)variable.value) {
                goTo(split[3]);
            } else {
                return;
            }
        }

        if (command.startsWith("!if")) {
            Variable variable = getVariable(split[1]);
            if (variable == null || variable.value == null) {
                throw new Exception("error");
            }
            if (!(Boolean)variable.value) {
                goTo(split[3]);
            } else {
                return;
            }
        }

        if (command.startsWith("param")) {
            if (!split[1].startsWith("&"))
                stack.add(getVariable(split[1]));
            else {
                if (!split[1].substring(1).equals("void")) {
                    stack.add(getVariable(split[1].substring(1)));
                } else {
                    stack.add((new Variable(Type.VoidType, UUID.randomUUID().toString()))) ;
                }
            }
            return;
        }

        if (command.startsWith("fparam")) {
            stack.add(getFunctionVariable(split[1]));
        }

        if (command.startsWith("pop")) {
            if (!split[1].equals("void"))
                putVariable(split[1], stack.pop());
            return;
        }
        if (command.startsWith("call")) {
            if (!split[1].startsWith("&")) {
                callFunction(split[1]);
            } else {
                Variable variable = getVariable(split[1].substring(1));
                variableStack.push(new HashMap<String, Variable>());
                callStack.add((Integer) variable.value);
            }
            return;
        }

        if (command.startsWith("back")) {
            callStack.remove(callStack.size() - 1);
            variableStack.pop();
            return;
        }

        if (command.startsWith("boolean")) {
            putVariable(split[1], new Variable(Type.BooleanType, split[1]));
            return;
        }
        if (command.startsWith("int")) {
            putVariable(split[1], new Variable(Type.IntegerType, split[1]));
            return;
        }
        if (command.startsWith("String")) {
            putVariable(split[1], new Variable(Type.StringType, split[1]));
            return;
        }

        if (command.startsWith("function")) {
            putVariable(split[1], new Variable(Type.FunctionType, split[1]));
            return;
        }

        String name = split[0];
        if (split[0].startsWith("*")) {
            name = "&" + (getVariable(split[0].substring(1)).id);
        }

        Variable variable = null;

        if (command.contains("\"")) {
            split = Arrays.copyOf(split, 3);
            split[2] = command.substring(command.indexOf("\""));
        }

        if (split.length == 3) {
            variable = applyUnary(name, split[2]);
        }
        if (split.length == 5) {
            variable = applyBinary(split[2], split[3], split[4]);
        }

        putVariable(name, variable);
    }

    public void run(File file) throws Exception {
        input = new Scanner(System.in);
        output = new PrintWriter(System.out);

        variableStack.push(new HashMap<String, Variable>());
        functionStack.push(new HashMap<String, Variable>());

        Scanner in = new Scanner(file);
        int p = 0;
        String line;
        while (in.hasNext()) {
            line = in.nextLine();
            if (line.endsWith(":")) {
                tags.put(line.substring(0, line.length() - 1), p);
                Variable variable = new Variable(Type.FunctionType, line.substring(0, line.length() - 1));
                variable.value = p;
                putFunctionVariable(line.substring(0, line.length() - 1), variable);
            }
            commands.add(line);
            p++;
        }

        if (!tags.containsKey("main")) {
            return;
        }

        callStack.add(tags.get("main"));

        while(!callStack.empty()) {
            int pos = step();
            System.err.println(commands.get(pos));
            apply(commands.get(pos));
        }

        output.close();
    }
}

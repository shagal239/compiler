import com.sun.org.apache.xpath.internal.operations.Bool;

/**
 * Arkady Shagal
 * 2:04 PM
 */
public class Variable {
    static Variable Void = new Variable(Type.VoidType, "void");
    public Type type;
    public String id;
    public Object value;
    public Variable(Type type, String id) {
        this.type = type;
        this.id = id;
        value = null;
    }

    public String declaration() {
        String s = "";
        switch (type) {
            case VoidType:
                s += "void";
                break;
            case IntegerType:
                s += "int";
                break;
            case StringType:
                s += "String";
                break;
            case BooleanType:
                s += "boolean";
                break;
            default:
                s += "hrenikakayto";
                break;
        }

        s += " " + id;
        return s;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Variable apply(String op) {
        Variable variable = new Variable(type, id + op);
        if (type == Type.BooleanType && op.equals("!")) {
            variable.value = !(Boolean)value;
            return variable;
        }

        if (type == Type.IntegerType && op.equals("-")) {
            variable.value = -(Integer)value;
            return variable;
        }

        if (type == Type.IntegerType && op.equals("~")) {
            variable.value = ~(Integer)value;
            return variable;
        }
        return null;
    }

    @Override
    public String toString() {
        return type + ": " + id + ": " + value;
    }

    public Variable apply(String op, Variable other) {
        if (value == null) {
            return null;
        }
        if (other.value == null) {
            return null;
        }

        if (op.equals("|") || op.equals("||")) {
            if (type != other.type) {
                return null;
            }

            if (type != Type.BooleanType) {
                return null;
            }

            Variable variable = new Variable(Type.BooleanType, id + "_" + op + "_" + other.id);
            variable.value = (Boolean)value || (Boolean)other.value;
            return variable;
        }

        if (op.equals("&") || op.equals("&&")) {
            if (type != other.type) {
                return null;
            }

            if (type != Type.BooleanType) {
                return null;
            }

            Variable variable = new Variable(Type.BooleanType, id + "_" + op + "_" + other.id);
            variable.value = (Boolean)value && (Boolean)other.value;
            return variable;
        }

        if (op.equals("+")) {
            if (type == Type.BooleanType) {
                return null;
            } else {
                Variable variable = new Variable(type, id + "_" + op + "_" + other.id);
                if (type == Type.IntegerType) {
                    if (other.type == Type.IntegerType) {
                        variable.value = (Integer)value + (Integer)other.value;
                    } else {
                        return null;
                    }
                } else {
                    if (type == Type.StringType) {
                        variable.value = value + other.value.toString();
                    }
                }
                return variable;
            }
        }

        if (op.equals("-")) {
            if (type != other.type) {
                return null;
            }
            if (type != Type.IntegerType) {
                return null;
            }

            Variable variable = new Variable(Type.IntegerType, id +"_" + op + "_" + other.id);
            variable.value = (Integer)value - (Integer)other.value;
            return variable;
        }

        if (op.equals("*")) {
            if (type != other.type) {
                return null;
            }
            if (type != Type.IntegerType) {
                return null;
            }

            Variable variable = new Variable(Type.IntegerType, id +"_" + op + "_" + other.id);
            variable.value = (Integer)value * (Integer)other.value;
            return variable;
        }

        if (op.equals("/")) {
            if (type != other.type) {
                return null;
            }
            if (type != Type.IntegerType) {
                return null;
            }

            Variable variable = new Variable(Type.IntegerType, id +"_" + op + "_" + other.id);
            variable.value = (Integer)value / (Integer)other.value;
            return variable;
        }

        if (op.equals("%")) {
            if (type != other.type) {
                return null;
            }
            if (type != Type.IntegerType) {
                return null;
            }

            Variable variable = new Variable(Type.IntegerType, id +"_" + op + "_" + other.id);
            variable.value = (Integer)value % (Integer)other.value;
            return variable;
        }

        if (op.equals("==")) {
            if (value == null || other.value == null) {
                return null;
            } else {
                Variable variable = new Variable(Type.BooleanType, op);
                variable.value = new Boolean(value.equals(other.value));
                return variable;
            }
        }

        if (op.equals("!=")) {
            if (value == null || other.value == null) {
                return null;
            } else {
                Variable variable = new Variable(Type.BooleanType, op);
                variable.value = new Boolean(!value.equals(other.value));
                return variable;
            }
        }

        if (op.equals("<")) {
            if (value == null || other.value == null) {
                return null;
            } else {
                Variable variable = new Variable(Type.BooleanType, op);
                if (type != other.type) {
                    return null;
                }

                if (type == Type.BooleanType) {
                    return null;
                }

                if (type == Type.IntegerType) {
                    variable.value = new Boolean(((Integer)value).compareTo((Integer)other.value) < 0);
                }

                if (type == Type.StringType) {
                    variable.value = new Boolean(((String)value).compareTo((String)other.value) < 0);
                }
                return variable;
            }
        }

        if (op.equals(">")) {
            if (value == null || other.value == null) {
                return null;
            } else {
                Variable variable = new Variable(Type.BooleanType, op);
                if (type != other.type) {
                    return null;
                }

                if (type == Type.BooleanType) {
                    return null;
                }

                if (type == Type.IntegerType) {
                    variable.value = new Boolean(((Integer)value).compareTo((Integer)other.value) > 0);
                }

                if (type == Type.StringType) {
                    variable.value = new Boolean(((String)value).compareTo((String)other.value) > 0);
                }
                return variable;
            }
        }

        if (op.equals("<=")) {
            if (value == null || other.value == null) {
                return null;
            } else {
                Variable variable = new Variable(Type.BooleanType, op);
                if (type != other.type) {
                    return null;
                }

                if (type == Type.BooleanType) {
                    return null;
                }

                if (type == Type.IntegerType) {
                    variable.value = new Boolean(((Integer)value).compareTo((Integer)other.value) <= 0);
                }

                if (type == Type.StringType) {
                    variable.value = new Boolean(((String)value).compareTo((String)other.value) <= 0);
                }
                return variable;
            }
        }

        if (op.equals(">=")) {
            if (value == null || other.value == null) {
                return null;
            } else {
                Variable variable = new Variable(Type.BooleanType, op);
                if (type != other.type) {
                    return null;
                }

                if (type == Type.BooleanType) {
                    return null;
                }

                if (type == Type.IntegerType) {
                    variable.value = new Boolean(((Integer)value).compareTo((Integer)other.value) >= 0);
                }

                if (type == Type.StringType) {
                    variable.value = new Boolean(((String)value).compareTo((String)other.value) >= 0);
                }
                return variable;
            }
        }

        return null;

    }

}

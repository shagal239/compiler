/**
 * Arkady Shagal
 * 2:04 PM
 */
public class Variable {
    public Type type;
    public String id;

    public Variable(Type type, String id) {
        this.type = type;
        this.id = id;
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
}

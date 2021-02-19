package lecture20.constructor;

public class Entity {
    private String name = "Default name";

    protected Entity() {
    }

    public Entity(String name) {
        this.name = name;
    }

    public Entity(Integer name) {
        this.name = name.toString();
    }

    @Override
    public String toString() {
        return "Entity{" +
                "name='" + name + '\'' +
                '}';
    }
}

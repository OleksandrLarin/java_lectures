package lecture20.annotation;

public class Entity {
    @Value()
    private String id;
    @Value(value = "entity")
    private String name;

    @Override
    public String toString() {
        return "Entity{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}

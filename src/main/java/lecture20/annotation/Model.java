package lecture20.annotation;

public class Model {
    @Value(value = "${app.value}")
    private String name;
    @Value(value = "123")
    private String id;

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}

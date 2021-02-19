package lecture20.method;

import java.lang.reflect.Method;

public class ExampleApp {
    public static void main(String[] args) throws Exception {
        Class<Model> modelClass = Model.class;

        Method print = modelClass.getDeclaredMethod("print", String.class);

        Model model = new Model();
        print.setAccessible(true);
        print.invoke(model, "Hello");
        print.setAccessible(false);
    }
}

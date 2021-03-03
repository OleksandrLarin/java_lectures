package lecture20.constructor;

import java.lang.reflect.Constructor;

public class PrivateConstructorExample {
    public static void main(String[] args) {
        Class<Model> modelClass = Model.class;

        try {
            Constructor<Model> constructor = modelClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            Model model = constructor.newInstance();
            constructor.setAccessible(false);
            model.info();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

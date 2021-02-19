package lecture20.annotation;

import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class App {
    private final static String PROPERTY_FILE = "src//main//resources//app-%s.properties";

    public static void main(String[] args) {
        loadProperties(args[0]);

        Model model = createInstance(Model.class);

        System.out.println(model.getName());
        System.out.println(model.getId());

        Entity entity = createInstance(Entity.class);

        System.out.println(entity);
    }

    private static void loadProperties(String env) {
        Properties properties = new Properties();
        try (FileInputStream fis = new FileInputStream(String.format(PROPERTY_FILE, env))){
            properties.load(fis);
            System.setProperties(properties);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static <T> T createInstance(Class<T> modelClass) {
        try {
            Constructor constructor = modelClass.getConstructor();
            T model = (T) constructor.newInstance();
            initializeFieldObject(model);
            return model;
        } catch (NoSuchMethodException e) {
            System.out.println("Error: No default constructor");
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException e) {
            System.out.println("Error: Object can't be created");
        }
        return null;
    }

    private static <T> void initializeFieldObject(T model) throws IllegalAccessException {
        Field[] fields = model.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(Value.class)){
                Value annotation = field.getAnnotation(Value.class);
                String value = getValue(annotation);

                field.setAccessible(true);
                field.set(model, value);
                field.setAccessible(false);
            }
        }
    }

    private static String getValue(Value annotation) {
        String value = annotation.value();
        if (value.matches("\\$\\{.*\\}")) {
            String substring = value.substring(2, value.length() - 1);
            return System.getProperty(substring);
        }
        return value;
    }
}

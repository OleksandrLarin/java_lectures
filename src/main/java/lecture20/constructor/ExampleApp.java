package lecture20.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExampleApp {
    public static void main(String[] args) throws Exception {
        Class<Entity> entityClass = Entity.class;

        int modifiers = entityClass.getModifiers();
//        System.out.println("Is public " + Modifier.isPublic(modifiers));
//        System.out.println("Is final " + Modifier.isFinal(modifiers));

        List<Entity> entities = new ArrayList<>();

        Constructor<?>[] constructors = entityClass.getConstructors();
        for (Constructor<?> constructor : constructors) {
            if (Modifier.isPublic(constructor.getModifiers())){
                System.out.println(Arrays.toString(constructor.getParameterTypes()));
                if (isStringConstructor(constructor)) {
                    Entity newEntity = (Entity) constructor.newInstance("New Name");
                    entities.add(newEntity);
                }
                if (constructor.getParameterCount() == 0) {
                    entities.add((Entity) constructor.newInstance());
                }
            }
        }

        System.out.println(entities);
    }

    private static boolean isStringConstructor(Constructor<?> constructor) {
        return constructor.getParameterCount() == 1 &&
                constructor.getParameterTypes()[0].equals(String.class);
    }
}

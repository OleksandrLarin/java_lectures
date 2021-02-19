package lecture20.field;

import java.lang.reflect.Field;

public class App {
    public static void main(String[] args) throws Exception {
        Model model = new Model();
        setupFieldsValue(model, "Model name", 123);

        getFieldsValue(model);
    }

    private static void setupFieldsValue(Model model, String name, int id) throws Exception {
        Class<Model> modelClass = Model.class;

        Field fieldId = modelClass.getDeclaredField("id");
        Field fieldName = modelClass.getField("name");


        fieldName.set(model, name);
        fieldId.setAccessible(true);
        fieldId.set(model, id);
        fieldId.setAccessible(false);
    }

    private static void getFieldsValue(Model model) throws Exception {
        Field name = model.getClass().getField("name");
        Field id = model.getClass().getDeclaredField("id");

        System.out.println("name: " + name.get(model));
        id.setAccessible(true);
        System.out.println("id: " + id.get(model));
        id.setAccessible(false);
    }
}

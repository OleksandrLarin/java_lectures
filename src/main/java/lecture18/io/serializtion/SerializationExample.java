package lecture18.io.serializtion;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerializationExample {
    public static void main(String[] args) {
        Car nissan = new Car("SkyLine", "Nissan", 123);
        File carFile = new File("src//main//resources//car.dat");
        serialize(nissan, carFile);

        Car car = (Car) deserialization(carFile);

        System.out.println(car.toString());
    }

    private static Object deserialization(File file) {
        Object result = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            result = ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    private static void serialize(Object obj, File file) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
            oos.writeObject(obj);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

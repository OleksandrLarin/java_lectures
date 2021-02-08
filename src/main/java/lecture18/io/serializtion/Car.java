package lecture18.io.serializtion;

import java.io.Serializable;

public class Car implements Serializable {
    private String model;
    private String brand;
    private transient Integer id;

    public Car(String model, String brand, int id) {
        this.model = model;
        this.brand = brand;
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", brand='" + brand + '\'' +
                ", id=" + id +
                '}';
    }
}

package lecture1.generic.garage;

import java.util.ArrayList;
import java.util.List;


public class Garage<T extends Vehicle> {
    List<T> transport = new ArrayList<>();

    public T get(int i) {
        return transport.get(i);
    }

    public void add(T i) {
        transport.add(i);
    }

    public List<T> getByType(Class<? extends T> classType) {
        List<T> newArrayList = new ArrayList<>();

        for (T vehicle : transport) {
            if (classType.isInstance(vehicle)) {
                newArrayList.add(vehicle);
            }
        }
        return newArrayList;
    }

    public static void main(String[] args) {
        Garage<Car> carGarage = new Garage<>();
        Car vehicle = carGarage.get(0);

        Garage<Bus> busGarage = new Garage<>();
        Bus bus = busGarage.get(0);
        busGarage.add(new Bus());
//        busGarage.add(new Car());
    }
}

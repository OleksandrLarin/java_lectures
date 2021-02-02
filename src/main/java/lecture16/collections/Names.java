package lecture16.collections;

import java.util.TreeSet;

public class Names {
    public static void main(String[] args) {
        TreeSet<String> names = new TreeSet<>(new StringLengthComparator());
        names.add("Vlad");
        names.add("Serj");
        names.add("Boris");
        names.add("Iehor");

        for (String name : names) {
            System.out.println(name);
        }
    }
}

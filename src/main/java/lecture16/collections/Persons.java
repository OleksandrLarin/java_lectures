package lecture16.collections;

import java.util.TreeSet;

public class Persons {
    public static void main(String[] args) {
        TreeSet<Person> persons = new TreeSet<>(new PersonAgeComparator());
        persons.add(new Person(36));
        persons.add(new Person(16));
        System.out.println(persons);
    }
}

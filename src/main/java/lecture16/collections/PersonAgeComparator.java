package lecture16.collections;

import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person left, Person right) {
        return right.getAge() - left.getAge();
    }
}

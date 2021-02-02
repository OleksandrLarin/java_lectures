package lecture16.collections;

import java.util.Comparator;

public class StringLengthComparator implements Comparator<String> {

    @Override
    public int compare(String stringLeft, String stringRight) {
        return stringRight.length() - stringLeft.length();
    }
}

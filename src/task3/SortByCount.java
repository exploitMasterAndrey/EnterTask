package task3;

import java.util.Comparator;

public class SortByCount implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int o1Count = task3.getCount(o1);
        int o2Count = task3.getCount(o2);
        return o2Count - o1Count;
    }
}

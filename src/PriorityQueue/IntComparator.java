package PriorityQueue;

import java.util.Comparator;

public class IntComparator {
 
    public int compare(MyEntry o1, Object o2) {
        if((int) o1.getKey() - (int) o2 > 0) {
        	return 1;
        } else if((int) o1.getKey() - (int) o2 == 0) {
        	return 0;
        } else {
        	return -1;
        }
    }
}

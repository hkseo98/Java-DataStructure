package Sort;

import java.util.Comparator;

public class MyComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		
		if(o1 instanceof Integer) {
			if((int)o1 > (int)o2) {
				return 1;
			} else if((int)o1 == (int)o2) {
				return 0;
			} else {
				return -1;
			}
		} else {
			if(((String) o1).compareTo((String)o2) < 0) {
				return -1;
			} else if(((String) o1).compareTo((String)o2) == 0) {
				return 0;
			} else {
				return 1;
			}
		}
		
	}

}

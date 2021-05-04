package PriorityQueue;


public class PointComparator {
	
	public int compare(MyEntry o1, Object o2) {
		int n1 = ((int) o1.getKey() * (int) o1.getKey() + (int) o1.getValue() * (int) o1.getValue());
		o1.setValue(o1.getKey(), o1.getValue());
		o1.setKey((Object) n1);
		
		if(n1 - (int) o2 > 0) {
			return 1;
		} else if(n1 == (int) o2) {
			return 0;
		} else {
			return -1;
		}
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PointComparator pc = new PointComparator();
		MyPQ pq = new MyPQ(pc);
		
		pq.insert("a", 5, 4);
		pq.insert("b", 2, 7);
		pq.insert("c", 9, 5);
		pq.insert("d", 3, 1);
		pq.insert("e", 7, 2);
		pq.insert("f", 9, 7);
		pq.insert("g", 1, 4);
		pq.insert("h", 4, 3);
		pq.insert("i", 8, 2);
		pq.insert("j", 4, 8);
		
		System.out.println((String) pq.removeMin().getName());
		System.out.println((String) pq.removeMin().getName());
		System.out.println((String) pq.removeMin().getName());
		System.out.println((String) pq.removeMin().getName());
		System.out.println((String) pq.removeMin().getName());
		System.out.println((String) pq.removeMin().getName());
		System.out.println((String) pq.removeMin().getName());
		System.out.println((String) pq.removeMin().getName());
		System.out.println((String) pq.removeMin().getName());
		System.out.println((String) pq.removeMin().getName());
	}


}

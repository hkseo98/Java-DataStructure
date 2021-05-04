package PriorityQueue;

import java.util.ArrayList;
import java.util.Comparator;

public class MyPQ {
	private ArrayList list;
    private IntComparator cpt;
    private PointComparator pc;
    private PointComparator2 pc2;
    
    MyPQ(){
        this.list = null;
        this.cpt = null;
        this.pc = null;
    }
    
    MyPQ(IntComparator comp){
        this.list = new ArrayList();
        this.cpt = comp;
    }
    
    MyPQ(PointComparator comp){
        this.list = new ArrayList();
        this.pc = comp;
    }
    
    MyPQ(PointComparator2 comp){
        this.list = new ArrayList();
        this.pc2 = comp;
    }
    
    public int size() {
        return list.size();    
    }
    
    public boolean isEmpty() {
        return list.isEmpty();
    }
    
    public MyEntry insert(Object k, Object v) {
        
        MyEntry newEntry = new MyEntry(k, v);
        
        int where = 0;
        int len = list.size();
        
        for(int i=0; i<len; i++) {
            MyEntry temp = (MyEntry)list.get(i);
            if(this.cpt.compare(newEntry, temp.getKey()) > 0) {
                where++;
            }
        }
        
        list.add(where, newEntry);
        return newEntry;
    }
    
    public MyEntry insert(String a, Object k, Object v) {
    	
    	if(pc2 == null) {
    		MyEntry newEntry = new MyEntry(a, k, v);
            
            int where = 0;
            int len = list.size();
            
            for(int i=0; i<len; i++) {
                MyEntry temp = (MyEntry) list.get(i);
                if(this.pc.compare(newEntry, temp.getKey()) > 0) {
                    where++;
                }
            }
            
            list.add(where, newEntry);
            return newEntry;
    	} else {
    		MyEntry newEntry = new MyEntry(a, k, v);
            
            int where = 0;
            int len = list.size();
            
            for(int i=0; i<len; i++) {
                MyEntry temp = (MyEntry) list.get(i);
                if(this.pc2.compare(newEntry, temp.getKey()) > 0) {
                    where++;
                }
            }
            
            list.add(where, newEntry);
            return newEntry;
    	}
    	
    	
    }
    
    
    
    public MyEntry removeMin() {
        return (MyEntry)list.remove(0);
    }
    
    public MyEntry min() {
        return (MyEntry)list.get(0);
    }
    

    public static void main(String[] args) {
    	IntComparator c = new IntComparator();
    	MyPQ pq = new MyPQ(c);
    	
    	pq.insert(30, null);
    	pq.insert(10, null);
    	pq.insert(20, null);
    	
    	System.out.println((Integer)pq.removeMin().getKey());
    	System.out.println((Integer)pq.removeMin().getKey());
    	System.out.println((Integer)pq.removeMin().getKey());
    	
    }
}

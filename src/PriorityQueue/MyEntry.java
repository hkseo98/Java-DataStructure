package PriorityQueue;

public class MyEntry implements Entry {
    private Object key;
    private Object value;
    private String name;
    
    public MyEntry() {
        this.key = null;
        this.value = null;
        this.name = null;
    }
    
    public MyEntry(Object k, Object v) {
        this.key = k;
        this.value = v;
    }
    
    public MyEntry(String a, Object k, Object v) {
        this.key = k;
        this.value = v;
        this.name = a;
    }
    
    public void setKey(Object k) {
        this.key = k;
    }
    
    public void setValue(Object v) {
        this.value = v;
    }
    
    public void setValue(Object v, Object v2) {
    	int[] arr = new int[2];
    	arr[0] = (int) v;
    	arr[1] = (int) v2;
        this.value = arr;
    }
    
    public Object getKey() {
        return this.key;
    }
    
    public Object getValue() {
        return this.value;
    }
    
    public Object getName() {
    	return this.name;
    }
}

package Map;
import java.util.ArrayList;

public class MyHashTable {
	
	private ArrayList bucketArray;
	private int bucketCapacity;
	private int size = 0;
	private float loadFactor;
	
	MyHashTable(int initialCapacity) {
		this.bucketCapacity = initialCapacity;
		this.bucketArray = new ArrayList(initialCapacity);
		for(int i = 0; i < initialCapacity; i++) {
			this.bucketArray.add(null);
		}
	}
	
	MyHashTable(int initialCapacity, float loadFactor) { 
		this.bucketCapacity = initialCapacity;
		this.loadFactor = loadFactor;
	}
	
	private void rehash(int capacity) { 
		ArrayList newArr = new ArrayList(capacity);
		for(int i = 0; i < capacity; i++) {
			newArr.add(null);
		}
		int beforeCapacity = this.bucketCapacity;
		this.bucketCapacity = capacity;
		for(int i = 0; i < beforeCapacity; i++) {
			StudentInfo now = this.bucketArray.get(i) != null ? (StudentInfo) ((ArrayList) this.bucketArray.get(i)).get(0) : null;
			if(now != null) {
				int hash = this.hashFunc(now.getStudentID());
				ArrayList Arr = new ArrayList(this.bucketCapacity); 
	        	Arr.add(now);
				newArr.set(hash, Arr);
			}
		}
		this.bucketArray = newArr;
		getLoadFactor();
	}
	
	public float getLoadFactor() { 
		this.loadFactor =  this.size()/this.bucketCapacity;
		return loadFactor;
	}
	
	private int hashFunc(String k) {
		int hash = 0;
        for (int i = 0; i < k.length(); i++) {
            char val = k.charAt(i);
            hash = (hash + val*(i + 1)) % this.bucketCapacity;
        }
        return hash;
	}
	
	
	public int size() {
		return size;
	}
	
	public String get(String k) { 
		if (k != null) {
            int hash = hashFunc(k);
            return this.bucketArray.get(hash) != null ? ((StudentInfo) ((ArrayList) this.bucketArray.get(hash)).get(0)).getStudentName() : null;
        }
        return null;
	} 
	
	public String put(String k, String v) {
        int hash = hashFunc(k);
        if(this.bucketArray.get(hash) != null) {
        	Object std = new StudentInfo(k, v);
        	((ArrayList) this.bucketArray.get(hash)).add(std);
        	size++;
        	if(getLoadFactor() > 0.9) {
        		this.rehash(2 * this.bucketCapacity);
        	}
        } else {
        	Object std = new StudentInfo(k, v);
        	ArrayList Arr = new ArrayList(this.bucketCapacity); 
        	Arr.add(std);
        	this.bucketArray.set(hash, Arr);
            size++;
            getLoadFactor();
        	if(this.loadFactor > 0.9) {
        		this.rehash(2 * this.bucketCapacity);
        	}
        }
        return v;
	}
			
	public String remove(String k) { 
		String removed = null;
		int hash = hashFunc(k);
		if(this.bucketArray.get(hash) != null) {
			String removed1 = ((StudentInfo) ((ArrayList) this.bucketArray.get(hash)).get(0)).getStudentName();
			((ArrayList) this.bucketArray.get(hash)).remove(0);
        	if(getLoadFactor() > 0.9) {
        		this.rehash(2 * this.bucketCapacity);
        	}
			return removed1;
		}
		return null;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyHashTable hashTable = new MyHashTable(13);
		hashTable.put("201710019", "?????????");
		hashTable.put("201710043", "?????????");
		hashTable.put("201310119", "?????????");
		hashTable.put("201510231", "?????????");
		hashTable.put("201910002", "?????????");
		hashTable.put("202020038", "?????????");
		hashTable.put("201610213", "?????????");
		hashTable.put("201910311", "?????????");
		hashTable.put("202110041", "?????????");
		hashTable.put("201310024", "?????????");
		hashTable.put("201420024", "?????????");
		hashTable.put("201610024", "?????????");
		hashTable.put("201230544", "?????????");
		hashTable.put("201010187", "?????????");
		hashTable.put("201510371", "?????????");
		
		System.out.println(hashTable.get("201710043"));
		System.out.println(hashTable.size());
	}

}

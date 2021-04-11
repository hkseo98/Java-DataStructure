package ListAndIterator;

public class MyArrayList {
	private int size = 0;
	int arrSize = 100;
	
    private Object[] elementData = new Object[arrSize];
 
     
    public boolean addLast(Object element) {
    	if (size > arrSize) {
        	System.out.println("size over!!");
        	return false;
    	} else {
        elementData[size] = element;
        size++;
        return true;
    	}
    }
     
    public boolean add(int index, Object element) {
    	if (size > arrSize) {
        	System.out.println("size over!!");
        	return false;
        } else {
        for (int i = size - 1; i >= index; i--) {
            elementData[i + 1] = elementData[i];
        }
        elementData[index] = element;
        size++;
        return true;
        }
    }
     
    public boolean addFirst(Object element){
        return add(0, element);
    }
 
     
    public Object remove(int index) {
    	if (size <= 0) {
        	return "empty";
        } else {
        Object removed = elementData[index];
        for (int i = index + 1; i <= size - 1; i++) {
            elementData[i - 1] = elementData[i];
        }
        size--;
        elementData[size] = null;
        return removed;
        }
    }   
     
    public Object removeFirst(){
    	if (size <= 0) {
        	return "empty";
        } else {
        return remove(0);
        }
    }
 
    public Object removeLast(){
    	if (size <= 0) {
        	return "empty";
        } else {
        return remove(size-1);
        }
    }
 
    public Object get(int index) {
        return elementData[index];
    }
 
    public Object set(int index, Object element) {
    	Object replaced = elementData[index];
    	elementData[index] = element;
    	return replaced;
    }
    
    public int size() {
        return size;
    }
    
    public boolean isEmpty() {
    	if (size == 0) {
    		return true;
    	} else {
    		return false;
    	}
    }
    
    
 
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elementData[i])) {
                return i;
            }
        }
        return -1;
    }
}
    

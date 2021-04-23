package Tree;

import java.util.ArrayList;

 
public class MyTree {
    
    private MyNode root;
    private int totalSize;
    private int maxHeight;
    
    public MyTree() {
        this.root = null;
        this.maxHeight = 100;
        this.totalSize = 0;        
    }
    
    public MyTree(String name, int value) {        
        this.root = new MyNode(name, value);                    
        this.totalSize = 1;
    }
    
    public int size() {
        return this.totalSize;
    }
    
    public MyNode root() {
        return this.root;
    }
    
    public MyNode parent(MyNode v) {
        return v.parent();
    }
    
    
    public int degree(MyNode v) {
        return v.children().size();
    }
    
    public ArrayList children(MyNode v) {
        return v.children();
    }
    
    public boolean isExternal(MyNode v) {
        return v.children().isEmpty();
    }
    
    public boolean isInternal(MyNode v) {
        return !v.children().isEmpty();
    }
    
    public boolean isRoot(MyNode v) {
        return this.root == v;
    }
    
    public void replace(MyNode v, String name, int value) {
    	v.setName(name);
    	v.setValue(value);
    }
    
    public MyNode addRoot(String name, int value) {
        MyNode temp = this.root;
        this.root = new MyNode(name, value);            
        this.totalSize = 1;
        return temp;        
    }
    
    public MyNode addNode(String name, int value) {
        MyNode newNode = new MyNode(name, value);        
        newNode.setParent(this.root);
        newNode.setHeght(this.root.height()+1);
        this.root.children().add(newNode);        
        this.totalSize++;
        return newNode;
    }
    
    public MyNode addChild(MyNode v, String name, int value) {
        MyNode newNode = new MyNode(name, value);    
        newNode.setParent(v);
        newNode.setHeght(v.height()+1);
        v.children().add(newNode);
        this.totalSize++;
        return newNode;
    }
    
    public MyNode addChild(MyNode v, int i, String name, int value) {
        MyNode newNode = new MyNode(name, value);        
        newNode.setParent(v);
        newNode.setHeght(v.height()+1);
        v.children().add(i, newNode);
        this.totalSize++;
        return newNode;
    }
    
    public MyNode setChild(MyNode v, int i, String name, int value) {
        MyNode newNode = new MyNode(name, value);        
        newNode.setParent(v);
        v.children().set(i, newNode);
        return newNode;
    }
    
    public MyNode removeChild(MyNode v, int i) {
        this.totalSize--;
        return (MyNode)v.children().remove(i);
    }
    
    
    public int getDistance(MyNode a) {
    	int h = a.height();
    	int res = a.value();
    	int i = 0;
    	while(i < h) {
    		res += a.parent().value();
    		a = a.parent();
    		i += 1;
    	}
    	return res;
    }


}
 


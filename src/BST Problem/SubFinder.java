package Problem1;

import java.util.ArrayList;


public class SubFinder extends MyNode {
	
	ArrayList<MyBinNode> inorderNodes = new ArrayList<MyBinNode>();
	ArrayList<MyBinNode> targetNodes = new ArrayList<MyBinNode>();
    // proove yourself
    
    public int subfind(MyBinNode target, MyBinNode sub) {
    	ArrayList<MyBinNode> targetNodes = this.search(target, sub);
    	
    	for (MyBinNode tn : targetNodes) {
    		if(this.compare(tn, sub)) {
    			this.makeInorderNodes(target); // 
    			return this.getNum(tn); // 속한다면 루트노트의 순서 가져오기.
    		}; // 각 노드를 비교하여 sub트리가 target 트리에 속하는지 확인하기. 
    	}
    	
    	return 0;
    }
 
    // 타겟 트리에서 서브 트리의 루트를 찾음. 
    public ArrayList<MyBinNode> search(MyBinNode target, MyBinNode root) {
    	
    	if(target.element() == root.element()) {
    		targetNodes.add(target);
    	}
    	if(target.left() != null) {
    		this.search(target.left(), root);
    	} 
    	if(target.right() != null) {
    		this.search(target.right(), root);
    	} 
    	
    	return targetNodes;
    }
    
    public boolean compare(MyBinNode tn, MyBinNode sub) {
    	if (tn.element() == sub.element()) {
    		if(tn.left() != null && sub.left() != null) {
    			return this.compare(tn.left(), sub.left());
    		} else if (tn.left() == null && sub.left() != null){
    			return false;
    		}
    		if(tn.right() != null && sub.right() != null) {
    			return this.compare(tn.right(), sub.right());
    		} else if (tn.right() == null && sub.right() != null){
    			return false;
    		}
    	} else { 
    		return false;
    	}
    	return true;
    }
    
    public void makeInorderNodes(MyBinNode target) {
    	 if(target.left() != null) {
    		 makeInorderNodes(target.left());
         }
                     
         inorderNodes.add(target);
         
         if(target.right() != null) {
        	 makeInorderNodes(target.right());
         }
    }
    
    public int getNum(MyBinNode tn) {
    	int i = 1;
    	for (MyBinNode n : inorderNodes) {
    		if (n != tn) {
    			i++;
    		} else {
    			return i;
    		}
    	}
    	return -1;
    }
}
 
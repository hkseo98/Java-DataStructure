package Sort;

import java.util.ArrayList; 
import java.util.Comparator;
import java.util.Random;
import java.lang.Math;

public class MyMergeSort {
	private ArrayList L1; 
	private ArrayList L2; 
	private MyComparator comp;
	
	MyMergeSort(MyComparator c) {
		this.comp = (MyComparator) c;
	}
	
	
	public ArrayList sort(ArrayList l) {
		L2 = l;
		L1 = new ArrayList(l.size());
		ArrayList result = sort(0, l.size() - 1);
		L1 = null;
		L2 = null;
		return result;
	}
	
	
	public ArrayList sort(int left, int right) {
		for(int size = 1; size <= right; size += size) {
			for(int i= 0; i <= right - size; i += (2 * size)) {
				int low = i;
				int mid = i + size - 1;
				int high = Math.min(i + (2 * size) - 1, right);
				merge(low, mid, high);		// 병합작업
			}
		}
		return L2;
	}
	
	
	public void merge(int left, int mid, int right) {
		int l = left;		// 왼쪽 부분리스트 시작점
		int r = mid + 1;	// 오른쪽 부분리스트의 시작점 
		int idx = left;		// 채워넣을 배열의 인덱스
		
			while(l <= mid && r <= right) {
		
				if(this.comp.compare(L2.get(l), L2.get(r)) < 1) {
					if(L1.size() <= idx) {
						L1.add(L2.get(l));
					} else {
						L1.set(idx, L2.get(l));
					}
					idx++;
					l++;
				}
	
				else {
					if(L1.size() <= idx) {
						L1.add(L2.get(r));
					} else {
						L1.set(idx, L2.get(r));
					}
					idx++;
					r++;
				}
			}
		

			if(l > mid) {
				while(r <= right) {
					if(L1.size() <= idx) {
						L1.add(L2.get(r));
					} else {
						L1.set(idx, L2.get(r));
					}
					idx++;
					r++;
				}
			}
			
			else {
				while(l <= mid) {
					if(L1.size() <= idx) {
						L1.add(L2.get(l));
					} else {
						L1.set(idx, L2.get(l));
					}
					idx++;
					l++;
				}
			}
		
		for(int i = 0; i < L1.size(); i++) {
			L2.set(i, L1.get(i));
		}
	}
	

		
	
	public MyComparator setComparator(MyComparator c) {
		this.comp = (MyComparator) c;
		return c;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyComparator comp = new MyComparator();
		MyMergeSort mysort = new MyMergeSort(comp);
		Random random = new Random();
		
		// 문제 1) 랜덤 정수 정 
		ArrayList l = new ArrayList(20);
		
	    for(int i=0; i < 20; i++) {
	    	l.add(random.nextInt(100));
	    }
	    System.out.println("전:" + l);
		l = mysort.sort(l);
		System.out.println("후:" + l);
		
		System.out.println();
		System.out.println();
		 
		// 문제 2) 랜덤 정수 정 
		 ArrayList text = new ArrayList(47);
		 String texts = "In computer science, a data structure is a data organization, management, and storage format that enables efficient access and modification. More precisely, a data structure is a collection of data values, the relationships among them, and the functions or operations that can be applied to the data.";
		 String[] arr = texts.split(" ");
		 for(String t : arr) {
			 text.add(t.toLowerCase());
		 }
		 System.out.println("전:" + text);
		 text = mysort.sort(text);
		 System.out.println("전:" + text);

	}

}

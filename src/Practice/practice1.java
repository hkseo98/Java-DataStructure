package Practice;

import java.util.Arrays;
import java.util.Scanner;
import java.math.*;

public class practice1 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println(Power(5, 16));
		
		int[] A = new int[101];
		for (int i = 1; i < 101; i++) {
			A[i]=i;
		}

		System.out.println(BinarySum(A, 1, 100));
		
		
		for (int i =0; i<100; i++) {
			System.out.println(LinearFib(i)[0]);
		}
	}
	
	public static long Power(int x, int n) {
		if (n == 0) {
			return 1;
		}
		else if (n % 2 == 1) {
			long y = (long) Power(x, (n-1)/2);
			return x * y * y;
		}
		else {
			long y = (long) Power(x, n/2);
			return y * y;
		}
	}
	
	public static int BinarySum(int[] A, int i, int n) {
		if (n == 1) {
			return A[i];
		} else { 
			return BinarySum(A, i, n/2) + BinarySum(A, i + n/2, n/2);
		}
	}
	
	public static long[] LinearFib(int n) {
	    if(n<=1) {
	        long[] answer = {n,0};
	        return answer;
	    }else {
	        long[] temp = LinearFib(n-1);               
	        long[] answer = {temp[0]+temp[1], temp[0]};    
	        return answer;
	    }
	}

}

package ds222rr_assign1;

public class SumMain {
	public static void main(String[] args) {
		int n = 100;					
		int sum = ArithmSumRec(n);		// Calculate the sum up to n
		System.out.print(sum);
	}
	
	public static int ArithmSumRec(int num) {	// Recursive method
		if (num == 0 ||num == 1) {				// Base cases
			return num;
		}			
		else {
			return  // The sum from 1 to n/2
					(ArithmSumRec((num/2)-1)) + num/2 + 
					// The sum from n/2+1 to n
					(ArithmSumRec(num-1)-(ArithmSumRec(num/2-1)+num/2)) + num;
		}
	}
}

package _2;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("메인");
		int[] arr = new int[100];
		
		//An = An-1 + An-2; n>=3
		//a1 = 1, a2 = 1
		arr[0] = 1;
		arr[1] = 1;
		
		for(int i=2; i<100; i++) {
			int tempNum = 0;
			
			tempNum = arr[i-1] + arr[i-2];
			arr[i] = tempNum;
			System.out.println(arr[i]);
		}
		
		
	}

}

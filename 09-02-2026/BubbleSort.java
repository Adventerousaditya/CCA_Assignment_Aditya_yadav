package demo;

public class BubbleSort {
	public static void main(String[] args) {
		int [] arr = {1,2,3,4,5,10,7,8,0};
		int n = arr.length;
		for(int i = 0; i<n ; i++) {
			for(int j = 0 ; j<n-i-1 ; j++) {
				if(arr[j]>arr[j+1]) {
					int temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(int x: arr) {
			System.out.print(x + " " );
		}
	}
}

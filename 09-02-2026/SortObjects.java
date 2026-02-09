package demo;
class Student4{
	int roll;
	String name;
	Student4(int roll , String name){
		this.roll = roll;
		this.name = name;
	}
}
public class SortObjects {
	public static void main(String[] args) {
		Student4 s1 = new Student4(1,"A");
		Student4 s2 = new Student4(5,"B");
		Student4 s3 = new Student4(3,"C");
		Student4 s4 = new Student4(4,"D");
		Student4 [] arr = {s1 , s2 , s3 , s4};
		int n = arr.length;
		for(int i = 0; i<n ; i++) {
			for(int j = 0 ; j<n-i-1 ; j++) {
				if(arr[j].roll>arr[j+1].roll) {
					Student4 temp = arr[j+1];
					arr[j+1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		for(Student4 x: arr) {
			System.out.println(x.roll + " " + x.name);
		}
	}
}

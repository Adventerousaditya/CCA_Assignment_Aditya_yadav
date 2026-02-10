package Capgg;
class Student14 {
    String name;
    int roll;
    Student14(String name, int roll) {
        this.name = name;
        this.roll = roll;
    }
}
public class InsertionSort2 {
    public static void main(String[] args) {
        Student14[] students = {
            new Student14("Abc", 7),
            new Student14("Def", 5),
            new Student14("Rtg", 18),
            new Student14("Cde", 1),
            new Student14("Ake", 2),
            new Student14("Frg", 13)
        };
        for (int i = 1; i < students.length; i++) {
            Student14 key = students[i];
            int j = i - 1;
            while (j >= 0 && students[j].roll > key.roll) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }
        System.out.println("Students sorted by roll number:");
        for (Student14 s : students) {
            System.out.println(s.roll + " " + s.name);
        }
    }
}

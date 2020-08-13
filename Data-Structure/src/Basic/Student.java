package Basic;

public class Student {

    private String name;
    private int score;

    public Student(String student_name, int student_score){
        name = student_name;
        score = student_score;
    }

    @Override
    public String toString() {
        return String.format("Student(name: %s, score: %d)", name, score);
    }

    public static void main(String[] args) {
        Array<Student> arr = new Array<>();
        arr.addLast(new Student("Alice", 98));
        arr.addLast(new Student("Bob", 88));
        arr.addLast(new Student("Charlie", 72));

        System.out.println(arr);
    }
}


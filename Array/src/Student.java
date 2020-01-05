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
}


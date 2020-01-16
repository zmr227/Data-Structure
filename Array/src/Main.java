public class Main {

    public static void main(String[] args) {
//	    // allocate space with "new" keyword, have to specify the size/capacity when create an array
//        int[] arr = new int[10];
//        for(int i = 0; i < arr.length; i++){
//            arr[i] = i;
//        }
//
//        int[] scores = {100, 98, 73};
//        for(int i = 0; i < scores.length; i++){
//            System.out.println(scores[i]);
//        }
//
//        scores[0] = 94;
//        for(int score : scores){
//            System.out.println(score);
//        }

        MyArray<Integer> my_arr = new MyArray<>(3);

        for(int i = 0; i < 5; i++){
            my_arr.addLast(i);
        }

        my_arr.insert(2, 96);
        System.out.println(my_arr.contains(4));

        System.out.println(my_arr);

        for(int i = 0; i < 4; i++){
            my_arr.removeFirst();
        }

        System.out.println(my_arr);

//        MyArray<Student> students = new MyArray<>(10);
//        students.addLast(new Student("Alice", 98));
//        students.addLast(new Student("Bob", 77));
//        students.addLast(new Student("Charlie", 85));
//
//        System.out.println(students);
    }
}

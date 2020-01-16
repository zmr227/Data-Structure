public class Main {

    public static void main(String[] args) {

        // test for myQueue
        LoopQueue<Integer> queue = new LoopQueue<>();
        for(int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i % 3 == 2) {
                queue.dequeue();
                //System.out.println(queue.toString());
            }
            System.out.println(queue.toString());
        }
        System.out.println(queue.toString());

        System.out.println(queue.getCapacity());
        System.out.println(queue.getSize());
        System.out.println(queue.getFirst());


        // test for myStack
//        MyStack<Integer> stack = new MyStack<>();
//        for(int i = 0; i < 6; i++){
//            stack.push(i);
//        }
//        stack.pop();
//        System.out.println(stack.toString());
//        System.out.println(stack.getCapacity());
//        System.out.println(stack.getSize());
//        System.out.println(stack.peek());
    }
}

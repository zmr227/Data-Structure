package Basic;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int opCount = 100000;

        // dequeue() is O(1)
        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time1 = testQueue(loopQueue, opCount);
        System.out.println("Loop Queue Time " + time1 + " s");

        // dequeue() is O(n), when opCount is very large, might become O(n^2) level time.
        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time2 = testQueue(arrayQueue, opCount);
        System.out.println("Array Queue Time " + time2 + " s");

        LinkedListQueue<Integer> linkedListQueue = new LinkedListQueue<>();
        double time3 = testQueue(linkedListQueue, opCount);
        System.out.println("Linked List Queue Time " + time3 + " s");

        // contains more create new object(Node) operation, which might be slower than arrayStack in some system.
        LinkedListStack<Integer> linkedListStack = new LinkedListStack<>();
        double time4 = testStack(linkedListStack, opCount);
        System.out.println("Linked List Stack Time " + time4 + " s");

        // resize will cost extra time
        ArrayStack<Integer> arrayStack = new ArrayStack<>();
        double time5 = testStack(arrayStack, opCount);
        System.out.println("Array Stack time: " + time5 + " s");
    }

    // 这种测试方法可能收到当前计算机状态影响，比如正在运行其他很多程序，所以更严谨的做法应该是多运行几次取平均值。
    // java语言不同版本的编译优化方式不同，运行时间可能也有不同。
    private static double testQueue(Queue<Integer> q, int opCount) {
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < opCount; i++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            q.dequeue();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }

    private static double testStack(Stack<Integer> s, int opCount) {
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < opCount; i++) {
            s.push(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < opCount; i++) {
            s.pop();
        }
        long endTime = System.nanoTime();
        return (endTime - startTime) / 1000000000.0;
    }
}

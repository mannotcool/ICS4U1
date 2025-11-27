public class StaticQueueTest {
    // demonstates the StaticQueue class by enqueuing and dequeuing a series of integers
    public static void main(String[] args) {
        StaticQueue<Integer> queue = new StaticQueue<>(6);

        System.out.println("queueing 1 to 6");
        for (int i = 1; i <= 6; i++) {
            queue.enqueue(i);
            System.out.println(queue.toString());
        }

        System.out.println("dequeuing all elements");
        while (!queue.isEmpty()) {
            Integer value = queue.dequeue();
            System.out.println("Dequeued: " + value);
            System.out.println(queue.toString());
        }


        System.out.println("Peek: " + queue.peek());
        System.out.println("Is Empty: " + queue.isEmpty());
        System.out.println("Size: " + queue.size());
        System.out.println("Clearing queue");
        queue.clear();
        System.out.println(queue.toString());


    }

}

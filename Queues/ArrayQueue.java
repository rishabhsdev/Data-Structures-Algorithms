package DataStructures.Queues;

public class ArrayQueue {

    public int[] queue = new int[5];

    int front = 0;
    int rear = -1;

    public void add(int value) {
        rear++;
        if (rear > queue.length - 1) {
            if (queue[0] == 0) {
                rear = 0;
            } else {
                System.out.println("Queue is full");
                return;
            }
        } else if (rear == front && front != 0) {
            System.out.println("Queue is full");
            return;
        }

        queue[rear] = value;

    }

    public void remove() {
        if (front > queue.length - 1) {
            front = 0;
        }
        queue[front] = 0;
        front++;
    }

    public int peek() {
        return queue[front];
    }
}

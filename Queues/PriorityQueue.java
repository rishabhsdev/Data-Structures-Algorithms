package DataStructures.Queues;

public class PriorityQueue {

    public int[] queue = new int[5];

    int front = 0;
    int rear = 0;

    public void add(int value) {
        if (front == 0 && rear == 0) {
            queue[0] = value;

        }

        if (!checkCapacity()) {
            System.out.println("Queue is full");
            return;
        }

        for (int i = rear - 1; i >= 0; i--) {
            if (value < queue[i]) {
                queue[i + 1] = queue[i];
                queue[i] = value;
            } else {
                queue[i + 1] = value;
            }
        }

        rear++;

    }

    public Boolean checkCapacity() {
        if (rear > queue.length - 1) {
            if (queue[0] == 0) {
                rear = 0;
            } else {
                return false;
            }
        } else if (rear == front && front != 0) {
            return false;
        }

        return true;
    }
}

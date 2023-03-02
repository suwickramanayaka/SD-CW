package TASK3;

public class Queue {
    private int size, front, rear;
    private task3Passenger[] queue = new task3Passenger[12];

    Queue(int size) {
        this.size = size;
        this.front = this.rear = -1;
    }

    public task3Passenger[] getQueue() {
        return queue;
    }

    public void enQueue(task3Passenger passenger) {

        if ((front == 0 && rear == size - 1) || (rear == (front - 1) % (size - 1))) {
            System.out.print("Waiting list is Full. Sorry! We cannot add anymore passengers to the waiting list.");
        }

        else if (front == -1) {
            front = 0;
            rear = 0;
            queue[rear] = passenger;
        } else if (rear == size - 1 && front != 0) {
            rear = 0;
            queue[rear] = passenger;
        } else {
            rear = (rear + 1);

            if (front <= rear) {
                queue[rear] = passenger;
            }

            else {
                queue[rear] = passenger;
            }
        }
    }

    public task3Passenger deQueue() {
        task3Passenger deQueuedPassenger;

        if (front == -1) {
            return null;
        }

        deQueuedPassenger = queue[front];

        if (front == rear) {
            front = -1;
            rear = -1;
        } else if (front == size - 1) {
            front = 0;
        } else {
            front += 1;
        }

        return deQueuedPassenger;
    }
}

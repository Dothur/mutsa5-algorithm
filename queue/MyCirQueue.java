package queue;

public class MyCirQueue {
    private final int size = 4;
    private final int[] arr = new int[size + 1];
    private int front = 0;
    private int rear = 0;

    public MyCirQueue(){}

    // 데이터 추가
    public void enQueue(int x){
        // 다음에 데이터가 들어가는 곳 : (rear + 1) % (size + 1)
        // 다음에 데이터가 나올 곳과 일치하는 경우 full
        if ((rear + 1) % (size + 1) == front){
            throw new RuntimeException("Queue is full");
        }
        rear = (rear + 1) % (size + 1);
        arr[rear] = x;
    }

    // 데이터 회수
    public int deQueue(){
        if (front == rear) {
            throw new RuntimeException("Queue is empty");
        }
        front = (front + 1) % (size + 1);
        return arr[front];
    }

    public boolean isEmpty() {
        return front == rear;
    }

    public static void main(String[] args) {
        MyCirQueue queue = new MyCirQueue();
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
        queue.enQueue(4);
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        System.out.println(queue.deQueue());
        queue.enQueue(5);
        System.out.println(queue.deQueue());
    }
}

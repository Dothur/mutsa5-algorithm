package queue;

import java.util.LinkedList;
import java.util.Queue;

public class JavaQueue {
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        // enqueue
        // offer, add - enqueue 메소드
        // queue 가 가득 차있다면
        // offer - false 를 발환
        // add - 예외 발생
        queue.offer(1);
        queue.add(2);

        // dequeue
        // remove, poll - dequeue 메소드
        // queue 가 비어있다면
        // poll - null
        // remove - 예외 발생
        System.out.println(queue.remove());
        System.out.println(queue.poll());

        // peek
        // element, peek - peek 메소드
        // queue 가 비어있다면
        // peek - null
        // element - 예외 발생
        System.out.println(queue.peek());
        System.out.println(queue.element());
    }
}

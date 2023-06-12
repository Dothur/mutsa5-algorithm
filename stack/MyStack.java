package stack;

public class MyStack {
    // 스택에 실제 데이터가 저장되는 곳
    private final int[] arr = new int[16];

    // 현재 스택의 최고점을 파악하기 위한 top
    private int top = -1;

    public MyStack(){}

    // push : 데이터를 스택의 제일 위에 넣는 메소드
    public void push(int data){
        // 0. arr가 가득 찼는지 판단한다.
        // 1. top을 하나 증가시킨다.
        // 2. arr[top]에 data를 할당한다.
        if (arr.length - 1 == top){
            throw new RuntimeException("stack is full");
        }
        arr[++top] = data;
    }

    // pop : 데이터를 스택의 제일 위에서 회수하는 메소드
    public int pop(){
        // 0. arr가 비어있는지 판단한다.
        // 1. arr[top]의 값을 임시 저장한다.
        // 2. top의 값을 하나 감소한다.
        // 3. 임시 저장했던 값을 반환한다.
        if (isEmpty()){
            throw new RuntimeException("stack is empty");
        }
//        int temp = arr[top];
//        top--;
        return arr[top--];
    }

    // peek : 스택의 제일 위의 값을 반환한다. (제거 x)
    public int peek(){
        // 0. arr가 비어있는지 판단한다.
        // 1. arr[top] 을 반환한다.
        if (isEmpty()){
            throw new RuntimeException("stack is empty");
        }
        return arr[top];
    }

    // empty : 스택이 비어있는지의 여부를 반환하는 메소드
    public boolean isEmpty(){
        // 0. top 이 -1 일때 스택은 비어있다.
        return top == -1;
    }

    public static void main(String[] args) {
        // 스택에 3개의 데이터를 넣었다가 빼보기
        MyStack intStack = new MyStack();
        intStack.push(3);
        intStack.push(5);
        intStack.push(7);
        System.out.println(intStack.pop());
        System.out.println(intStack.pop());
        System.out.println(intStack.isEmpty());
        System.out.println(intStack.peek());

        System.out.println(intStack.pop());
        System.out.println(intStack.isEmpty());
        System.out.println(intStack.peek());
    }
}

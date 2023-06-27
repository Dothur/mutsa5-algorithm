package graph;

public class Programmers43165 {
    // 재귀함수 DFS 를 할 예정이라, 정답을 클래스 단위에서 관리
    private int answer = 0;

    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, target, 0);
        return answer;
    }

    // 재귀함수 DFS
    public void dfs(
            // 내가 사용할 숫자들을 담기위한
            int[] numbers,
            // 내가 다음에 사용할 차례의 숫자
            // 이번 DFS 호출에서 더하거나 빼거나 할 숫자는 Numbers[next]
            int next,
            // 목표 값
            int target,
            // 이번 재귀까지 합한 값
            int sum
    ) {
        // 어느 시점에 멈출까?
        // 마지막 숫자를 쓴 시점에 next 는 배열의 크기와 동일해진다.
        if (next == numbers.length) {
            // 정답인지 아닌지? target 과 일치하는지 확인
            if (sum == target) this.answer++;
        } else {
            // 더한 다음 다음숫자 결정
            dfs(numbers, next + 1, target, sum + numbers[next]);
            // 뺀 다음 다음숫자 결정
            dfs(numbers, next + 1, target, sum - numbers[next]);
        }
    }
//
//    public static void main(String[] args) {
//        new Programmers43165().solution(new int[]{1, 1, 1, 1, 1}, 3);
//    }
}

package sort;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {25, 12, 18, 24, 2, 21};
        int n = arr.length;

        // 제일 작은 원소를 찾아서 앞으로 가져오기.
        for (int i = 0; i < n - 1; i++) { // i의 값이 총 정렬된 원소의 갯수
            // 맨 처음 시작할때 제일 앞에 숫자가 현재 제일 작다고 설정하고 시작
            int minIndex = i;
            // i + 1 부터 끝 원소 까지 차근차근 비교
            for (int j = i + 1; j < n; j++) {
                // 제일 작은 숫자를 찾는다
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // 제일 앞의 원소와 제일 작은 원소를 교환한다
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}

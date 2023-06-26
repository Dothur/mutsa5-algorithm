package graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class RecursiveDFS {
    public void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer graphTokenizer = new StringTokenizer(br.readLine());

        int maxNodes = Integer.parseInt(graphTokenizer.nextToken()); // 8
        int edges = Integer.parseInt(graphTokenizer.nextToken()); // 10

        // 인접 행렬 : 2차원 배열
        // 만약 노드가 1부터 N + 1 까지라면
        // 계산할 때 매번 -1 을 해주거나
        // 인접 행렬을 한칸 더 늘리거나
        int[][] adjMatrix = new int[maxNodes][maxNodes]; // 0 ~ 7 까지 표현 가능한 인접행렬
        // 간선의 갯수만큼 반복해서 입력을 받는다
        for (int i = 0; i < edges; i++) {
            StringTokenizer edgeTokenizer = new StringTokenizer(br.readLine());

            int startNode = Integer.parseInt(edgeTokenizer.nextToken());
            int endNode = Integer.parseInt(edgeTokenizer.nextToken());

            // 유향 그래프의 경우 아래줄 만
            adjMatrix[startNode][endNode] = 1;
            // 무향 그래프의 경우 아래줄도 함께
            adjMatrix[endNode][startNode] = 1;
        }

//        for (int[] row : adjMatrix){
//            System.out.println(Arrays.toString(row));
//        }
        boolean[] visited = new boolean[maxNodes];
        List<Integer> visitedOrder = new ArrayList<>();

        recursive(0, maxNodes, adjMatrix, visited, visitedOrder);
        System.out.println(visitedOrder);
    }

    // 목적 : dfs 를 했을 때 정점 방문 순서 기록
    public void recursive(
            // 다음 (이번 호출) 에서 방문할 곳
            int next,
            // 원활한 순회를 위한 maxNodes
            int maxNodes,
            // 인접 정점 정보 (그래프 정보)
            int[][] adjMatrix,
            // 여태까지 방문한 정점 정보
            boolean[] visited,
            // 요부분은 구하고자 하는 목적에 따라 다릅니다.
            // 방문 순서 기록을 위한 리스트
            List<Integer> visitOrder
    ) {
        visited[next] = true;
        visitOrder.add(next);
        // 반복문에서 재귀호출 한다.
        for (int i = 0; i < maxNodes; i++) {
            // 연결이 되어있으며, 방문한적 없을 때
            if (adjMatrix[next][i] == 1 && !visited[i]) {
                recursive(i, maxNodes, adjMatrix, visited, visitOrder);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new RecursiveDFS().solution();
    }
}

/* // 정점의 갯수,  간선의 갯수
8 10
0 1
0 2
0 3
1 3
1 4
2 5
3 4
4 7
5 6
6 7
 */
// 10개의 줄에 걸쳐서 간선이 연결한 정점들
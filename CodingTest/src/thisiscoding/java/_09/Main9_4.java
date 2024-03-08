package thisiscoding.java._09;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 미래 도시
 * 입력1)
    5 7
    1 2
    1 3
    1 4
    2 4
    3 4
    3 5
    4 5
    4 5
    출력1) 3
    입력2)
    4 2
    1 3
    2 4
    3 4
    출력2) -1
 */
public class Main9_4 {
    public static final int INF = (int) 1e9; // 무한을 의미하는 값으로 10억을 설정
    // 노드의 개수(N), 간선의 개수(M), 경유 노드(K), 최종 목적지 노드(X)
    public static int n, m, x, k;
    // 2차원 배열(그래프 표현)를 만들기
    public static int[][] graph = new int[101][101];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        // 최단 거리 테이블을 모두 무한으로 초기화
        for (int i=0; i<101; i++) {
            Arrays.fill(graph[i], INF);
        }

        // 자기 자신으로 가는 비용 0으로 초기화
        for(int a=1; a<=n; a++) {
            for(int b=1; b<=n; b++) {
                if(a==b) graph[a][b] = 0;
            }
        }

        //각 간선에 대한 정보를 입력 받아, 그 값으로 초기화
        // A와 B가 서로에게 가는 비용은 1이라고 설정
        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a][b] = 1;
            graph[b][a] = 1;
        }

        //목적지
        x = sc.nextInt();
        k = sc.nextInt();

        //점화식에 따른 플로이드 워셜 알고리즘 수행
        for(int k=1; k <=n; k++) {
            for(int a=1; a<=n; a++) {
                for(int b=1; b<=n; b++) {
                    graph[a][b] = Math.min(graph[a][b], graph[a][k] + graph[k][b]);
                }
            }
        }
        
        //수핸된 결과를 출력 시작점 (1) -> 경유지 (k) -> 도착지 (x)
        int distance = graph[1][k] + graph[k][x];
        
        if(distance >= INF) {
            System.out.println("-1");
        } else {
            System.out.println("distance = " + distance);
        }
    }
}

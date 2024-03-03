package thisiscoding.java._09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 개선된 다익스트라 알고리즘
 * 입력)
 * 6 11
 * 1
 * 1 2 2
 * 1 3 5
 * 1 4 1
 * 2 3 3
 * 2 4 2
 * 3 2 3
 * 3 6 5
 * 4 3 3
 * 4 5 1
 * 5 3 1
 * 5 6 2
 */

public class Main9_2 {
    public static final int INF = (int) 1e9; //무한을 의미하는 값으로 10억을 설정 (초기값)
    //N: 노드의 개수, M: 간선의 개수, start: 시작 노드 번호
    public static int n, m, start;
    //각 노드에 연결되어 있는 노드에 대한 정보를 담는 배열
    public static ArrayList<ArrayList<Node>> graph = new ArrayList<ArrayList<Node>>();
    //최단 거리 테이블 (최대 100,000개라고 가정)
    public static int[] d = new int[100001];

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        // 시작 노드로 가기 위한 최단 경로는 0으로 설정하여, 큐에 삽입
        pq.offer(new Node(start, 0));
        d[start] = 0;

        while(!pq.isEmpty()) {
            //가장 거리가 짧은 노드에 대한 정보 꺼내기
            Node node = pq.poll();
            int dist = node.getDistance(); // 현재 노드까지의 비용
            int now = node.getIndex(); //현재 노드
            // 현재 노드가 이미 처리된 적이 있는 노드라면 무시
            if(d[now] < dist) continue;
            // 현재 노드와 연결된 다른 인접한 노드들을 확인
            for(int i=0; i<graph.get(now).size(); i++) {
                int cost = d[now] + graph.get(now).get(i).getDistance();
                // 현재 노드를 거쳐서, 다른 노드로 이동하는 거리가 더 짧은 경우
                if (cost < d[graph.get(now).get(i).getIndex()]) {
                    d[graph.get(now).get(i).getIndex()] = cost;
                    pq.offer(new Node(graph.get(now).get(i).getIndex(), cost));
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();
        start = sc.nextInt();

        // 그래프 초기화
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<Node>());
        }

        for(int i=0; i<m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            // a번 노드에서 b번 노드로 가는 비용이 c라는 의미
            graph.get(a).add(new Node(b, c));
        }

        //최단 거리 테이블을 모두 무한으로 초기화
        Arrays.fill(d, INF);

        dijkstra(start);

        // 모든 노드로 가기 위한 최단 거리를 출력
        for (int i=1; i<=n; i++) {
            if(d[i] == INF) {
                System.out.println("INFINITY");
            } else {
                System.out.println("d[" +i +"] " + d[i]);
            }
        }



    }
}

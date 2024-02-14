package thisiscoding.java._05;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 미로 탈출
 *
 input
 5 6
 1 0 1 0 1 0
 1 1 1 1 1 1
 0 0 0 0 0 1
 1 1 1 1 1 1
 1 1 1 1 1 1
 *
 * 탈출 시작 위치 1, 1
 * 한 번에 한 칸씩 이동 가능
 * 괴물이 있는 곳은 0으로 표시
 * 미로는 반드시 탈출 가능 함
 * 가장 최적의 탈출 경로를 구하시오
 * * * * * * * * * *
 *
 */
class Node {
    private int x;
    private int y;

    public Node(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}

public class Main5_2 {

    //bfs, 상하좌우 1이면 이동
    public static int[] dx = {-1, 1, 0, 0};
    public static int[] dy = {0, 0, -1, 1};
    public static int n;
    public static int m;
    public static int[][] arr;

    //BFS
    public static int bfs(int x, int y) {
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y));
        //큐가 빌 때까지 반복
        while(!q.isEmpty()) {
            Node node = q.poll();
            x = node.getX();
            y = node.getY();

            //4가지 방향 확인
            for (int i=0; i<dx.length; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                //갈 수 없는 경우 무시
                if(nx < 0 || nx >= n || ny < 0 || ny >= m) continue;

                //괴물을 만난 경우 갈 수 없음 무시
                if(arr[nx][ny] == 0) continue;

                if(arr[nx][ny] == 1) {
                    arr[nx][ny] = arr[x][y] +1;
                    q.offer(new Node(nx, ny));
                }
            }
        }
        return arr[n-1][m-1];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //행의 크기
        m = sc.nextInt(); //열의 크기
        arr = new int[n][m];

        //인덱스가 1부터 시작하기 때문에 전체 크기 + 1로 설정
        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println("최적의 거리 비용= " + bfs(0,0));

    }
}

package thisiscoding.java._05;

import java.util.Scanner;

/**
 * 문제: 음료수 얼려 먹기
 *
 * 얼음 갯수 판별, 상하좌우 연결된 얼음은 이어져서 1개의 얼음이 됨.
 *
 * [입력]
 7
 7
 1 1 0 0 0 1 0
 0 1 1 0 1 1 0
 0 1 0 0 0 0 0
 0 0 0 1 0 1 1
 1 1 0 1 1 0 0
 1 0 0 0 1 0 0
 1 0 0 0 1 0 0

 * [출력]
 * 5
 *
 */

public class Main5_1 {
    public static int n; //얼음판 행 크기
    public static int m; //얼음판 열 크기
    public static int[][] arr;
    //좌표 이동 L, R, U, D
    public static int[] dx = {0, 0, -1, 1};
    public static int[] dy = {-1, 1, 0, 0};

    public static void dfs(int x, int y) {

        for(int i=0; i<dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            //인접한 L, R, U, D 부분을 확인하여 방문 처리한다.
            if(nx >=0 && nx < n && ny >=0 && ny <m && arr[nx][ny] == 1) {
                arr[nx][ny] = 0; //visit
                dfs(nx, ny);
            }
        }
    }

    public static int solution() {
        int answer = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                //얼음 시작점을 만나면 인접한 아이들은 DFS내에서 퍼져나가며 0으로 바꿔줄테니 전체 갯수1개를 증가시킨다.
                if (arr[i][j] == 1) {
                    answer++;
                    arr[i][j] = 0;
                    dfs(i, j);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n][m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        System.out.println(solution());
    }
}

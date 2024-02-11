package thisiscoding.java._04;

/**
 * 게임 개발 
 */
public class Main4_4 {
    public static void main(String[] args) {
        //맵 생성
        //현재 위치 입력 받고
        //육지, 바다 맵 셋팅
        //0: 북, 1:동, 2:남, 3: 서

        //answer: 방문한 칸의 개수 (2차원 배열로 저장 필요)
        //4 x 4맵 생성
        //(1, 1)에 북쪽을 바라보고 서 있는 캐릭터
        int n = 4; //맵 크기
        int x = 1; //초기 x 좌표
        int y = 1; //초기 y 좌표
//        int beforeX = 0;
//        int beforeY = 0;
        int nowDirection = 0;

        //반시계 방향으로 셋팅
        char[] direction = {'L', 'R', 'U', 'D'};
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        int[][] map = {
                {1,1,1,1},
                {1,0,0,1},
                {1,1,0,1},
                {1,1,1,1}};

        int[][] visited = new int[4][4];

        int answer = 0;

        //처음 시작 지점 육지인 경우 check
        if (map[x][y] == 0) {
            answer = 1;
            visited[x][y] = 1;
        }


        boolean isNotComplete = true;

        while (isNotComplete) {
            //현재 바라 보고 있는 방향부터 시작
            for(int i=0; i<dx.length; i++) {
                int nextX = x + dx[nowDirection];
                int nextY = y + dy[nowDirection];

                nowDirection = ++nowDirection % 4; //다음 방향 지정 (반 시계 방향)
//                System.out.println("nowDirection = " + nowDirection);

                if(nextX > 0 && nextX < n && nextY > 0 && nextY < n) {
                    if(map[nextX][nextY] == 0 && visited[nextX][nextY] != 1) { //육지이면서, 방문한 적이 없는 경우
                        answer ++; //처음 진입
                        visited[nextX][nextY] = 1; //방문 체크
                        x = nextX;
                        y = nextY;
                        System.out.println(x + "," + y + "check");
                        break;
                    }
                }

                // 4 방향 모두 확인 했는데 갈 곳이 없는 경우
                if(i == dx.length - 1) {
                    //현재 방향에서 뒤로 가려는 방향 셋팅
                    if(nowDirection == 0 || nowDirection == 1) {
                        nowDirection += 2;
                    } else {
                        nowDirection -=2;
                    }

                    nextX = x + dx[nowDirection];
                    nextY = y + dy[nowDirection];

                    //뒤로 가려는 곳 이 바다라면 게임 종료
                    if(map[nextX][nextY] == 1) {
                        isNotComplete = false;
                    }
                }
            }
        }
        System.out.println("answer = " + answer);
    }
}

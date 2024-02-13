package thisiscoding.java._04;

import java.util.HashMap;

/**
 * 상하좌우
 */
public class Main4_1 {
    public static void main(String[] args) {
        int n = 5; //공간의 크기
        char[] plans = {'R', 'R', 'R', 'U', 'D', 'D'};
        int x = 1;
        int y = 1;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        HashMap<Character, Integer> moveMap = new HashMap<>();
        moveMap.put('L', 0);
        moveMap.put('R', 1);
        moveMap.put('U', 2);
        moveMap.put('D', 3);

        for(int i=0; i<plans.length; i++) {
            int idx = moveMap.get(plans[i]); //이동 방향 문자를 받아와 매핑되는 인덱스를 찾는다.
            int nx = x + dx[idx];
            int ny = y + dy[idx];

            //벽을 만난 경우 이동하지 않고 무시
            if(nx < 1 || ny <1 || nx > n || ny >n) {
                continue;
            }

            x = nx;
            y = ny;
        }

        System.out.println(x+", "+y);
    }
}

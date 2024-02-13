package thisiscoding.java._04;

/**
 * 왕실의 나이트
 * 8X8 좌표 평면에서 현재 위치가 주어진 경우 이동 가능한 경우의 수?
 *
 * 1. 수평으로 2칸 이동 후, 수직으로 1칸 이동
 * 2. 수직으로 2칸 이동 후, 수평으로 1칸 이동
 * *
 */
public class Main4_3 {
    public static void main(String[] args) {
        String initLocation = "c2";

        int x = initLocation.charAt(1) - '0'; //Row
        int y = initLocation.charAt(0) - 'a' + 1; //char 문자열을 int 값으로 변경 후 시작 점 1부터 시작 대입 //column

        System.out.println("initY = " + y);
        System.out.println("initX = " + x);

        //이동 가능한 케이스 정리
        int[] dx = {-2, 2, -1, 1, 2, -2, 1, -1};
        int[] dy = {-1, 1, -2, 2, -1, 1, -2, 2};

        int answer = 0;

        for(int i=0; i<dx.length; i++) {
            if(x+dx[i] > 0 && x+ dx[i] < dx.length && y+dy[i] > 0 && y + dy[i] < dx.length) {
                answer++;
            }
        }
        System.out.println("answer = " + answer);
    }
}

package thisiscoding.java._03;

import java.util.HashMap;

public class Main3_P1 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        //총 학생의 수: n
        //체육복을 도난당한 학생: lost
        //여벌의 체육복을 갖고 있는 학생: reserve
        //*여벌의 체육복을 갖고 있는 학생 또한 체육복을 도난 당한경우도 포함해야한다.
        HashMap<Integer, Integer> maps = new HashMap<>();

        //기본 셋팅 Start
        //학생 당 1개의 체육복 기본 값 셋팅
        maps.put(0, 0);
        maps.put(n+1, 0);

        for(int i=1; i<=n; i++) {
            maps.put(i, 1);
        }

        //체육복을 도난 당한 학생의 보유 체육복 수 차감
        for(int lst: lost) {
            maps.put(lst, maps.get(lst) - 1);
        }

        //여분의 체육복을 가져 온 학생의 보유 체육복 수 증가
        for(int rsv: reserve) {
            maps.put(rsv, maps.get(rsv) + 1);
        }

        for(int i=0; i<=n; i++) {
            System.out.println("기본 셋팅" + maps.get(i));
        }

        //기본 셋팅 End
        for(int i=1; i<=n; i++) {
            //체육복이 있다면 답 추가
            if(maps.get(i) >= 1) {
                System.out.println(i + "번째 학생 체육복 있음 답 추가" + maps.get(i));
                answer++;
                continue;
            }

            //체육복이 없다면, 옆 친구들 확인
            if(maps.get(i) < 1) {
                System.out.println(i + "번째 학생 체육복 없음 빌릴 친구 있나?" + maps.get(i));
                if(maps.get(i-1) > 1) {
                    maps.put(i-1, maps.get(i-1) - 1);
                    System.out.println(i + "번째 학생 왼쪽 친구에게 빌릴게" + maps.get(i));
                } else if(maps.get(i+1) > 1) {
                    maps.put(i+1, maps.get(i+1) - 1);
                    System.out.println(i + "번째 학생 오른쪽 친구에게 빌릴게" + maps.get(i));
                } else {
                    System.out.println(i + "번째 학생 체육복 빌릴 친구 없음" + maps.get(i));
                    continue;
                }
                //아래 한줄 없어도 답 출력과는 무관함
                maps.put(i, 1);
                answer ++;
            }
        }

        for(int i=1; i<=n; i++) {
            System.out.println(maps.get(i));
        }

        return answer;
    }
}

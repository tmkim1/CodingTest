package thisiscoding.java._04;

/**
 * 문자열 압축
 */
public class Main4_7 {

    public int solution(String s) {
        int answer = s.length();
        char[] charArr = s.toCharArray();
        StringBuilder sb = new StringBuilder();

        //문자열의 반복을 확인하는 것이기 때문에 문자열 길이 / 2 까지만 반복하면 된다.
        //2개 단위 ~ 길이 /2 까지의 단위로 나눠서 문자를 요약해본다.
        //가장 짧은 길이의 문자 요약 구문을 찾는다.
        String before = "";
        String now = "";
        String lastAppendStr = "";
        int divideLength = s.length()/2;

        //구분 단위 반복
        for(int i=1; i<divideLength+1; i++) {
            int cnt = 1;

            //전체 문자열 안에서 특정 구분 길이로 반복되는 부분 확인
            for(int j=i; j<=s.length(); j+=i) {
                before = s.substring(j-i, j);
                now = j+i <= s.length() ? s.substring(j, j+i) : s.substring(j);

                if(before.equals(now)) {
                    System.out.println("같은 문자: before:" + before + ", now:" + now);
                    cnt++;
                } else {
                     System.out.println("before:" + before + ", now:" + now);

                    //다음 문자열과 같지 않고, 이전에 반복된 값이 있다면 반복된 숫자와 함께 현재 문자열을 추가한다.
                    if(cnt > 1) {
                        sb.append(cnt);
                        sb.append(before);

                        lastAppendStr = before;
                        cnt = 1;
                    } else {
                        //다음 문자열이랑 같지도 않고, 이전 추가된 문자열도 같지 않다면 현재 문자열만 추가한다.
                        if(!lastAppendStr.equals(before)) {
                            System.out.println("단독 문자열:" + before + ", now:" + now);
                            sb.append(before);
                        };
                    }
                }

                if(j+i > s.length()) {
                    System.out.println("마지막 확인 문자열 before:" + before + ", now:" + now);
                    if(cnt > 1) sb.append(cnt);
                    sb.append(now);
                }
            }
            answer = Math.min(answer, sb.length());
            //System.out.println("sb:" + sb);
            sb.setLength(0);
        }
        return answer;
    }
}

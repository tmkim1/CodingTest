package thisiscoding.java._04;

/**
 * 럭키 스트레이트
 * 게임 내에서 점수가 특정 조건을 만족할 때만 사용 가능
 * 조건 1) N의 자릿수는 항상 짝수
 * 왼쪽 자릿수의 합과 오른쪽 자릿수의 합을 더한 값이 동일하면 기술 사용 가능
 * ex) 123402 = (1+2+3) == (4+0+2)
 * 스테이트 사용 가능 = "LUCKY" else "READY"
 */
public class Main4_5 {
    public static void main(String[] args) {
        int n = 123402;
        int leftSum = 0;
        int rightSum = 0;

        String numStr = String.valueOf(n);

        for(int i=0; i<numStr.length(); i++) {
            if(i < numStr.length()/2 ) {
                leftSum += numStr.charAt(i) - '0';
            } else {
                rightSum += numStr.charAt(i) - '0';
            }
        }

        System.out.println("leftSum = " + leftSum + ", rightSum = " + rightSum);

        if(leftSum == rightSum) {
            System.out.println("LUCKY");
        } else {
            System.out.println("READY");
        }
    }
}

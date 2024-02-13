package thisiscoding.java._04;


import java.util.Arrays;

/**
 * 문자열 재정렬
 * 알파벳 대문자와 숫자로만 구성된 문자열이 입력으로 주어진다
 * 이때 모든 알파벳을 오름차순으로 정렬하여 이어서 출력하고 모든 숫자를 더한 값을 이어서 출력한다.
 * ex) AJKDLSI412K4JSJ9D -> ADDIJJJKKLSS20
 */
public class Main4_6 {
    public static void main(String[] args) {
        String str = "AJKDLSI412K4JSJ9D";
        StringBuilder sb = new StringBuilder();
        int sum = 0;

        //char 배열로 변환 후, 정렬 --| 정렬 우선 순위는 숫자 오름차순, 알바펫 오름차순
        char[] charArr = str.toCharArray();
        Arrays.sort(charArr);

        for(int i=0; i<charArr.length; i++) {
            //숫자라면 합을 구한다.
            if(charArr[i] >= '0' && charArr[i] <= '9') {
                sum += charArr[i] - '0';
            } else { //숫자가 아니라면 이후에 나오는 값은 모두 알파벳이기 때문에, 알파벳과 구한 sum을 합쳐서 답을 출력한다.
                sb.append(charArr[i]);
            }
        }

        sb.append(sum);
        System.out.println("sb = " + sb);

    }
}

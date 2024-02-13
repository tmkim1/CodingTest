package thisiscoding.java._04;

/**
 * 시각
 * 3이 하나라도 들어가는 시간 카운트
 * 00시 00분 00초 ~ N시 59분 59까지의 모든 시각
 *
 * input: 5,
 * answer: 11475
 */
public class Main4_2 {

    public static void main(String[] args) {

        //000000 ~ 055959
        int n = 5;
        int date = 000000;
        String dateStr="";
        int answer = 0;

        for(int h=0; h<=n; h++) {
            for(int m=0; m<60; m++) {
                for(int s=0; s<60; s++) {
                    dateStr = "" + h + m +s;
                    if(dateStr.contains("3")) {
                        System.out.println("dateStr = " + dateStr);
                        answer ++;
                    };
                }
            }
        }

        System.out.println("answer = " + answer);
    }


}

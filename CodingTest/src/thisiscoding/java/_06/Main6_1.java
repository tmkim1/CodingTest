package thisiscoding.java._06;

/**
 * 선택 정렬
 */
public class Main6_1 {
    public static void main(String[] args) {
        int n = 10;
        int[] arr = {7, 5, 9, 0, 3, 1, 6, 2, 4, 8};

        for(int i=1; i<n; i++) {
            for(int j=i; j>0; j--) {
                if(arr[j] < arr[j-1]) {
                    //swap
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                } else {
                    //자신보다 작은 데이터를 만나면 break;
                    break;
                }
            }
        }

        for(int i=0; i<n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
